package com.xian.yong.controller;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xian.yong.common.Constants;
import com.xian.yong.common.Result;
import com.xian.yong.entity.User;
import com.xian.yong.entity.UserDto;
import com.xian.yong.mapper.UserMapper;
import com.xian.yong.service.UserService;
import com.xian.yong.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user) {
        //新增或更新都在这
        return userService.saveUser(user);
    }
    @PostMapping("/wxlogin")
    public Result register(@RequestBody UserDto userDto){
        String username = userDto.getUsername();
        String openid = userDto.getOpenId();
        if(StrUtil.isBlank(username) || StrUtil.isBlank(openid)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        return Result.success(userService.register(userDto));
    }

    @GetMapping
        //查询所有数据
    public List<User> findAll(@RequestParam(defaultValue = "") String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        return userService.list(queryWrapper);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){//传id
        //删除
        return userService.removeById(id);
    }

    //分页查询 接口路径：/user/page?pageNum=1&pageSize=10
    //@RequestParam接受
    //分页查询时limt 第一个参数=(pageNum - 1)* pageSize
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String username){
//        pageNum = (pageNum - 1) * pageSize;
//        username = "%" + username + "%";
//        List<User> data = userMapper.selectPage(pageNum,pageSize,username);
//        //total总条数
//        Integer total = userMapper.selectTotal(username);
//        Map<String, Object> res = new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }


    //分页查询-- mybatis-plus的方式
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String address){
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
        }
        User currentUser =  TokenUtils.getCurrentUser();
//        System.out.println(currentUser);
        queryWrapper.orderByDesc("id");
        return userService.page(page,queryWrapper);
    }
}
