package com.aliyun.springboottrue.utils.Excel;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author MengXX
 * @Decription:数据切割
 * @Date 2022/3/8  16:18
 */
public class FileExcelUtils {
    /**
     * 数据切割
     */
    public static List<List<String>>getFileExcelList(List<String>list){
        List<List<String>>paramList=new ArrayList<>();
        if (list.size()>1000){
            int size=(list.size()+900)/1000;
            paramList=new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                paramList.add(list.subList(i*1000,Math.min((i+1)*1000,list.size())));
            }
        }else {
            if (list.size()>0){
                paramList.add(list);
            }
        }
        return paramList;
    }
    /**
     * 文件工具类
     */
    public static File MultipartFileToFile(MultipartFile multipartFile){
        //获取文件名
        String fileName=multipartFile.getOriginalFilename();
        //获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        try {
            File file=File.createTempFile(fileName.substring(0,fileName.indexOf(".")),prefix);
            multipartFile.transferTo(file);
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
