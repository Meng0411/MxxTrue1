package com.aliyun.springboottrue.controller;

import com.aliyun.springboottrue.Entity.UserMessage;
import com.aliyun.springboottrue.Entity.dto.UserMessageDto;
import com.aliyun.springboottrue.service.UserMessageService;
import com.aliyun.springboottrue.utils.error.ErrorResult;
import com.aliyun.springboottrue.utils.error.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userMessage")
public class UserMessageController {
    @Resource
    private UserMessageService userMessageService;

    /**
     * @return 查询全部
     */
    @PostMapping("selectList")
    public Response<List<UserMessage>> selectList() {
        List<UserMessage> userMessages = userMessageService.selectList();
        return new Response<>(userMessages);
    }

    /**
     *
     * @param userMessage
     * @return 新增操作
     */

    @PostMapping("/addUserMessage")
    public Response AddUserMessage(UserMessage userMessage) {
        int num = userMessageService.AddUserMessage(userMessage);
        if (num > 0) {
            return new Response(ErrorResult.OPERATION_SUCCESS.getCode(), ErrorResult.OPERATION_SUCCESS.getMessage());
        }
        return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
    }
    @PostMapping("updateWrapper")
    public Response UpdateWrapper(@RequestBody UserMessageDto dto){
        int i = userMessageService.UpdateWrapper(dto);
        if (i>0){
            return new Response(i).setData(i);
        }
        return new Response(ErrorResult.OPERATION_FAILED.getCode(), ErrorResult.OPERATION_FAILED.getMessage());
    }
}
