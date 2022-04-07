package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "maincomment")//设置对应数据库名
public class Maincomment {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer comId;
    private Integer forumId;
    private String comName;
    private String comOpenid;
    private String comAvatar;
    private String comContent;
    private String comCreatetime;
}
