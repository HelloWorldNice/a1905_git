package cn.bdqn.mapper;

import cn.bdqn.domain.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    // 根据id查询员工
    public Employee queryById(Integer id);

    // 添加员工
    public void save(Employee employee);

    // 根据员工名和性别查询员工
    public Employee queryByNameAndSex(@Param("empName") String empName, @Param("sex") String sex);

    // 根据员工名和性别查询员工
    public Employee queryByNameAndSex_2(Employee employee);

    // 根据员工名和性别查询员工(使用Map方式)
    public Employee queryByNameAndSex_3(Map<String,Object> params);

    // 根据ids查询员工
    public List<Employee> queryByIds(@Param("ids") List<Integer> ids);

    // 根据ids查询员工
    public List<Employee> queryByIds_2(@Param("xx") Integer[] ids);

    // 根据员工id查询员工信息，返回值是一个Map,这个Map就是某个具体的员工对象
    public Map<String,Object> queryByIdReturnMap(Integer id);

    // 根据列表，返回的值是一个List<Map<String,Object>>
    public List<Map<String,Object>> queryByIds_3(Integer[] ids);

    // 根据列表，返回的值是一个Map<String,Object>
    @MapKey("id")
    public Map<Integer,Employee> queryByIds_4(Integer[] ids);

    //--------------------------------------------------

    // 根据员工id查询员工,并且查询员工所管理的部门
    public Employee queryByIdAndDept(Integer id);

    // 根据员工id查询员工,并且查询员工所管理的部门
    public Employee queryByIdAndDept_2(Integer id);

    // 根据员工id查询员工,并且查询员工所管理的部门
    public Employee queryByIdAndDept_3(Integer id);

    // -----------------------------------------------

    // 根据部门id查询该部门下的所有员工
    public List<Employee> queryByDeptId(Integer deptId);

    // -----------------------------------------------

    // 根据员工姓名、邮箱、家庭住址、性别模糊查询员工信息
    public List<Employee> queryByCondition(Employee employee);

    // 根据员工id更新员工信息【可能更新全部字段或者更新部分字段】
    public void updateById(Employee employee);

    // 根据员工id列表查询员工信息
    public List<Employee> queryByIds_ForEach(Integer[] ids);

    // 根据员工id列表查询员工信息
    public List<Employee> queryByIds_ForEach_List(List<Integer> ids);

    // 根据员工id列表和性别查询员工信息
    public List<Employee> queryByMap(Map<String,Object> paramMap);

    // 批量保存员工
    public void insertBatch(@Param("employees") List<Employee> employees);

    // 批量保存员工方式2
    public void insertBatch_2(@Param("employees") List<Employee> employees);

    // 测试缓存
    public Employee queryById_Cache(Integer id);
}
