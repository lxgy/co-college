package net.seehope.cocollegewebview;

import net.seehope.college.util.security.BcryptEncodeUtil;
import org.junit.Test;

public class TestApp{

    @Test
    public void test(){
        String s = BcryptEncodeUtil.encode("lai0736207933...");
        System.out.println(s + "  " + s.length());
        System.out.println(BcryptEncodeUtil.decode("lai0736207933...",s));
    }
}
