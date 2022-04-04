package com.aliyun.springboottrue.Entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author MengXX
 * @Decription:文件上传
 * @Date 2022/3/21  18:28
 */
@Data
@TableName("SysFile")
public class SysFileDto {

    private String id;

    private String uuid;

    private String fileUrl;

    private String fileName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime uploadTime;

    private String fileType;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createOperatorId;

    private String UpdateOperatorId;

    private int isDelete;

    private String place;
}
