package cn.bdqn.test;

import cn.bdqn.domain.Employee;
import cn.bdqn.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeTest4 {

    @Test
    public void testSelectById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee emp = new Employee();
//        emp.setEmpName("abc");
//        emp.setEmail("123@qq.com");
//        emp.setSex("男");
        List<Employee> employees = employeeMapper.queryByCondition(emp);
        System.out.println(employees);
        // 6、关闭资源
        session.close();
    }

    @Test
    public void testUpdateById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setId(13);
        employee.setEmpName("zzzz");
        employee.setEmail("zzz@163.com");
        employeeMapper.updateById(employee);

        session.commit();
        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIds_ForEach() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Integer[] ids = {1,3,5,8,12};
        List<Employee> employees = employeeMapper.queryByIds_ForEach(ids);
        System.out.println(employees);
        session.commit();
        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIds_ForEach_List() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(12);
        List<Employee> employees = employeeMapper.queryByIds_ForEach_List(ids);
        System.out.println(employees);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByMap() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(5);
        String sex = "男";

        Map<String,Object> maps = new HashMap<>();
        maps.put("ids",ids);
        // maps.put("sex",sex);

        List<Employee> employees = employeeMapper.queryByMap(maps);
        System.out.println(employees);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testInsertBatch() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setEmpName("react");
        e1.setSex("男");

        Employee e2 = new Employee();
        e2.setEmpName("微信小程序");
        e2.setSex("女");

        list.add(e1);
        list.add(e2);

        employeeMapper.insertBatch(list);

        System.out.println(e1.getId());
        System.out.println(e2.getId());

        session.commit();
        // 6、关闭资源
        session.close();
    }

    @Test
    public void testInsertBatch_2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setEmpName("xxxx");
        e1.setSex("男");

        Employee e2 = new Employee();
        e2.setEmpName("zzzz");
        e2.setSex("女");

        list.add(e1);
        list.add(e2);

        employeeMapper.insertBatch_2(list);

        System.out.println(e1.getId()); // 27
        System.out.println(e2.getId()); // null

        session.commit();
        // 6、关闭资源
        session.close();
    }
}
