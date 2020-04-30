package com.hql.tool.config.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @program: tool
 * @description: 同步数据库表结构
 * @author: Zj
 * @create: 2020-06-02 11:14
 **/
public class
CompareDatabase {

    //数据库驱动
    private final String driverName = "com.mysql.cj.jdbc.Driver";

    //基准表配置
    private final String dataBaseHostOriginal = "";
    private final String userNameOriginal = "";
    private final String passwordOriginal = "";
    private final String dataBase = "";
    private Connection originalConn = null;
    //对比表配置
    private final String dataBaseHostCompare = "";
    private final String userNameCompare = "";
    private final String passwordCompare = "";
    private final String dataBaseNew ="";
    private Connection compareConn = null;

    private final Boolean chooseAllTables = true;
    //需要进行对比的表
    private final String arrayTable[] = {"",""};


    //获取链接数据库地址
    public String getUrl(String dataBaseHost,String dataBase){
        return  "jdbc:mysql://" + dataBaseHost +"/"+ dataBase + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    }
    //链接数据库
    public Connection connectDataBase(String url,String user,String password) throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //初始化链接
    public void connectAllDataBase() throws ClassNotFoundException, SQLException {
        //链接基准数据库
        originalConn = connectDataBase(getUrl(dataBaseHostOriginal,dataBase),userNameOriginal ,passwordOriginal);
        //链接对比数据库
        compareConn = connectDataBase(getUrl(dataBaseHostCompare,dataBaseNew),userNameCompare,passwordCompare);
    }

    //获取数据库中的所有表
    private List<String> getAllTable(Connection conn ) throws SQLException {
        List<String> tableList = new ArrayList<>();
        PreparedStatement pstate = conn.prepareStatement("SHOW TABLE STATUS WHERE COMMENT !='VIEW'");
        ResultSet results = pstate.executeQuery();
        while ( results.next() ) {
            String tableName = results.getString("NAME");//表名
            tableList.add(tableName);
        }
        return tableList;
    }

    private List<String> getTableColumns(Connection conn,String table,String dataBase) throws SQLException {
        List<String> tableColumns = new ArrayList<>();
        PreparedStatement pstate = conn.prepareStatement("SELECT TABLE_NAME,COLUMN_NAME, COLUMN_TYPE, COLUMN_COMMENT FROM information_schema.columns" +
                " WHERE table_name='"+table+"'"
                +"AND TABLE_SCHEMA = '"+dataBase + "';"
        );
        ResultSet results = pstate.executeQuery();
        while ( results.next() ) {
            String columnName = results.getString("COLUMN_NAME");
            String columnType = results.getString("COLUMN_TYPE");
            tableColumns.add(columnName);
        }
        return tableColumns;
    }

    private  Map<String,Map<String,String>> getTableColumnsType(Connection conn,String table,String dataBase) throws SQLException {
        Map<String,Map<String,String>> thisTableMap = new HashMap<>();
        PreparedStatement pstate = conn.prepareStatement("SELECT TABLE_NAME,COLUMN_NAME, COLUMN_TYPE, COLUMN_COMMENT FROM information_schema.columns" +
                " WHERE table_name='"+table+"'"
                +"AND TABLE_SCHEMA = '"+dataBase + "';"
        );
        ResultSet results = pstate.executeQuery();
        while ( results.next() ) {
            Map<String , String > map = new HashMap<>();
            String tableName = results.getString("TABLE_NAME");
            String columnName = results.getString("COLUMN_NAME");
            String columnType = results.getString("COLUMN_TYPE");
            String columnComment = results.getString("COLUMN_COMMENT");
            map.put("TABLE_NAME",tableName);
            map.put("COLUMN_NAME",columnName);
            map.put("COLUMN_TYPE",columnType);
            map.put("COLUMN_COMMENT",columnComment);
            thisTableMap.put(columnName,map);
        }
        return thisTableMap;
    }

    //创建差异表
    public void createDiffTables() throws Exception{
        connectAllDataBase();
        //取出对比数据库中不存在的表
        List<String> originalConnList = getAllTable(originalConn);
        List<String> compareConnList = getAllTable(compareConn);
        originalConnList.removeAll(compareConnList);
        List<String> list = originalConnList;
        list.forEach(
                e->{
                    for(String str :arrayTable){
                        if(e.toLowerCase().indexOf(str) > -1 || chooseAllTables){
                            try{
                                String showTablSQL = "SHOW CREATE TABLE " + e +";";
                                PreparedStatement pstate = originalConn.prepareStatement(showTablSQL);
                                ResultSet results = pstate.executeQuery();
                                String createSQL = null;
                                while (results.next()){
                                    createSQL =results.getString("Create Table");
                                }
                                Statement stmt = compareConn.createStatement();
                                Long qty = stmt.executeLargeUpdate(createSQL);
                                if(qty ==0){
                                    System.out.println(e + "表创建成功");
                                }else {
                                    System.out.println(e + "表创建失败");
                                }
                            }catch (Exception ex){
                                ex.printStackTrace();
                            }
                            if(chooseAllTables){
                                break;
                            }
                        }
                    }
                }
        );
        //关闭链接
        originalConn.close();
        compareConn.close();
    }

    //插入差异列
    public void createDiffTablesColumns() throws Exception {
        connectAllDataBase();
        //取出基准表中的所有table
        List<String> originalConnList = getAllTable(originalConn);
        originalConnList.forEach(
                table -> {
                    for(String str :arrayTable){
                        if(table.toLowerCase().indexOf(str) > -1 || chooseAllTables){
                            try{
                                Map<String ,Map<String,String>> thisTableMap = getTableColumnsType(originalConn,table,dataBase);
                                List<String> listOriginal = getTableColumns(originalConn,table,dataBase);
                                List<String> listCompare = getTableColumns(compareConn,table,dataBaseNew);
                                listOriginal.removeAll(listCompare);

                                List<String> diffColums = listOriginal;
                                StringBuffer alterTableSQL =new StringBuffer( "ALTER TABLE "+table+" ");
                                diffColums.forEach(
                                        e ->{
                                            if(diffColums.get(0).equals(e)){
                                                alterTableSQL.append("ADD COLUMN "+thisTableMap.get(e).get("COLUMN_NAME")+ " "
                                                        + thisTableMap.get(e).get("COLUMN_TYPE") + " COMMENT \"" + thisTableMap.get(e).get("COLUMN_COMMENT") + "\"");
                                            }else{
                                                alterTableSQL.append(",ADD COLUMN "+thisTableMap.get(e).get("COLUMN_NAME")+ " "
                                                        + thisTableMap.get(e).get("COLUMN_TYPE") + " COMMENT \"" + thisTableMap.get(e).get("COLUMN_COMMENT") + "\"");
                                            }
                                        }
                                );
                                String strCompare = "ALTER TABLE "+table+" ";
                                if(!alterTableSQL.toString().equals(strCompare)){
                                    Statement stmt = compareConn.createStatement();
                                    Long qty = stmt.executeLargeUpdate(alterTableSQL.toString());
                                    if(qty ==0){
                                        System.out.println(table + "表新增列成功");
                                    }else {
                                        System.out.println(table + "表新增列失败");
                                    }
                                }


                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );
        //关闭链接
        originalConn.close();
        compareConn.close();
    }


    public static void main( String[] args ) throws Exception{
        CompareDatabase compareDatabase = new CompareDatabase();
        compareDatabase.createDiffTables();
        compareDatabase.createDiffTablesColumns();
    }

}
