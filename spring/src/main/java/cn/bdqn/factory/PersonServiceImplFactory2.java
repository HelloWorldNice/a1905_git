package cn.bdqn.factory;

import cn.bdqn.service.PersonServiceImpl;

public class PersonServiceImplFactory2 {
    // 此时通过工厂提供的静态方法创建对象
    public static PersonServiceImpl createBean(){
        return new PersonServiceImpl();
    }
}
