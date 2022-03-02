package com.xian.yong.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.User;
import com.xian.yong.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin>{
        public boolean saveAdmin(Admin admin) {
            if (admin.getAdid() == null) {
                return save(admin);
            } else {
                return updateById(admin);
            }
        }
}
