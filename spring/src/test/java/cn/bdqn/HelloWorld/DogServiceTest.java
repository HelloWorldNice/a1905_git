package cn.bdqn.HelloWorld;

import cn.bdqn.domain.User;
import cn.bdqn.service.DogService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DogServiceTest {
    @Test
    public void testDogService() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        DogService dogService = (DogService) ac.getBean("dogService");
        System.out.println(dogService);
    }
}
