package com.aliyun.springboottrue.service;

import com.aliyun.springboottrue.Entity.UserMessage;
import com.aliyun.springboottrue.Entity.dto.UserMessageDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserMessageService  extends IService<UserMessage> {

    List<UserMessage> selectList();

    int AddUserMessage(UserMessage userMessage);

    int UpdateWrapper(UserMessageDto dto);
}
