package net.seehope.college.util.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 字符串处理工具类
 * ====================================
 * @BelongsProject: co-college
 * @BelongsPackage: net.seehope.college.util.string
 * @Author: lxgy
 * @CreateTime: 2018-12-14 08:49
 */
public class StringUtil {
    /**
     * 判断字符串是否为空<br/>
     * =========================<br/>
     *
     * @param str
     * @return
     * @author:lxgy
     */
    public static boolean isEmpty(String str) {
        boolean bool = true;
        if (str != null && !str.equals("")) {
            bool = false;
        }
        return bool;
    }

    /**
     * 按照“，” 将字符串转换成相应的数组.<br/>
     * =================================<br/>
     *
     * @param str
     * @return
     */
    public static String[] split(String str) {
        return str.split(",");
    }

    /**
     * 按照既定格式，将字符串转换成数组<br/>
     * ===============================<br/>
     *
     * @param str
     * @param splitSign
     * @return
     */
    public static String[] split(String str, String splitSign) {
        if (str == null || splitSign == null) {
            return null;
        }
        return str.split(splitSign);
    }

    /**
     * 将字符串每个字符转换成相应的Ascall的值<br/>
     * ==================================<br/>
     *
     * @param str
     * @return
     */
    public static byte[] toByte(String str) {
        if (str == null) {
            return null;
        }
        byte[] by = str.getBytes();
        return by;
    }

    /**
     * 将int数组按照指定的分隔符转换成字符串<br/>
     * =========================<br/>
     *
     * @param arrs
     * @param separator
     * @return
     */
    public static String arrayToString(int[] arrs, String separator) {
        String ret = "";
        for (int i = 0; i < arrs.length; i++) {
            if (i < arrs.length - 1) {
                ret = ret + String.valueOf(arrs[i]) + separator;
            } else {
                ret = ret + String.valueOf(arrs[i]);
            }
        }
        return ret;
    }

    /**
     * 将字符串数组String[] 按照分隔符转换成字符串.<br/>
     * =================================<br/>
     *
     * @param arrs
     * @param separator
     * @return
     */
    public static String arrayToString(String[] arrs, String separator) {
        String ret = "";
        for (int i = 0; i < arrs.length; i++) {
            if (i < arrs.length - 1) {
                ret = ret + String.valueOf(arrs[i]) + separator;
            } else {
                ret = ret + String.valueOf(arrs[i]);
            }
        }
        return ret;
    }

    /**
     * 将字节数组转换为字符串<br/>
     * =======================<br/>
     *
     * @param arrs
     * @return
     */
    public static String toString(byte[] arrs) {
        if (arrs == null) {
            return null;
        }
        return new String(arrs);
    }

    /**
     * 将一个对象转换成字符串<br/>
     * =====================<br/>
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString().trim();
    }

    public static String toSting(String str) {
        if (str == null) {
            return null;
        }
        return str;
    }

    /**
     * 将字符串转换成list集合<br/>
     * ==================<br/>
     *
     * @param str
     * @return
     */
    public static List<String> strToList(String str) {
        /*逗号 空格 分号 换行*/
        final String URL_SPLIT_PATTERN = "[, ;\r\n]";
        if (str == null) {
            return null;
        }
        /*逗号或空格或分号或换行作为分隔符，将字符串转换成数组*/
        String[] arrs = str.split(URL_SPLIT_PATTERN);
        List<String> lists = new ArrayList<>();
        for (String list : arrs) {
            list = list.trim();
            if (list.length() == 0) {
                continue;
            }
            lists.add(list);
        }
        return lists;
    }


}
