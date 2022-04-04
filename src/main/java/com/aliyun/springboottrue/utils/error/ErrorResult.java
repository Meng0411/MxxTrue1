package com.aliyun.springboottrue.utils.error;

/**
 * @Author MengXX
 * @Decription:统一返回类型
 * @Date 2022/3/2  14:57
 */
public enum ErrorResult {
    OPERATION_SUCCESS(200,"操作成功"),
    OPERATION_FAILED(2001,"操作失败"),
    DATA_NO_DATA(2002,"没有数据")
    ;


    private Integer code;
    private String message;


    ErrorResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

