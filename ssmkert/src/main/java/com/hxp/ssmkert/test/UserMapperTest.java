package com.hxp.ssmkert.test;

import com.hxp.ssmkert.mapper.UserMapper;
import com.hxp.ssmkert.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 18:14
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void userMapperTest1(){
        List<User> users = userMapper.selectList(null);//条件为null
        users.forEach(System.out::println);
    }
}
