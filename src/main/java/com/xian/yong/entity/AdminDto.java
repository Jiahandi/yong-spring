package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class AdminDto {
    private Integer adid;
    private String adname;
    private String adpassword;
    private Integer type;

    @TableField(value="type_name")
    private String typename;
    private String token;
}
