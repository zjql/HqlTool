package com.hql.tool.config.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.util.HtmlUtils;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 *
 * @Author: zk
 * @DateTime: 2020/4/28 17:00
 * @Description: TODO
 */
public final class StringUtil {

    public static boolean isEmpty(String str){
        if(str == null || "".equals(str)) return true;
        if("".equals(str.trim())) return true;
        return false;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 判断字符串中是否包含空格
     * @param str 目标字符串
     * @return
     */
    public static boolean hasBlank(String str) {
        if(isEmpty(str)) return true;
        return str.contains(" ");
    }

    /**
     * 去掉字符串中所有空格，去掉前后空格可以使用trim()
     * @param str 目标字符串
     * @return
     */
    public static String removeBlank(String str) {
        if(isEmpty(str)) return null;
        return str.replace(" ", "");
    }

    /**
     * 拼串
     * @param strings
     * @return
     */
    public static String mergeStr(String...strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 获取指定个数数字字符串
     * @param num 个数
     * @return
     */
    public static String getRanNum(Integer num) {
        String str = "";
        for(int i=0;i<num;i++) {
            str += (int)(Math.random()*10);
        }
        return str;
    }

    /**
     * 获取指定个数字符串
     * @param num 个数
     * @return
     */
    public static String getRanStr(Integer num) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String res = "";
        for(int i=0;i<num;i++) {
            int ranNum = random.nextInt(str.length());
            res += str.charAt(ranNum);
        }
        return res;
    }


}
