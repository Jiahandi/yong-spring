package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")//设置对应数据库名
//创建实体类名User和数据库对应
public class User {

    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String email;
    private String createtime;

    @TableField(value="avatar_url")
    private String avatar;
}
