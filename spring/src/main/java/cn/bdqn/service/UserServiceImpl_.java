package cn.bdqn.service;

import cn.bdqn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl_ implements UserService{

    // 就可以从Spring容器中去找到UserDao这么一种类型的对象，从而完成注入
    @Resource(name = "userDao2")
    private UserDao userDao;

    @Override
    public void printUserDao() {
        System.out.println("userDao--->" + userDao);
    }
}
