package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "subcomment")//设置对应数据库名
public class Subcomment {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer subId;
    private Integer comId;
    private String comName;
    private String comOpenid;
    private String comAvatar;
    private String subName;
    private String subOpenid;
    private String subAvatar;
    private String subContent;
    private String subCreatetime;
}
