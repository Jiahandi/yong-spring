package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
//创建实体类名User和数据库对应
public class UserDto {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer id;
    private String openId;
    private String username;
    private String tel;
    private String email;
    private String createtime;
    private String avatar;
}