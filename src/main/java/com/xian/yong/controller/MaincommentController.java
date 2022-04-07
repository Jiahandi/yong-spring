package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.yong.entity.Maincomment;
import com.xian.yong.mapper.MaincomnentMapper;
import com.xian.yong.service.MaincommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maincomment")
public class MaincommentController {
    @Autowired
    private MaincomnentMapper maincomnentMapper;

    @Autowired
    private MaincommentService maincommentService;
    @PostMapping
    public boolean save(@RequestBody Maincomment maincomment){return maincommentService.saveMaincomment(maincomment);}

    @GetMapping
    public List<Maincomment> findAll(
            @RequestParam(defaultValue = "") String subId,
            @RequestParam(defaultValue = "") String forumId,
            @RequestParam(defaultValue = "") String comOpenid){
        QueryWrapper<Maincomment> queryWrapper = new QueryWrapper<>();
        if(!"".equals(subId)){
            queryWrapper.like("sub_id",subId);
        }
        if(!"".equals(comOpenid)){
            queryWrapper.like("com_openid",comOpenid);
        }
        if(!"".equals(forumId)){
            queryWrapper.like("forum_id",forumId);
        }
        return maincommentService.list(queryWrapper);
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return maincommentService.removeById(id);
    }
}
