package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Cardlist;
import com.xian.yong.entity.Strimage;
import com.xian.yong.mapper.StrimageMapper;
import org.springframework.stereotype.Service;

@Service
public class StrimageService extends ServiceImpl<StrimageMapper, Strimage> {
    public boolean saveStrimage(Strimage strimage) {
        if(strimage.getId() == null){
            return save(strimage);
        }else{
            return updateById(strimage);
        }
    }
}
