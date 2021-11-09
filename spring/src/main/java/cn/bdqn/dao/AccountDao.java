package cn.bdqn.dao;

import cn.bdqn.domain.Account;

public interface AccountDao {

    // 根据id获取一个账号信息
    public Account selectById(Integer id);

    // 根据id更新一个账号
    public void updateById(Account account);
}
