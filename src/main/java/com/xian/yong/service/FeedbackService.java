package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Feedback;
import com.xian.yong.entity.Forum;
import com.xian.yong.mapper.FeedbackMapper;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService extends ServiceImpl<FeedbackMapper,Feedback>{
    public  boolean saveFeedback(Feedback feedback) {
        if (feedback.getFbId() == null) {
            return save(feedback);
        } else {
            return updateById(feedback);
        }
    }
}
