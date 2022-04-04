package com.aliyun.springboottrue.utils.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.aliyun.springboottrue.Entity.dto.RiskNameDto;
import org.junit.Test;
import org.springframework.util.unit.DataUnit;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        //54b01b035c314e4fa0536f15b61d9c14
        String id = UUID.randomUUID().toString().replace("-","");
        System.out.println(id);

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);

    }
    @Test
    public void Test(){
      List<RiskNameDto>list=new ArrayList<>();
      list.forEach(E->{
         E.setDutyUnit("1");
      });

    }
    @Test
    public void Test01(){
        List<RiskNameDto> list=new ArrayList<>();
        List<String> collect = list.stream().map(c->c.getPublishTrade()).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * @Author MengXX
     * @Decription:测试糊涂工具包
     * @Date 2022/3/9  14:05
     */
    @Test
    public void  test02(){
        String now = DateUtil.now();
        DateUtil.today();
        String a="2022-2-2 18:33";
        DateTime parse = DateUtil.parse(a, "yyyy-MM-dd ");
        System.out.println(a);
        System.out.println(parse);
    }
}
