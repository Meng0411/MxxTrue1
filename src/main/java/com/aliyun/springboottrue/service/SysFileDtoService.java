//package com.aliyun.springboottrue.service;
//
//import com.aliyun.springboottrue.Entity.dto.SysFileDto;
//import com.aliyun.springboottrue.utils.error.Response;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.ArrayList;
//
//public interface SysFileDtoService {
//    //文件批量上传
//    @RequestMapping(value = "/fileUploadBatch", method = {RequestMethod.POST}, consumes = {"multpart/form-data"})
//    Response<ArrayList<SysFileDto>> fileUploadBatch(@RequestPart("file") MultipartFile[] file, @RequestParam("fileSource") String fileSource
//            , @RequestParam("userId") String userId);
//
//    //单个文件下载
//    @RequestMapping(value = "/fileDownload", method = {RequestMethod.POST})
//    void fileDownload(@RequestParam("uuid") String uuid);
//
////    @RequestMapping(value = "/queryFileInfoById", method = {RequestMethod.POST})
////    Response<ArrayList<SysFileDto>> queryFileInfoById(@RequestBody FileIds ids);
//}
