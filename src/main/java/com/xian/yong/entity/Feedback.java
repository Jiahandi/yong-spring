package com.xian.yong.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "feedback")//设置对应数据库名

public class Feedback {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer fbId;
    private String fbUser;
    private String fbContent;
    private String fbImage;
    private String fbTime;
}

