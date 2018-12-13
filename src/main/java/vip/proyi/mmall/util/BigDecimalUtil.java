/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: BigDecimalUtil
 * Author: ProYI
 * Date: 2018-12-11 22:32
 * Description: 运算工具类
 */


package vip.proyi.mmall.util;


import java.math.BigDecimal;

/**
 * 〈运算工具类〉
 *  解决Java运算丢失精度问题
 * @author ProYI
 * @create 2018-12-11
 */

public class BigDecimalUtil {
    private BigDecimalUtil() {

    }

    /**
    * 加法
    * @param v1
    * @param v2
    * @return
    */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }

    /**
     * 减法
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    /**
     * 乘法
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    /**
     * 除法
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //除不尽 四舍五入，保留两位小数
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
    }
}