package com.xian.yong.controller;


import com.alibaba.fastjson.JSONObject;
import com.xian.yong.config.WeChatConfig;
import com.xian.yong.entity.UserDto;
import com.xian.yong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class WeChatController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody String code2session(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", weChatConfig.getAppid());
        requestMap.put("secret", weChatConfig.getSecret());
        requestMap.put("code", code);
        String result = this.restTemplate.getForObject(url, String.class, requestMap);
//        JSONObject json_test = JSONObject.parseObject(result);
//        String openid = json_test.getString("openid");
//        String sessionKey = json_test.getString("session_key");
//        System.err.println("openid值： " + openid);
        return result;
    }
}
