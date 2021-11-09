package cn.bdqn.test;

import cn.bdqn.domain.Employee;
import cn.bdqn.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.*;

public class EmployeeTest5 {

    @Test
    public void testSelectById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee e1 = employeeMapper.queryById_Cache(1);
        System.out.println(e1);

        // 手动的把一级缓存清空了【需求：就想获取最新数据 + 调整事务的隔离级别（读已提交）】
        session.clearCache();

        Employee e2 = employeeMapper.queryById_Cache(1);
        System.out.println(e2);

        session.close();
    }

    @Test
    public void testSelectById_2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee e1 = employeeMapper.queryById_Cache(1);
        System.out.println(e1);

        session.close();

        SqlSession session2 = factory.openSession();
        EmployeeMapper employeeMapper2 = session2.getMapper(EmployeeMapper.class);
        Employee e2 = employeeMapper2.queryById_Cache(1);
        System.out.println(e2);

        session2.close();
    }
}
