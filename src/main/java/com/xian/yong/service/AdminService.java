package com.xian.yong.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.User;
import com.xian.yong.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin>{
    public boolean login(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("adname",admin.getAdname());
        queryWrapper.eq("adpassword",admin.getAdpassword());
        Admin one = getOne(queryWrapper);
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
