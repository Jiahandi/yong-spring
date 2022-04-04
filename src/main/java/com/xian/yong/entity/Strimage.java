package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "strimage")//设置对应数据库名
public class Strimage {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer id;
    private Integer strId;
    private String strPicture;
}
