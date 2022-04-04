package com.aliyun.springboottrue.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @Author MengXX
 * @Decription:文件上传下载
 * @Date 2022/3/12  16:34
 */
@RestController
@Slf4j
@RequestMapping("/file")
public class FileUpload {
//    @Resource
//    private FileUploadService fileUploadService;
    //文件上传
    @PostMapping("uploadFile")
    public String fileUpload(MultipartFile file) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        if (file.isEmpty()) {
            jsonObject.put("error", "空文件");
            return jsonObject.toString();
        }
        //文件名
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        log.info("上传文件名称为{}", originalFilename, substring);
        File file1 = new File("E:\\" + originalFilename);
        //检测目录是否存在
        if (file1.getParentFile().exists()) {
            file1.getParentFile().mkdir();
        }
        //使用的文件名是否存在
        if (file1.exists()) {
            jsonObject.put("error", "已存在");
        }
        try {
            FileUtil.writeBytes(file.getBytes(), file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonObject.put("success", "上传成功");
        return jsonObject.toString();
    }
//文件下载
    @GetMapping("/downloadFile")
    public String DownloadFile(HttpServletResponse response, @RequestParam("filename") String filename) throws IOException {
        JSONObject jsonObject = new JSONObject();
        File file = new File("E:\\"+filename);
        if (!file.exists()) {
            jsonObject.put("error", "下载的文件不存在");
        }
        response.reset();

        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        byte[] read = FileUtil.readBytes(file);
        String name = new String(read, "ISO-8859-1");
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("Content-Disposition", "attachment=" + "filename"+name);


        outputStream.write(read);
        jsonObject.put("SUCCESS", "下载成功");
        return jsonObject.toString();
    }


    /**
     *  @Author MengXX
     *  @Decription:文件上传
     *  @Date 2022/3/22  14:15
     */
//    @PostMapping("uploadFileWork")
//    public Response uploadBatchFile(@RequestBody MultipartFile[] file,String createOperatorId,String create,String organzationId,String organzationName){
//        return fileUploadService.uploadBatchFile(file,createOperatorId,create,organzationId,organzationName);
//    }
}
