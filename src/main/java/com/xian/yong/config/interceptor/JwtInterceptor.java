package com.xian.yong.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.xian.yong.common.Constants;
import com.xian.yong.entity.Admin;
import com.xian.yong.entity.User;
import com.xian.yong.exception.ServiceException;
import com.xian.yong.service.AdminService;
import com.xian.yong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor implements  HandlerInterceptor{
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new ServiceException(Constants.CODE_401,"无token，请重新登录");
        }
        // 获取 token 中的 admin id
        String adid,id;
        try {
            adid = JWT.decode(token).getAudience().get(0);
            id = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }
        //根据token中的admin查询数据库
        Admin admin = adminService.getById(adid);
        User user = userService.getById(id);
        if(user != null){ return true;}
        if (admin == null) {
            throw new ServiceException(Constants.CODE_401,"用户不存在，请重新登录");
        }

        // 用户密码加签验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(admin.getAdpassword())).build();
        try {
            jwtVerifier.verify(token); //验证token
        } catch (JWTVerificationException e) {
            throw new ServiceException(Constants.CODE_401, "token验证失败，请重新登录");
        }
        return true;
    }
}
