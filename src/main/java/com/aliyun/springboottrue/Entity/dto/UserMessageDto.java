package com.aliyun.springboottrue.Entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserMessageDto {
    /**
     * 主键id
     */
    @TableField("ID")
    //自动递增
    //  @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;
    /**
     * 年龄
     */
    @TableField("AGE")
    private Integer age;
    //自动递增时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String updateTime;

}
