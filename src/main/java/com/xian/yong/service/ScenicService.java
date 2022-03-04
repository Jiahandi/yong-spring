package com.xian.yong.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Scenic;
import com.xian.yong.mapper.ScenicMapper;
import org.springframework.stereotype.Service;

@Service
public class ScenicService extends ServiceImpl<ScenicMapper, Scenic> {
    public boolean saveScenic(Scenic scenic){
        if(scenic.getScenicId() == null){
            return save(scenic);
        }else{
            return updateById(scenic);
        }
    }

}
