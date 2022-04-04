package com.aliyun.springboottrue.Entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
public class RiskNameExcelVo {
    @Excel(name = "序号",orderNum ="1",width = 22)
    private Integer id;
    @Excel(name = "预警编号",orderNum ="2",width = 22)
    private String warningNo;
    @Excel(name = "风险名称",orderNum ="3",width = 22)
    private String riskName;
    @Excel(name = "发布条件",orderNum ="4",width = 22)
    private String publishTrade;
    @Excel(name = "风险等级",orderNum ="5",width = 22)
    private String riskLevel;
    @Excel(name = "电压等级",orderNum ="6",width = 22)
    private String voltageLevel;
    @Excel(name = "发布人",orderNum ="7",width = 22)
    private String creater;
    @Excel(name = "录入单位",orderNum ="8",width = 22)
    private String dutyUnit;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "发布时间",orderNum ="9",width = 22)
    private String createTime;
}
