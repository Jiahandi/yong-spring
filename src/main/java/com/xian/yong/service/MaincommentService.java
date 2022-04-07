package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Maincomment;
import com.xian.yong.mapper.MaincomnentMapper;
import org.springframework.stereotype.Service;

@Service
public class MaincommentService extends ServiceImpl<MaincomnentMapper, Maincomment> {
    public boolean saveMaincomment(Maincomment maincomment) {
        if(maincomment.getComId() == null){
            return save(maincomment);
        }else{
            return updateById(maincomment);
        }
    }
}
