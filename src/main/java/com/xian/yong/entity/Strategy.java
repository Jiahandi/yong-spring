package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Strategy {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer strategyId;
    private String straUser;
    private String straTitle;
    private String straScenic;
    private Integer straThemeid;
    private String straThemename;
    private String straContent;
    private Date straTime;
    private String straLove;
    private String straCollect;
}
