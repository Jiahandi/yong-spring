package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "cardlist")//设置对应数据库名
public class Cardlist {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer id;
    private Integer userId;
    private Integer scenicId;
}
