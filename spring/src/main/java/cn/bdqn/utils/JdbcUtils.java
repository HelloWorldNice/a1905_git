package cn.bdqn.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("prototype")
public class JdbcUtils {

    public JdbcUtils(){
        System.out.println("JdbcUtils创建好了");
    }

    @PostConstruct
    public void init(){
        System.out.println("对象初始化了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("对象销毁了");
    }

    // 注入基本的数据类型、包装类型、String
    @Value("${driverClass}")
    private String driverClass;

    @Value("${port}")
    private Integer port;

    public void info(){
        System.out.println(driverClass + port);
    }
}
