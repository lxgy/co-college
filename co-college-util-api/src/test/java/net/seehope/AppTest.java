package net.seehope;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;

import net.seehope.college.util.security.BcryptEncodeUtil;
import org.junit.Test;

import java.text.ParseException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws ParseException {
        String password="123456";
        String s =BcryptEncodeUtil.encode(password);
        System.out.println(BcryptEncodeUtil.decode(password,"$2a$10$druX8nvHCBkuyJ6rMhPrte77cJxDgb58B3LC1C8tlKr83rgoSJyOm"));
    }

}
