package cn.bdqn.service;

import cn.bdqn.dao.AccountDao;
import cn.bdqn.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional
    public void transfer(Integer srcId, Integer destId, Integer money) {

        // 第一步：获取源账号
        Account srcAccount = accountDao.selectById(srcId);
        Integer srcBalance = srcAccount.getBalance();
        srcAccount.setBalance(srcBalance - money);
        // 更新
        accountDao.updateById(srcAccount);

        int x = 1 / 0;

        // 第二步：获取目标账号
        Account destAccount = accountDao.selectById(destId);
        Integer destBalance = destAccount.getBalance();
        destAccount.setBalance(destBalance + money);
        // 更新
        accountDao.updateById(destAccount);
    }

    public Account login(String username,String pwd){
        return null;
    }

    public void register(Account account){

    }

    public Integer getBalance(Integer id){
        return 0;
    }
}

// 如果你的业务类中有大量的需要事务的方法，那么建议你直接把@Transactional加在类上
// 个别不需要事务的方法，就单独配置 @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)

// 如果你的业务类中有极个别的方法需要事务，大部分都不需要事务，
// 建议直接在方法上添加@Transactional即可
