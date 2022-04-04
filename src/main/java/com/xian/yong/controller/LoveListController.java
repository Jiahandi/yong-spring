package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.yong.entity.Forum;
import com.xian.yong.entity.Lovelist;
import com.xian.yong.mapper.LoveListMapper;
import com.xian.yong.service.LoveListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lovelist")
public class LoveListController {
    @Autowired
    private LoveListMapper loveListMapper;
    @Autowired
    private LoveListService loveListService;
    @PostMapping
    public boolean save(@RequestBody Lovelist lovelist){ return loveListService.saveLovelist(lovelist);}

    @GetMapping
    public List<Lovelist> findAll(
            @RequestParam(defaultValue = "") String userId,
            @RequestParam(defaultValue = "") String strategyId){
        QueryWrapper<Lovelist> queryWrapper = new QueryWrapper<>();
        if(!"".equals(userId)){
            queryWrapper.like("user_id",userId);
        }
        if(!"".equals(strategyId)){
            queryWrapper.like("strategy_id",strategyId);
        }
        return loveListService.list(queryWrapper);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return loveListService.removeById(id);
    }
}
