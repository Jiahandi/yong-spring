package com.xian.yong.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.common.Constants;
import com.xian.yong.entity.User;
import com.xian.yong.entity.UserDto;
import com.xian.yong.exception.ServiceException;
import com.xian.yong.mapper.UserMapper;
import com.xian.yong.utils.TokenUtils;
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

    public User register(UserDto userDto) {
        User one = getUserInfo(userDto);
        if(one == null) {
            one = new User();
            BeanUtil.copyProperties(userDto, one, true);
            save(one); //把copy完之后的用户对象存储到数据库
        }
        String token = TokenUtils.getToken(one.getId().toString(),one.getOpenId());
        one.setToken(token);
        return one;
    }

    private User getUserInfo(UserDto userDto){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDto.getUsername());
        queryWrapper.eq("open_id",userDto.getOpenId());
        User one;
        try{
            one = getOne(queryWrapper); //从数据库查询用户信息
        } catch (Exception e) {
            throw new ServiceException((Constants.CODE_500), "系统错误");
        }
        return one;
    }
    public User getUserByOpenid(String openid) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id",openid);
        User one;
        try{
            one = getOne(queryWrapper); //从数据库查询用户信息
        } catch (Exception e){
            throw new ServiceException((Constants.CODE_500),"系统错误");
        }
        return one;
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
