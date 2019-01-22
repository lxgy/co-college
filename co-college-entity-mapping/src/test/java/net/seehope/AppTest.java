package net.seehope;

import static org.junit.Assert.assertTrue;

import net.seehope.college.entity.User;
import net.seehope.college.mapper.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Resource
    UserMapper mapper;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void getuser() {
        User user = mapper.get_user_detail_by_email("1315283983@qq.com");
        System.out.println(user);
    }
}