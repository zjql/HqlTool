package com.hql.tool.config.datasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author zhangzhijie
 * @description 密码回调类：解决druid集成多数据源数据库连接异常问题(多数据源需要重写密码回调)
 * 2020/4/30 13:42
 */
public class DbPasswordCallback extends DruidPasswordCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbPasswordCallback.class);

    /**
     * @param properties 属性值列表
     * @description:处理解密
     */
    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String password = (String) properties.get("password");
        String publickey = (String) properties.get("publickey");
        try {
            String dbpassword = ConfigTools.decrypt(publickey, password);
            setPassword(dbpassword.toCharArray());
        } catch (Exception e) {
            LOGGER.error("Druid ConfigTools.decrypt", e);
        }
    }
}
