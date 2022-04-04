package com.aliyun.springboottrue.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.aliyun.springboottrue.Entity.RiskName;
import com.aliyun.springboottrue.Entity.dto.RiskNameDto;
import com.aliyun.springboottrue.Entity.excel.RiskNameExcelVo;
import com.aliyun.springboottrue.Entity.vo.RiskNameVo;
import com.aliyun.springboottrue.dao.RiskNameDao;
import com.aliyun.springboottrue.service.RiskNameService;
import com.aliyun.springboottrue.utils.Excel.ExcelUtils;
import com.aliyun.springboottrue.utils.Excel.FileExcelUtils;
import com.aliyun.springboottrue.utils.error.ErrorResult;
import com.aliyun.springboottrue.utils.error.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RiskNameServiceImpl extends ServiceImpl<RiskNameDao, RiskName> implements RiskNameService {
    @Resource
    private RiskNameDao riskNameDao;

    @Override
    public int addRiskName(RiskNameDto dto) {
        //设置ID
        String id = UUID.randomUUID().toString().replace("-", "");
        dto.setRowId(id);
        dto.setCreateTime(LocalDateTime.now().toString());
        dto.setUpdateTime(LocalDateTime.now().toString());
        int num = riskNameDao.addRiskName(dto);

        return num;
    }

    @Override
    public IPage<RiskNameVo> selectRiskName(RiskNameDto dto) {
        IPage<RiskNameVo> page = new Page<>(dto.getPage(), dto.getSize());
        IPage<RiskNameVo> riskNameVoIPage = riskNameDao.selectRiskName(page, dto);

        return riskNameVoIPage;
    }

    @Override
    public boolean logicUpdateById(RiskNameDto dto) {
        boolean num = riskNameDao.logicUpdateById(dto);
        return num;
    }

    @Override
    public boolean logicBatchUpdateById(List<String> ids) {
        boolean b = riskNameDao.logicBatchUpdateById(ids);
        return b;
    }

    @Override
    public boolean batchAddRiskName(RiskNameDto dto) {
        for (RiskNameDto riskNameDto : dto.getMeasure()) {
            String id = UUID.randomUUID().toString().replace("-", "");
            riskNameDto.setRowId(id);
            dto.setCreateTime(LocalDateTime.now().toString());
            dto.setUpdateTime(LocalDateTime.now().toString());
            riskNameDto.setIsDelete("0");
        }
//        dto.getMeasure().forEach(E->{
//
//            E.setIsDelete("0");
//        });
        boolean num = riskNameDao.batchAddRiskName(dto);
        return num;
    }

    @Override
    public Response ExportRiskName(HttpServletResponse response) {
        List<RiskNameExcelVo> list = new ArrayList<RiskNameExcelVo>();
        RiskNameExcelVo riskName = new RiskNameExcelVo();
        riskName.setId(1);
        riskName.setWarningNo("徐州地调");
        riskName.setRiskName("110千伏");
        riskName.setPublishTrade("市公司认定的电网形式");
        riskName.setRiskLevel("六级");
        riskName.setVoltageLevel("110kv");
        riskName.setCreater("某某某");
        riskName.setDutyUnit("徐州");
        riskName.setCreateTime(LocalDateTime.now().toString());
        list.add(riskName);
        RiskNameExcelVo risk = new RiskNameExcelVo();
        risk.setRiskName("导入时请删除示例!");
        list.add(risk);
        String[] arr = new String[]{"序号", "预警编号", "风险名称", "发布条件", "风险等级", "电压等级", "发布人", "录入单位", "发布时间"};
        ExcelUtils.exportExcel(list, "测试表格", "测试表格", RiskNameExcelVo.class, "测试表格", response);

        return new Response(ErrorResult.OPERATION_SUCCESS.getCode(), ErrorResult.OPERATION_SUCCESS.getMessage());
    }

    @Override
    public List<RiskNameExcelVo> ExportRiskNameMessage(RiskNameDto dto, HttpServletResponse response) {

        List<RiskNameExcelVo> riskNameExcelVos = riskNameDao.ExportRiskNameMessage(dto, response);
        int a = 0;
        for (RiskNameExcelVo riskNameExcelVo : riskNameExcelVos) {
            a++;
            riskNameExcelVo.setId(a);
        }
        String[] arr = new String[]{"序号", "预警编号", "风险名称", "发布条件", "风险等级", "电压等级", "发布人", "录入单位", "发布时间"};
        ExcelUtils.exportExcel(riskNameExcelVos, "测试表格", "测试表格", RiskNameExcelVo.class, "测试表格", response);
        return riskNameExcelVos;
    }

    @Override
    public List<RiskNameExcelVo> ExportRiskNameMessageById(RiskNameDto dto, HttpServletResponse response) {

        List<RiskNameExcelVo> riskNameExcelVos = riskNameDao.ExportRiskNameMessageById(dto, response);
        int a = 0;
        for (RiskNameExcelVo riskNameExcelVo : riskNameExcelVos) {
            a++;
            riskNameExcelVo.setId(a);
        }
        String[] arr = new String[]{"序号", "预警编号", "风险名称", "发布条件", "风险等级", "电压等级", "发布人", "录入单位", "发布时间"};
        ExcelUtils.exportExcel(riskNameExcelVos, "测试信息", "测试信息", RiskNameExcelVo.class, "测试信息", response);
        return riskNameExcelVos;
    }


    @Override
    public Response ImportRiskNameMessage(MultipartFile file, HttpServletRequest request) {
        //测试数据 批量导入
        List<RiskNameDto> riskNameDtos = new ArrayList<RiskNameDto>();
        //设置文件的格式
        File file1 = FileExcelUtils.MultipartFileToFile(file);
        //读取文件
        ExcelReader reader = ExcelUtil.getReader(file1);
        List<List<Object>> read = reader.read();
        //进行判断
        if (read.size() > 2000) {
            return new Response().setCode(2001).setMessage("导入数据不能超过2000条");
        }
        //循环遍历
        for (int i = 2; i < read.size(); i++) {
            List add = read.get(i);
            if (!"".equals(add.get(2))) {
                RiskNameDto riskNameDto = new RiskNameDto();
                riskNameDto.setRowId(UUID.randomUUID().toString().replaceAll("-", ""));
                riskNameDto.setIsDelete("0");
                //设置标题名称
                String[] arr = new String[]{"序号", "预警编号", "风险名称", "发布条件", "风险等级", "电压等级", "发布人", "录入单位", "发布时间"};
                if (!add.get(1).toString().equals("") && add.get(1).toString() != null) {
                    riskNameDto.setWarningNo(add.get(1).toString());
                }else {
                    return new Response(2001,"第"+i+"行,预警编号不能为空");
                }

                if (!add.get(2).toString().equals("") && add.get(2).toString() != null) {
                    riskNameDto.setRiskName(add.get(2).toString());
                }else {
                    return new Response(2001,"第"+i+"行,风险名称不能为空");
                }

                if (!add.get(3).toString().equals("") && add.get(3).toString() != null) {
                    riskNameDto.setPublishTrade(add.get(3).toString());
                }else {
                    return new Response(2001,"第"+i+"行,发布条件不能为空");
                }

                if (!add.get(4).toString().equals("") && add.get(4).toString() != null) {
                    riskNameDto.setRiskLevel(add.get(4).toString());
                }else {
                    return new Response(2001,"第"+i+"行,风险等级不能为空");
                }

                if (!add.get(5).toString().equals("") && add.get(5).toString() != null) {
                    riskNameDto.setVoltageLevel(add.get(5).toString());
                }else {
                    return new Response(2001,"第"+i+"行,电压等级不能为空");
                }

                if (!add.get(6).toString().equals("") && add.get(6).toString() != null) {
                    riskNameDto.setCreater(add.get(6).toString());
                }else {
                    return new Response(2001,"第"+i+"行,发布人不能为空");
                }

                if (!add.get(7).toString().equals("") && add.get(7).toString() != null) {
                    riskNameDto.setDutyUnit(add.get(7).toString());
                }else {
                    return new Response(2001,"第"+i+"行,发布单位不能为空");
                }

                if (!add.get(8).toString().equals("") && add.get(8).toString() != null) {
                    riskNameDto.setCreateTime(add.get(8).toString());
                }else {
                    return new Response(2001,"第"+i+"行,发布时间不能为空");
                }
                //数据装入集合
                riskNameDtos.add(riskNameDto);
            }
            //判断为o  操作失败
            if (riskNameDtos.size()==0){
                return new Response(ErrorResult.OPERATION_FAILED.getCode(),ErrorResult.OPERATION_FAILED.getMessage());
            }
            //判断数据大于0
            if (riskNameDtos.size()>0){
                RiskNameDto riskNameDto=new RiskNameDto();
                riskNameDto.setMeasure(riskNameDtos);
               // Response listresponse =new Response();
                 riskNameDao.ImportRiskNameMessage(riskNameDto);
                return new Response(ErrorResult.OPERATION_SUCCESS.getCode(),ErrorResult.OPERATION_SUCCESS.getMessage());
            }else {
                return new Response().setCode(2001).setMessage("没有数据");
            }
        }

        return new Response(ErrorResult.OPERATION_SUCCESS.getCode(),ErrorResult.OPERATION_SUCCESS.getMessage());
    }


}
