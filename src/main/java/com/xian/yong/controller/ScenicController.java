package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public List<Scenic> findAll(@RequestParam(defaultValue = "") String scenicId,
                                @RequestParam(defaultValue = "") String sceThemeid,
                                @RequestParam(defaultValue = "") String sceName
                                ) {
        QueryWrapper<Scenic> queryWrapper = new QueryWrapper<>();
        if(!"".equals(scenicId)){
            queryWrapper.like("scenic_id",scenicId);
        }
        if(!"".equals(sceThemeid)){
            queryWrapper.like("sce_themeid",sceThemeid);
        }
        if(!"".equals(sceName)){
            queryWrapper.like("sce_name",sceName);
        }
        return scenicService.list(queryWrapper);
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return scenicService.removeById(id);
    }
    //分页查询-- mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Scenic> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String sceName,
                                  @RequestParam(defaultValue = "") String sceThemeid
    ){
        IPage<Scenic> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Scenic> queryWrapper = new QueryWrapper<>();
        if(!"".equals(sceName)){
            queryWrapper.like("sce_name",sceName);
        }
        if(!"".equals(sceThemeid)){
            queryWrapper.like("sce_themeid",sceThemeid);
        }
        queryWrapper.orderByDesc("scenic_id");
        return scenicService.page(page,queryWrapper);
    }

}
