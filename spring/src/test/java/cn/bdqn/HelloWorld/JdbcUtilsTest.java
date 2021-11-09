package cn.bdqn.HelloWorld;

import cn.bdqn.domain.User;
import cn.bdqn.utils.JdbcUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() throws Exception{
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        JdbcUtils jdbcUtils = (JdbcUtils) ac.getBean("jdbcUtils");
        ac.close();
    }
}
