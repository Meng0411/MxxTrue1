//package com.aliyun.springboottrue.service.impl;
//
//import com.aliyun.springboottrue.Entity.SysFileWork;
//import com.aliyun.springboottrue.Entity.dto.SysFileDto;
//import com.aliyun.springboottrue.Entity.dto.SysFileWorkDto;
//import com.aliyun.springboottrue.dao.SysFileWorkDao;
//import com.aliyun.springboottrue.service.FileUploadService;
//import com.aliyun.springboottrue.service.SysFileDtoService;
//import com.aliyun.springboottrue.utils.error.ErrorResult;
//import com.aliyun.springboottrue.utils.error.Response;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FileUploadServiceImpl extends ServiceImpl<SysFileWorkDao,SysFileWork> implements FileUploadService {
//    @Resource
//    private SysFileDtoService sysFileDtoService;
//
//    @Override
//    public Response uploadBatchFile(MultipartFile[] file, String createOperatorId, String create,
//                                    String organzationId, String organzationName) {
//        Response res = uploadBatch(file,create,createOperatorId);
//        if (res.getCode()==200){
//
//            SysFileWorkDto  sys=new SysFileWorkDto();
//            sys.setCreateOperatorId(createOperatorId);
//            sys.setCreate(create);
//            sys.setOrganzationId(organzationId);
//            sys.setOrganzationName(organzationName);
//            boolean b = addBatch(sys);
//            if (res.getCode()!=200){
//                return new Response(b);
//            }
//        }
//        return res;
//    }
//    //新增
//    public boolean addBatch(SysFileWorkDto dto){
//        int a=0;
//        boolean flag=true;
//        List<String>ids=new ArrayList<>();
//        List<SysFileWork> sysFileWorks = new ArrayList<>();
//        for (String id : ids) {
//            a++;
//            SysFileWork sys=new SysFileWork();
//            sys.setId(a);
//            sys.setCreateTime(LocalDateTime.now().toString());
//            sys.setUpdateTime(LocalDateTime.now().toString());
//            sys.setOrganzationName(dto.getOrganzationName());
//            sys.setOrganzationId(dto.getOrganzationId());
//            sys.setCreateOperatorId(dto.getCreateOperatorId());
//            sys.setIsDelete("0");
//            sys.setIsValue(id);
//            flag = sysFileWorks.add(sys);
//        }
//             return  flag;
//    }
//
//    //批量上传
//    public Response uploadBatch(MultipartFile[] files, String create, String createOperatorId) {
//        Response<ArrayList<SysFileDto>> arr = sysFileDtoService.fileUploadBatch(files, create, createOperatorId);
//        if (arr.getData().equals(ErrorResult.OPERATION_SUCCESS.getCode())) {
//            return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
//        }
//        ArrayList<SysFileDto> data = arr.getData();
//        if (data.size() == 0) {
//            return new Response(ErrorResult.DATA_NO_DATA.getCode(), ErrorResult.DATA_NO_DATA.getMessage());
//        }
//        //上传ID返回
//        List<String> ids = new ArrayList<>();
//        for (SysFileDto dto : data) {
//            ids.add(dto.getId());
//        }
//        return new Response(ids);
//    }
//}
