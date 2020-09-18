package com.noel.sso.client_register.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author noel
 * @Date 2020/9/18
 * Version 1.0
 **/
@Data
public class Result {
    private Boolean success;
    private Integer code;
    private String msg;
    private Map<String, Object> data = new HashMap<>();

    private Result(){}

    public static Result ok(){
        Result r = new Result();
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("操作成功");
        r.setSuccess(true);
        return r;
    }

    public static Result error(){
        Result r = new Result();
        r.setCode(ResultCode.ERROR);
        r.setSuccess(false);
        r.setMsg("操作失败");
        return r;
    }

    public Result success(Boolean status){
        this.setSuccess(status);
        return this;
    }
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }
    public Result msg(String msg){
        this.setMsg(msg);
        return this;
    }
    public Result data(String k, Object v){
        this.data.put(k,v);
        return this;
    }
    public Result data(Map<String, Object> data){
        this.setData(data);
        return this;
    }
}
