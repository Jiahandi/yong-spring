package com.xian.yong.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "forum")//设置对应数据库名
public class Forum {
    private Integer forumId;
    private String forumName;
    private String forumTitle;
    private String forumTime;
    private Integer forumCategoryid;
    private String forumCategoryname;
    private String forumContent;
    private String forumPageview;
}
