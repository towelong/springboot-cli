package com.welong.tpl.exception;

import lombok.Data;

/**
 * @Author WeLong
 * @create 2019/10/25 11:30
 */

@Data
public class Success extends HttpException {
    private int code = 0;
    private String msg = "请求成功";
    public Success() {

    }
    public Success(String msg){
        this.msg = msg;
    }
}
