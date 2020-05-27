package com.hxp.ssmkert.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 18:12
 * 主键生成策略
 * \* AUTO	数据库ID自增
 * \* NONE	该类型为未设置主键类型
 * \* INPUT	用户输入ID，该类型可以通过自己注册自动填充插件进行填充
 * \* ID_WORKER	全局唯一ID (idWorker)
 * \* UUID	全局唯一ID (UUID)
 * \* ID_WORKER_STR	字符串全局唯一ID (idWorker 的字符串表示)
 */
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
