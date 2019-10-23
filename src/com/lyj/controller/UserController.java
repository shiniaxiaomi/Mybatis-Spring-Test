package com.lyj.controller;

import com.lyj.mapper.UserMapper;
import com.lyj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/10/23.
 */

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        User user = userMapper.getUser(1);
        System.out.println(user);

        return "hello";

    }

    @Transactional
    @RequestMapping("/insert")
    @ResponseBody
    public String insert(String name,int id) throws Exception {

        //自从Mybatis将sqlSession交由spring管理之后,session的commit就由spring来操作了
        //我们无需再关系提交和回滚的操作
        //当我们需要方法回滚时,可以在方法上添加Transactional注解来完成事务
        int i = userMapper.updateUser(name,id);

        if(i==1){
            //如果抛出了异常,那么spring就会帮我们回滚数据,因为我们在方法上添加了Transactional注解
            throw new Exception("1111");
        }

        return String.valueOf(i);

    }


}
