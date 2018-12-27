package net.seehope.cocollegewebview;

import net.seehope.college.util.security.BcryptEncodeUtil;
import org.junit.Test;

public class TestApp{

    @Test
    public void test(){
        String s = BcryptEncodeUtil.encode("123456");
        String s1 = BcryptEncodeUtil.encode("123456");
        System.out.println(s + "  " + s.length());
        System.out.println(BcryptEncodeUtil.decode("123456",s));
        System.out.println(BcryptEncodeUtil.decode("123456",s1));
    }
}
