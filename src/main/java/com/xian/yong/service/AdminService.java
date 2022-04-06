package com.xian.yong.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.common.Constants;
import com.xian.yong.common.Result;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.AdminDto;
import com.xian.yong.exception.ServiceException;
import com.xian.yong.mapper.AdminMapper;
import com.xian.yong.utils.TokenUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;


@Service
@Transactional
public class AdminService extends ServiceImpl<AdminMapper, Admin>{

    public AdminDto login(AdminDto adminDto) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("adname",adminDto.getAdname());
        queryWrapper.eq("adpassword",adminDto.getAdpassword());
        Admin one;
        try{
             one = getOne(queryWrapper); //从数据库查询用户信息
        } catch (Exception e){
            throw new ServiceException((Constants.CODE_500),"系统错误");
        }
        if(one != null){
            BeanUtil.copyProperties(one,adminDto,true);
            String token = TokenUtils.getToken(one.getAdid().toString(),one.getAdpassword());
            adminDto.setToken(token);
            return adminDto;
        }else{
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }

    }

    public boolean saveAdmin(Admin admin) {
            if (admin.getAdid() == null) {
                return save(admin);
            } else {
                return updateById(admin);
            }
        }
}
