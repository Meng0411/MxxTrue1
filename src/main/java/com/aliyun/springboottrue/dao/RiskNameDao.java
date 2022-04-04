package com.aliyun.springboottrue.dao;

import com.aliyun.springboottrue.Entity.RiskName;
import com.aliyun.springboottrue.Entity.dto.RiskNameDto;
import com.aliyun.springboottrue.Entity.excel.RiskNameExcelVo;
import com.aliyun.springboottrue.Entity.vo.RiskNameVo;
import com.aliyun.springboottrue.utils.error.Response;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Mapper
public interface RiskNameDao extends BaseMapper<RiskName> {

    int addRiskName(@Param("dto") RiskNameDto dto);

    IPage<RiskNameVo> selectRiskName(IPage iPage,@Param("dto") RiskNameDto dto);

    boolean logicUpdateById(@Param("dto") RiskNameDto dto);

    boolean logicBatchUpdateById(@Param("ids") List<String> ids);

    boolean batchAddRiskName(@Param("dto") RiskNameDto dto);

    List<RiskNameExcelVo> ExportRiskNameMessage(RiskNameDto dto, HttpServletResponse response);

    List<RiskNameExcelVo> ExportRiskNameMessageById(@Param("dto") RiskNameDto dto, HttpServletResponse response);

    void ImportRiskNameMessage(@Param("dto") RiskNameDto dto);
}
