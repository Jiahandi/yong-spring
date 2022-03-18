package com.xian.yong.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xian.yong.entity.Admin;
import com.xian.yong.service.AdminService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 生成token
 */
@Component
public class TokenUtils {
    private static AdminService staticAdminService;

    @Resource
    private AdminService adminService;

    @PostConstruct
    public void setAdminService(){
        staticAdminService = adminService;
    }

    public static String getToken(String adid, String sign){
        return JWT.create().withAudience(adid) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),2)) //2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }

    //获取当前登录用户信息
    public static Admin getCurrentAdmin(){
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");

            if(StrUtil.isNotBlank(token)){
                String adid = JWT.decode(token).getAudience().get(0);
                return staticAdminService.getById(Integer.valueOf(adid));
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }
}
