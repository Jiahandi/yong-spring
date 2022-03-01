package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.User;
import com.xian.yong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public boolean saveUser(User user) {
        if(user.getId() == null){
            return save(user);
        }else{
            return updateById(user);
        }
    }

//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user){
//        if(user.getId() == null){ //如果user没有id，则表示是新增; 否则是更新
//            return userMapper.insert(user);
//        }else{
//            return userMapper.update(user);
//        }
//    }
}
