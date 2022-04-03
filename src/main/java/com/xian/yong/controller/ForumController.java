package com.xian.yong.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.entity.Forum;
import com.xian.yong.mapper.ForumMapper;
import com.xian.yong.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {
    @Autowired
    private ForumMapper forumMapper;
    @Autowired
    private ForumService forumService;
    @PostMapping
    public boolean save(@RequestBody Forum forum){
        return forumService.saveForum(forum);
    }

    @GetMapping
    public List<Forum> findAll(@RequestParam(defaultValue = "") String forumTitle){
        QueryWrapper<Forum> queryWrapper = new QueryWrapper<>();
        if(!"".equals(forumTitle)){
            queryWrapper.like("forum_title",forumTitle);
        }
        return forumService.list(queryWrapper);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return forumService.removeById(id);
    }

    @GetMapping("/page")
    public IPage<Forum> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String forumName,
                                    @RequestParam(defaultValue = "") String forumTitle,
                                    @RequestParam(defaultValue = "") String forumCategoryid
    ){
        IPage<Forum> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Forum> queryWrapper = new QueryWrapper<>();
        if(!"".equals(forumName)){
            queryWrapper.like("forum_name",forumName);
        }
        if(!"".equals(forumTitle)){
            queryWrapper.like("forum_title",forumTitle);
        }
        if(!"".equals(forumCategoryid)){
            queryWrapper.like("forum_categoryid",forumCategoryid);
        }
        queryWrapper.orderByDesc("forum_pageview");
        return forumService.page(page,queryWrapper);
    }
}
