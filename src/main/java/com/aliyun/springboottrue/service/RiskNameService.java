package com.aliyun.springboottrue.service;

import com.aliyun.springboottrue.Entity.RiskName;
import com.aliyun.springboottrue.Entity.dto.RiskNameDto;
import com.aliyun.springboottrue.Entity.excel.RiskNameExcelVo;
import com.aliyun.springboottrue.Entity.vo.RiskNameVo;
import com.aliyun.springboottrue.utils.error.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author MengXX
 * @Decription:service
 * @Date 2022/3/2  14:48
 */
public interface RiskNameService extends IService<RiskName> {
    int addRiskName(RiskNameDto dto);

    IPage<RiskNameVo> selectRiskName(RiskNameDto dto);

    boolean logicUpdateById(RiskNameDto dto);

    boolean logicBatchUpdateById(List<String>ids);

    boolean batchAddRiskName(RiskNameDto dto);

    Response ExportRiskName(HttpServletResponse response);

    List<RiskNameExcelVo> ExportRiskNameMessage(RiskNameDto dto, HttpServletResponse response);

    List<RiskNameExcelVo> ExportRiskNameMessageById(RiskNameDto dto, HttpServletResponse response);

    Response ImportRiskNameMessage(MultipartFile file, HttpServletRequest request);



}
