package com.xian.yong.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.yong.entity.Cardlist;
import com.xian.yong.entity.Strimage;
import com.xian.yong.mapper.StrimageMapper;
import com.xian.yong.service.StrimageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/strimage")
public class StrimageController {
    @Autowired
    private StrimageMapper strimageMapper;
    @Autowired
    private StrimageService strimageService;
    @PostMapping
    public boolean save(@RequestBody Strimage strimage){
        return strimageService.saveStrimage(strimage);
    }

    @GetMapping
    public List<Strimage> findAll(
            @RequestParam(defaultValue = "") String strId){
        QueryWrapper<Strimage> queryWrapper = new QueryWrapper<>();
        if(!"".equals(strId)){
            queryWrapper.like("str_id",strId);
        }
        return strimageService.list(queryWrapper);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return strimageService.removeById(id);
    }
}
