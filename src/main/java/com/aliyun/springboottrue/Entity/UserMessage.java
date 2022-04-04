package com.aliyun.springboottrue.Entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@TableName("user")
public class UserMessage {
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
