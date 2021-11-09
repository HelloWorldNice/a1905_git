package cn.bdqn.HelloWorld;

import cn.bdqn.domain.Person;
import cn.bdqn.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void testUser() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
