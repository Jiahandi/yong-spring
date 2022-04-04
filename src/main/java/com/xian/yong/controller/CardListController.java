package com.xian.yong.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xian.yong.entity.Cardlist;
import com.xian.yong.entity.Forum;
import com.xian.yong.mapper.CardListMapper;
import com.xian.yong.service.CardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardlist")
public class CardListController {
    @Autowired
    private CardListMapper cardListMapper;
    @Autowired
    private CardListService cardListService;

    @PostMapping
    public boolean save(@RequestBody Cardlist cardlist){ return cardListService.saveCardlist(cardlist);}

    @GetMapping
    public List<Cardlist> findAll( @RequestParam(defaultValue = "") String userId,
                                   @RequestParam(defaultValue = "") String scenicId){
        QueryWrapper<Cardlist> queryWrapper = new QueryWrapper<>();
        if(!"".equals(userId)){
            queryWrapper.like("user_id",userId);
        }
        if(!"".equals(scenicId)){
            queryWrapper.like("scenic_id",scenicId);
        }
        return cardListService.list(queryWrapper);

    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return cardListService.removeById(id);
    }


}
