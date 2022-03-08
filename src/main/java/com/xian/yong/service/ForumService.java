package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Forum;
import com.xian.yong.mapper.ForumMapper;
import org.springframework.stereotype.Service;

@Service
public class ForumService extends ServiceImpl<ForumMapper, Forum> {
    public boolean saveForum(Forum forum) {
        if(forum.getForumId() == null){
            return save(forum);
        }else{
            return updateById(forum);
        }
    }
}
