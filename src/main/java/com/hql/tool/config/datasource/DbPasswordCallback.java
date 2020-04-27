package com.hql.tool.config.datasource;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author zhangzhijie
 * 2020/4/27 18:02
 * @description:密码回调类：解决druid集成多数据源数据库连接异常问题(多数据源需要重写密码回调)
 */
@Slf4j
public class DbPasswordCallback extends DruidPasswordCallback {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbPasswordCallback.class);

    /**
     * 处理解密
     * @param properties
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
