package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.entity.Strategy;
import com.xian.yong.entity.User;
import com.xian.yong.mapper.StrategyMapper;
import com.xian.yong.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("strategy")
public class StrategyController {
    @Autowired
    private StrategyMapper strategyMapper;

    @Autowired
    private StrategyService strategyService;

    @PostMapping
    public boolean save(@RequestBody Strategy strategy){
        //新增或更新
        return strategyService.saveStrategy(strategy);
    }

    @GetMapping
    //查询所有数据
    public List<Strategy> findAll() {return strategyService.list();}

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        //删除
        return strategyService.removeById(id);
    }

    @GetMapping("/page")
    public IPage<Strategy> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestParam(defaultValue = "") String straTitle,
                                    @RequestParam(defaultValue = "") String straThemeid){
        IPage<Strategy> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Strategy> queryWrapper = new QueryWrapper<>();
        if(!"".equals(straTitle)){
            queryWrapper.like("stra_title",straTitle);
        }
        if(!"".equals(straThemeid)){
            queryWrapper.like("stra_themeid",straThemeid);
        }
        queryWrapper.orderByDesc("strategy_id");
        return strategyService.page(page,queryWrapper);
    }





}
