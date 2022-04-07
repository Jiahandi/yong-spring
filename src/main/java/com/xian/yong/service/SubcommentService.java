package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Subcomment;
import com.xian.yong.mapper.SubcommentMapper;
import org.springframework.stereotype.Service;

@Service
public class SubcommentService  extends ServiceImpl<SubcommentMapper, Subcomment> {
    public boolean saveSubcomment(Subcomment subcomment) {
        if(subcomment.getSubId() == null){
            return save(subcomment);
        }else{
            return updateById(subcomment);
        }
    }

}
