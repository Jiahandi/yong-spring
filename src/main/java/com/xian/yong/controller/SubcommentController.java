package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.common.Result;
import com.xian.yong.entity.Files;
import com.xian.yong.entity.Subcomment;
import com.xian.yong.mapper.SubcommentMapper;
import com.xian.yong.service.SubcommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/subcomment")
public class SubcommentController {
    @Autowired
    private SubcommentMapper subcommentMapper;

    @Autowired
    private SubcommentService subcommentService;

    @PostMapping
    public  boolean save(@RequestBody Subcomment subcomment){return subcommentService.saveSubcomment(subcomment);}

    @GetMapping
    public List<Subcomment> findAll(
            @RequestParam(defaultValue = "") String comId,
            @RequestParam(defaultValue = "") String comOpenid,
            @RequestParam(defaultValue = "") String subOpenid){
        QueryWrapper<Subcomment> queryWrapper = new QueryWrapper<>();
        if(!"".equals(comId)){
            queryWrapper.like("com_id",comId);
        }
        if(!"".equals(comOpenid)){
            queryWrapper.like("com_openid",comOpenid);
        }
        if(!"".equals(subOpenid)){
            queryWrapper.like("sub_openid",subOpenid);
        }
        return subcommentService.list(queryWrapper);
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return subcommentService.removeById(id);
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize){
        QueryWrapper<Subcomment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("sub_id");
        return Result.success(subcommentMapper.selectPage(new Page<>(pageNum,pageSize),queryWrapper));
    }

}
