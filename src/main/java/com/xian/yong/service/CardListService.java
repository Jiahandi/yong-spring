package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Cardlist;
import com.xian.yong.mapper.CardListMapper;
import org.springframework.stereotype.Service;


@Service
public class CardListService extends ServiceImpl<CardListMapper, Cardlist> {
    public boolean saveCardlist(Cardlist cardlist) {
        if(cardlist.getId() == null){
            return save(cardlist);
        }else{
            return updateById(cardlist);
        }
    }


}
