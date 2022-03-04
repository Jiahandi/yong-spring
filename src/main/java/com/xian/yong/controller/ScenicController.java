package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.Scenic;
import com.xian.yong.mapper.ScenicMapper;
import com.xian.yong.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scenic")
public class ScenicController {
    @Autowired
    private ScenicMapper scenicMapper;

    @Autowired
    private ScenicService scenicService;

    @PostMapping
    public boolean save(@RequestBody Scenic scenic){
        //新增和更新
        return scenicService.saveScenic(scenic);
    }

    @GetMapping
    public List<Scenic> findAll() {
        return scenicService.list();
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){//传id
        //删除
        return scenicService.removeById(id);
    }
    //分页查询-- mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Scenic> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String sceName,
                                  @RequestParam(defaultValue = "") String sceThemeName
    ){
        IPage<Scenic> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Scenic> queryWrapper = new QueryWrapper<>();
        if(!"".equals(sceName)){
            queryWrapper.like("sceName",sceName);
        }
        if(!"".equals(sceThemeName)){
            queryWrapper.like("sceThemeName",sceThemeName);
        }
        queryWrapper.orderByDesc("scenicId");
        return scenicService.page(page,queryWrapper);
    }

}
