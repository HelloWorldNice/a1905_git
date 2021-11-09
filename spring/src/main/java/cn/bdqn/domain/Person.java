package cn.bdqn.domain;

import java.util.Date;

public class Person {

    private Integer id;

    private String name;	// 姓名

    private Integer age;	// 年龄

    private Double weight;	// 体重

    private Date birthday;  // 出生日期

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 专门为weight属性定义的构造方法
    public Person(Integer id, String name, Double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    // 专门为birthday属性定义的构造方法
    public Person(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }


    @Override
    public String toString() {
            return "id:"+id+",name:"+name+",age:"+age + ",weight:" + weight + ",birthday=" + birthday;
    }
}
