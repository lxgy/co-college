package net.seehope.college.util.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description:字符串采用bcyrpt加密工具类，
 * @Author：lxgy
 * @Date：2018-12-27
 */
public class BcryptEncodeUtil {

    private static final BCryptPasswordEncoder B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private BcryptEncodeUtil() {
    }

    private static BCryptPasswordEncoder getInstance() {
        return B_CRYPT_PASSWORD_ENCODER;
    }

    /**
     * @Description：字符串加密.
     * @param：password（需要被加密的字符串）
     * @return：加密过后的字符串
     */
    public static String encode(String str) {
        String encode_str = BcryptEncodeUtil.getInstance().encode(str);
        return encode_str;
    }

    /**
     * @Description：.
     * @param：password（未加密的字符串）
     * @param：encode_password（被加密的字符串）
     * @return：（未加密的字符串与加密的字符串经过解析对比是否相同）
     */
    public static boolean decode(String str, String encode_str) {
        boolean decode_str = BcryptEncodeUtil.getInstance().matches(str, encode_str);
        return decode_str;
    }


}

