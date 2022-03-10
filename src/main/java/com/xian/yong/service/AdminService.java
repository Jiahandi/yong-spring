package com.xian.yong.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.AdminDto;
import com.xian.yong.entity.User;
import com.xian.yong.mapper.AdminMapper;
import com.xian.yong.utils.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin>{
    public boolean login(AdminDto adminDto) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("adname",adminDto.getAdname());
        queryWrapper.eq("adpassword",adminDto.getAdpassword());
        Admin one = getOne(queryWrapper);
        //设置token
//        TokenUtils.getToken(one.getAdid().toString(), one.getAdpassword());


        return one != null;
    }

    public boolean saveAdmin(Admin admin) {
            if (admin.getAdid() == null) {
                return save(admin);
            } else {
                return updateById(admin);
            }
        }
}
