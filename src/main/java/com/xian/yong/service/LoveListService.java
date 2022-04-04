package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Forum;
import com.xian.yong.entity.Lovelist;
import com.xian.yong.mapper.LoveListMapper;
import org.springframework.stereotype.Service;

@Service
public class LoveListService extends ServiceImpl<LoveListMapper, Lovelist> {
    public boolean saveLovelist(Lovelist lovelist) {
        if(lovelist.getId() == null){
            return save(lovelist);
        }else{
            return updateById(lovelist);
        }
    }
}
