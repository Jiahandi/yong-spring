package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Scenic {
    @TableId(type = IdType.AUTO) //指定主键类型
    private Integer scenicId;
    private String scePicture;
    private String sceName;
    private String sceIntro;
    private String sceAddress;
    private String sceOpentime;
    private Integer sceThemeid;
    private String sceThemename;
    private Double sceScore;
    private Double scePrice;
    private String sceTel;
}
