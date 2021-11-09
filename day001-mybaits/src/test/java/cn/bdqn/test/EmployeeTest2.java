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

public class EmployeeTest2 {

    @Test
    public void testSelectById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryById(1);

        System.out.println(employee);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testSave() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setEmpName("qq");
        employee.setAddress("zz");
        employee.setEmail("xx@qq.com");
        employee.setBirthday(new Date());
        employee.setSex("女");
        employeeMapper.save(employee);

        session.commit();
        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByNameAndSex() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryByNameAndSex("Hello","m");

        System.out.println(employee);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByNameAndSex_2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee emp = new Employee();
        emp.setEmpName("Hello");
        emp.setSex("m");
        Employee employee = employeeMapper.queryByNameAndSex_2(emp);

        System.out.println(employee);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByNameAndSex_3() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String,Object> maps = new HashMap<>();
        maps.put("empName","mybatis");
        maps.put("sex","女");
        Employee employee = employeeMapper.queryByNameAndSex_3(maps);

        System.out.println(employee);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIds() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(9);
        List<Employee> employees = employeeMapper.queryByIds(list);

        System.out.println(employees);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIds_2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Integer[] ids = {1,8};
        List<Employee> employees = employeeMapper.queryByIds_2(ids);

        System.out.println(employees);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIdReturnMap() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map<String,Object> maps = employeeMapper.queryByIdReturnMap(2);
        System.out.println(maps);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIds_3() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Integer[] ids = {1,6};
        List<Map<String,Object>> list = employeeMapper.queryByIds_3(ids);
        System.out.println(list);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIds_4() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Integer[] ids = {1,6};
        Map<Integer,Employee> maps = employeeMapper.queryByIds_4(ids);
        System.out.println(maps);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIdAndDept() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryByIdAndDept(4);
        System.out.println(employee);
//        System.out.println(employee.getDeptId());
//        System.out.println(employee.getDeptName());

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIdAndDept_2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryByIdAndDept_2(12);
        System.out.println(employee);
        System.out.println(employee.getDept().getId());
        System.out.println(employee.getDept().getDeptName());

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testQueryByIdAndDept_3() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.queryByIdAndDept_3(5);
        System.out.println(employee);
        System.out.println(employee.getDept().getId());
        System.out.println(employee.getDept().getDeptName());

        // 6、关闭资源
        session.close();
    }
}
