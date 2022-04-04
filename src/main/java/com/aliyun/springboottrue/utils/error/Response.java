package com.aliyun.springboottrue.utils.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//响应
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Response<T> {
    private Integer code;
    private String message;
    private T data;

    //code状态码
    //构造函数
    //message信息
    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    //响应成功
    public Response(T data) {
        this.setCode(ErrorResult.OPERATION_SUCCESS.getCode());
        this.setMessage(ErrorResult.OPERATION_SUCCESS.getMessage());
        this.setData(data);
    }
    //返回结果状态码
    public Response<T>response(ErrorResult resultCode){
        Response<T> response=new Response<>();
        response.setCode(resultCode.getCode());
        response.setMessage(response.getMessage());
        return response;
    }
}
