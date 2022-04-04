package com.aliyun.springboottrue.controller;

import com.aliyun.springboottrue.Entity.RiskName;
import com.aliyun.springboottrue.Entity.dto.RiskNameDto;
import com.aliyun.springboottrue.Entity.excel.RiskNameExcelVo;
import com.aliyun.springboottrue.Entity.vo.RiskNameVo;
import com.aliyun.springboottrue.service.RiskNameService;


import com.aliyun.springboottrue.utils.Excel.ExcelUtils;
import com.aliyun.springboottrue.utils.error.ErrorResult;
import com.aliyun.springboottrue.utils.error.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author MengXX
 * @Decription:controller
 * @Date 2022/3/2 14:51
 */
@RestController
@RequestMapping("/riskName")
public class RiskNameController {
    @Resource
    private RiskNameService riskNameService;

    /**
     * @param dto
     * @return 新增
     */
    @PostMapping("/addriskName")
    public Response AddRiskName(@RequestBody RiskNameDto dto) {
        int num = riskNameService.addRiskName(dto);
        if (num == 0) {
            return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
        }
        return new Response(ErrorResult.OPERATION_SUCCESS.getCode(), ErrorResult.OPERATION_SUCCESS.getMessage());
    }

    /**
     * @param dto
     * @return 批量新增数据
     */
    @PostMapping("/batchaddriskName")
    public Response BatchAddRiskName(@RequestBody RiskNameDto dto) {
        boolean num = riskNameService.batchAddRiskName(dto);
        if (num) {
            return new Response(ErrorResult.OPERATION_SUCCESS.getCode(), ErrorResult.OPERATION_SUCCESS.getMessage());
        }
        return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
    }

    /**
     * @param dto
     * @return 查询带分页
     */
    @PostMapping("/selectriskname")
    public Response SelectRiskName(@Validated(RiskNameDto.selectAll.class) @RequestBody RiskNameDto dto) {
        if (dto.getPage() == null || dto.getSize() == null) {
            return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
        }
        IPage<RiskNameVo> riskNameVoIPage = riskNameService.selectRiskName(dto);
        return new Response(riskNameVoIPage).setData(riskNameVoIPage);
    }

    /**
     * @param dto
     * @return 逻辑删除
     */
    @PostMapping("/logicupdateById")
    public Response LogicUpdateById(@RequestBody RiskNameDto dto) {
        boolean num = riskNameService.logicUpdateById(dto);
        if (num) {
            return new Response(ErrorResult.OPERATION_SUCCESS.getCode(), ErrorResult.OPERATION_SUCCESS.getMessage());
        }
        return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
    }

    /**
     * @param dto
     * @return 通过ID批量逻辑删除
     */
    @PostMapping("logicbatchupdateById")
    public Response LogicBatchUpdateById(@RequestBody RiskNameDto dto) {
        boolean num = riskNameService.logicBatchUpdateById(dto.getIds());
        if (num) {
            return new Response(ErrorResult.OPERATION_SUCCESS.getCode(), ErrorResult.OPERATION_SUCCESS.getMessage());
        }
        return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
    }

    /**
     * @param response
     * @return 导出excel 示例表
     */
    @PostMapping("/exportRiskName")
    public Response ExportRiskName(HttpServletResponse response) {
        return riskNameService.ExportRiskName(response);
    }

    /**
     * @param dto
     * @param response
     * @return 全部导出
     */
    @PostMapping("/exportRiskNameMessage")
    public List<RiskNameExcelVo> ExportRiskNameMessage(RiskNameDto dto, HttpServletResponse response) {

        return riskNameService.ExportRiskNameMessage(dto, response);
    }

    /**
     * @param dto
     * @param response
     * @return 根据ID批量导出
     */
    @PostMapping("/exportRiskNameMessageById")
    public List<RiskNameExcelVo> ExportRiskNameMessageById(@RequestBody RiskNameDto dto, HttpServletResponse response) {
        List<RiskNameExcelVo> riskNameExcelVos = riskNameService.ExportRiskNameMessageById(dto, response);
        return riskNameExcelVos;
    }

    /**
     * @param file
     * @param request
     * @return 批量导入文件
     */
    @PostMapping("/importRiskNameMessage")
    public Response ImportRiskNameMessage(MultipartFile file, HttpServletRequest request) {
        return riskNameService.ImportRiskNameMessage(file, request);
    }


}

