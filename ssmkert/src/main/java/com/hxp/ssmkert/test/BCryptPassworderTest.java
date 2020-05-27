package com.hxp.ssmkert.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 13:26
 * \
 */
public class BCryptPassworderTest {

    @Test
    public void test(){
        //加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验原始密码和BCrypt密码一直
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$K3D/GQy3zwAKm8vH9NGTVOgNhqQttZ0yBnPPJ/8JKEE8ym.75K7XK");
        System.out.println(checkpw);
    }
}
