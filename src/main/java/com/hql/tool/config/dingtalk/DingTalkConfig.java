package com.hql.tool.config.dingtalk;

import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

/**
 * @program: tool
 * @description: 钉钉工具类
 * @author: Zj
 * @create: 2020-06-16 15:12
 **/
@Data
@Component
public class DingTalkUtil {

    @Value("${dingTalk.secret}")
    private static String secret;
    
}

