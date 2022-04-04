package com.aliyun.springboottrue.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@TableName("RISK_NAME")
public class RiskName implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableField("ROW_ID")
    /**
     * 主键ID
     */
    private String rowId;
    @TableField("RISK_NAME")
    /**
     * 风险名称
     */
    private String riskName;
    @TableField("PUBLISH_TRADE")
    /**
     * 发布条件
     */
    private String publishTrade;
    @TableField("RISK_LEVEL")
    /**
     * 风险等级
     */
    private String riskLevel;
    @TableField("VOLTAGE_LEVEL")
    /**
     * 电压等级
     */
    private String voltageLevel;
    @TableField("WARNING_NO")
    /**
     * 预警编号
     */
    private String warningNo;

    @TableField("WARNING_YEAR")
    /**
     * 预警年度
     */
    private String warningYear;
    @TableField("DUTY_UNIT")
    /**
     * 责任单位
     */
    private String dutyUnit;
    @TableField("CREATER")
    /**
     * 创建人
     */
    private String creater;
    @TableField("CREATE")
    /**
     * 创建人ID
     */
    private String createId;
    @TableField("RISK_ANALYSIS")
    /**
     * 责任分析
     */
    private String riskAnalysis;

    @TableField("CREATE_TIME")
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    @TableField("UPDATE_TIME")
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;
    @TableField("IS_DELETE")
    /**
     * 逻辑删除 0未删除 1删除
     */
    private String isDelete;
}
