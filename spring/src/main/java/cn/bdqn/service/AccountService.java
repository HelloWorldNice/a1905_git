package cn.bdqn.service;

public interface AccountService {
    // 转账
    public void transfer(Integer srcAccount,Integer destAccount,Integer money);
}
