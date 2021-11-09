package cn.bdqn.HelloWorld;

import cn.bdqn.helloworld.HelloWorld;
import cn.bdqn.service.PersonServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloWorldTest {

    // Spring就是一个大大的工厂
    // Spring容器：可以去保存很多很多的bean对象
    // Ioc容器
    @Test
    public void testHelloWorld() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld");
        helloWorld.info();
    }

    @Test
    public void testPersonServiceImpl() throws Exception{
        // 加载配置文件创建容器并不会导致bean的立即初始化
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory bf = new XmlBeanFactory(resource); // 懒加载的模式

        // 只有再去真正要使用的某个bean的时候才会初始化
//        PersonServiceImpl personService = (PersonServiceImpl) bf.getBean("personService");
//        System.out.println(personService);
    }

    @Test
    public void testPersonServiceImpl2() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
    }

    @Test
    public void testPersonServiceImplByFactory() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        PersonServiceImpl personService = (PersonServiceImpl) ac.getBean("personService");
        System.out.println(personService);
    }

    @Test
    public void testPersonServiceImplByFactory2() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        PersonServiceImpl personService = (PersonServiceImpl) ac.getBean("personService2");
        System.out.println(personService);
    }

    @Test
    public void testPersonServiceImplSingleton() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        PersonServiceImpl personService1 = (PersonServiceImpl) ac.getBean("personService");
        PersonServiceImpl personService2 = (PersonServiceImpl) ac.getBean("personService");
        PersonServiceImpl personService3 = (PersonServiceImpl) ac.getBean("personService");
        System.out.println(personService1);
        System.out.println(personService2);
        System.out.println(personService3);
    }

    @Test
    public void testPersonServiceImplSingletonLife() throws Exception{
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        PersonServiceImpl personService = (PersonServiceImpl) ac.getBean("personService");
        ac.close();
    }
}
