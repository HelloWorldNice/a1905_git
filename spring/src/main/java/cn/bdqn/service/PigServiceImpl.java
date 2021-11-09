package cn.bdqn.service;

import cn.bdqn.domain.Pig;
import org.springframework.stereotype.Service;

@Service
public class PigServiceImpl implements PigService{
    @Override
    public void save(Pig pig) {
        System.out.println("保存了一只香猪....");
    }

    @Override
    public void update(Pig pig) {
        System.out.println("更新了一只猪....");
    }


    @Override
    public Pig queryById(Integer id) {
        System.out.println("根据id查询了一只猪");
        return new Pig();
    }
    @Override
    public Pig queryByNameAndSex(String username, String sex) {
        System.out.println("根据姓名和年龄查询一只猪");
        return new Pig();
    }
}
