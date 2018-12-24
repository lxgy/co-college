package net.seehope.college.util.number;

import java.math.BigDecimal;

/**
 * @Description：数字工具类.
 * @Author;lxgy
 * @date:2018-12-21
 */
public class NumberUtil {

    /**
     * @Description:任意个double类型相加，结果精确2位小数返回.
     * @param value1
     * @return
     */
    public static double addition(double... value1){
        BigDecimal v1 = new BigDecimal(0.00);
        for (double v:value1) {
            BigDecimal v2 = new BigDecimal(v);
            v1 = v1.add(v2);
        }
        return  v1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double addition(double value1,float... value2){
        BigDecimal v1 = new BigDecimal(value1);
        for(float v:value2){
            BigDecimal v2 = new BigDecimal(v);
            v1 = v1.add(v2);
        }
        return v1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double addition(double value1,String... value2){
        BigDecimal v1 = new BigDecimal(value1);
        for(String v:value2){
            BigDecimal v2 = new BigDecimal(v);
            v1 = v1.add(v2);
        }
        return v1.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }



    public static void main(String[] args){
        System.out.println(NumberUtil.addition(1.001,"2.5","2.6556","3.5614"));
    }
}
