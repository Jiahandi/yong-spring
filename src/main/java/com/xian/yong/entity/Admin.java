package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer adid;
    private String adpassword;
    private Integer type;

    @TableField(value="type_name")
    private String typename;

}
