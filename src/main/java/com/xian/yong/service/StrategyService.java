package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Strategy;
import com.xian.yong.mapper.StrategyMapper;
import org.springframework.stereotype.Service;

@Service
public class StrategyService extends ServiceImpl<StrategyMapper, Strategy> {
    public boolean saveStrategy(Strategy strategy){
        if(strategy.getStrategyId() == null){
            return save(strategy);
        }else{
            return updateById(strategy);
        }
    }
}
