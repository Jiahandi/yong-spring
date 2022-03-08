package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.Feedback;
import com.xian.yong.mapper.FeedbackMapper;
import com.xian.yong.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public boolean save(@RequestBody Feedback feedback){
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping
    public List<Feedback> findAll(){return feedbackService.list();}

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return feedbackService.removeById(id);
    }

    //分页查询-- mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Feedback> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String fbContent
    ){
        IPage<Feedback> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<>();
        if(!"".equals(fbContent)){
            queryWrapper.like("fb_content",fbContent);
        }
        queryWrapper.orderByDesc("fb_id");
        return feedbackService.page(page,queryWrapper);
    }

}
