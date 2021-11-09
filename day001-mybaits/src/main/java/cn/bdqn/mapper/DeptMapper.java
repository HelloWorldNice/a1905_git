package cn.bdqn.mapper;

import cn.bdqn.domain.Dept;

public interface DeptMapper {
    // 根据部门id查询部门信息
    public Dept queryById(Integer id);

    // 根据部门id查询部门信息[一对多的查询]
    public Dept selectById(Integer id);

    // 根据部门id查询部门信息【分步查询】
    public Dept selectByIdSteps(Integer id);
}
