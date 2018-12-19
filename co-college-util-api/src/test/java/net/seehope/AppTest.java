package net.seehope;

import static org.junit.Assert.assertTrue;

import net.seehope.college.util.date.DateTimeUtil;
import net.seehope.college.util.string.StringUtil;
import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws ParseException {
        Date date = DateTimeUtil.getDate("2018-12-25 17:5:20", "yyyy-MM-dd HH:mm:ss");
        int[] arrs = {1, 2, 3, 5, 8, 9, 10};
        List<String> list = StringUtil.strToList("kfjgi jifjgio;fjgi\r\nfjgijd\nfjkg");
        System.out.println(list);
    }
}
