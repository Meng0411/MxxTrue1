package com.aliyun.springboottrue.Entity;

import lombok.Data;

@Data
public class SysFileWork {
    private int id;

    private String createOperatorId;

    private String create;

    private String organzationId;

    private String organzationName;

    private String isDelete;

    private String createTime;

    private String updateTime;

    private String isValue;
}
