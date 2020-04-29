package com.hql.tool.config.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 浮点型工具类
 * @Author: zk
 * @DateTime: 2020/4/28 16:52
 * @Description: TODO
 */
public final class BigDecimalUtil {

    private static final int DEF_DIV_SCALE = 4;

    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后多少位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *
     * @Title: BigDecimalUtil.java
     * @Package: com.haier.openplatform.cosmocg.util
     * @Description: 比较 double 是否相等
     * @author: Connor.M
     * @date: 2018年5月14日 下午6:36:46
     */
    public static boolean equals(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.compareTo(b2) == 0;
    }

    /**
     * 确定小数点位数
     * @param v
     * @param scale
     * @return
     */
    public static double round(double v, int scale) {
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     *
     *
     * @Description: 将double转string（包括科学计数法）
     * @date: 2018年8月1日 下午3:38:46
     * @throws
     */
    public static String doubleToStr(Double d, int scale) {
        if (d == null) {
            return "";
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);//不使用千分位
        nf.setMinimumFractionDigits(0);// 设置数的小数部分所允许的最小位数
        nf.setMaximumFractionDigits(scale);// 设置数的小数部分所允许的最大位数
        return nf.format(d);
    }
}
