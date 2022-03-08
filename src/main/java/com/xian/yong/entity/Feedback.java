package com.xian.yong.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "feedback")//设置对应数据库名
public class Feedback {
    private Integer fbId;
    private String fbUser;
    private String fbContent;
    private String fbImage;
    private String fbTime;
}

