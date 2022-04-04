package com.aliyun.springboottrue.Entity.dto;

import lombok.Data;

@Data
public class SysFileWorkDto {
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
