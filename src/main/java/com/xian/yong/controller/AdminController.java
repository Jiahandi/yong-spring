package com.xian.yong.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.common.Constants;
import com.xian.yong.common.Result;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.AdminDto;
import com.xian.yong.mapper.AdminMapper;
import com.xian.yong.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin") //给接口加前缀名
public class AdminController {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestBody AdminDto adminDto){
        String adname = adminDto.getAdname();
        String adpassword = adminDto.getAdpassword();
        if(StrUtil.isBlank(adname) || StrUtil.isBlank(adpassword)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        AdminDto dto = adminService.login(adminDto);
        return Result.success(dto);
    }

    @PostMapping
    public boolean save(@RequestBody Admin admin) {
        //新增或更新都在这
        return adminService.saveAdmin(admin);
    }

    @GetMapping
    public List<Admin> findAll() {
        return adminService.list();
    }
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return adminService.removeById(id);
    }
    //分页查询-- mybatis-plus的方式
    @GetMapping("/page")
    public IPage<Admin> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String adid
                               ){
        IPage<Admin> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        if(!"".equals(adid)){
            queryWrapper.like("adid",adid);
        }
        queryWrapper.orderByDesc("adid");
        return adminService.page(page,queryWrapper);
    }


}
