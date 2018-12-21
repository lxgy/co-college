package net.seehope.college.util.uuid;

import java.util.UUID;

/**
 * @Description:随机字符串UUID工具类.
 * @Author：lxgy
 * @Date：2018-12-21
 */
public class UUIDUtil {

    /**
     * @Description:无处理uuid随机36位字符串.
     * @return
     */
    public static String get_uid_original(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * @Description:消除- 32位随机字符串
     * @return
     */
    public static String get_uuid_destroy_bar(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }

    /**
     * @Description:截取多少位字符串.
     * @param end [5-33）
     * @return
     */
    public static String get_uuid_intercept(int end) throws Throwable {
        if(end < 5 || end > 33){
            throw new Throwable("长度的值范围为：5<= length < 33");
        }
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","").substring(0,end);
    }

}
