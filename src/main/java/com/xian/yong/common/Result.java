package com.xian.yong.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code; //code:0成功 1失败
    private String message; //返回请求失败的原因
    private Object data; //返回需要用到的数据


    public static Result success(){
        return new Result(Constants.CODE_200, "", null);
    }

    public static Result success(Object data){
        return new Result(Constants.CODE_200, "", data);
    }

    public static Result error(String code,String msg){
        return new Result(code, msg, null);
    }

    public static Result error(){
        return new Result(Constants.CODE_500, "", null);
    }
}
