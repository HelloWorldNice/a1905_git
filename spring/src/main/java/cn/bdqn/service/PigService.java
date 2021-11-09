package cn.bdqn.service;

import cn.bdqn.domain.Pig;
public interface PigService {

    // 保存猪
    public void save(Pig pig);

    // 更新
    public void update(Pig pig);

    // 查询
    public Pig queryById(Integer id);

    // 查询
    public Pig queryByNameAndSex(String username,String sex);
}
