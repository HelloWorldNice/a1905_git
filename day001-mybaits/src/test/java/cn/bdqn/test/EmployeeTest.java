package cn.bdqn.test;

import cn.bdqn.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class EmployeeTest {

    @Test
    public void testSelectAll() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.selectAll");

        // 5、循环遍历
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testSelectById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        Employee employee = session.selectOne("cn.bdqn.mapper.EmployeeMapper.selectById",1);

        System.out.println(employee);

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testSelectByLikeName1() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.selectByLikeName1","%Hello%");

        // 5、循环遍历
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testSelectByLikeName2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.selectByLikeName2","Hello");

        // 5、循环遍历
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testSelectByLikeName3() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.selectByLikeName3","Hello");

        // 5、循环遍历
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testSelectByLikeName4() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        List<Employee> employees = session.selectList("cn.bdqn.mapper.EmployeeMapper.selectByLikeName4","Hello");

        // 5、循环遍历
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testInsert() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        Employee employee = new Employee();
        employee.setEmpName("李四");
        employee.setAddress("新乡");
        employee.setBirthday(new Date());
        employee.setEmail("yubo@qq.com");
        employee.setSex("男");
        session.insert("cn.bdqn.mapper.EmployeeMapper.insert",employee);

        // 记得提交事务
        session.commit();

        System.out.println(employee.getId());

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testInsertReturnKey1() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        Employee employee = new Employee();
        employee.setEmpName("王五");
        employee.setAddress("新乡");
        employee.setBirthday(new Date());
        employee.setEmail("yubo@qq.com");
        employee.setSex("男");
        session.insert("cn.bdqn.mapper.EmployeeMapper.insertReturnKey1",employee);

        // 记得提交事务
        session.commit();

        System.out.println(employee.getId());

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testInsertReturnKey2() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        Employee employee = new Employee();
        employee.setEmpName("guoguo");
        employee.setAddress("新乡");
        employee.setBirthday(new Date());
        employee.setEmail("yubo@qq.com");
        employee.setSex("男");
        session.insert("cn.bdqn.mapper.EmployeeMapper.insertReturnKey2",employee);

        // 记得提交事务
        session.commit();

        System.out.println(employee.getId());

        // 6、关闭资源
        session.close();
    }

    @Test
    public void testDeleteById() throws Exception{
        // 1、读取mybatis主配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3、用SqlSessionFactory工厂去创建SqlSession【SqlSession ---> Connection数据链接】
        SqlSession session = factory.openSession();

        // 4、通过链接向数据库发送sql语句
        session.delete("cn.bdqn.mapper.EmployeeMapper.deleteById",10);

        // 记得提交事务
        session.commit();
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

        // 4、通过链接向数据库发送sql语句
        Employee employee = new Employee();
        employee.setId(5);
        employee.setEmpName("yangpeng");
        employee.setAddress("新乡");
        employee.setBirthday(new Date());
        employee.setEmail("yubo@qq.com");
        employee.setSex("男");
        session.update("cn.bdqn.mapper.EmployeeMapper.updateById",employee);

        // 记得提交事务
        session.commit();

        System.out.println(employee.getId());

        // 6、关闭资源
        session.close();
    }

}
