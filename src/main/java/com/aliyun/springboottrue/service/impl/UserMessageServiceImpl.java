package com.aliyun.springboottrue.service.impl;

import com.aliyun.springboottrue.Entity.UserMessage;
import com.aliyun.springboottrue.Entity.dto.UserMessageDto;
import com.aliyun.springboottrue.dao.UserMessageDao;
import com.aliyun.springboottrue.service.UserMessageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import sun.plugin2.os.windows.FLASHWINFO;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserMessageServiceImpl extends ServiceImpl<UserMessageDao, UserMessage> implements UserMessageService {
    @Resource
    private UserMessageDao userMessageDao;

    @Override
    public List<UserMessage> selectList() {

        List<UserMessage> userMessages = userMessageDao.selectList(null);
        return userMessages;
    }

    @Override
    public int AddUserMessage(UserMessage userMessage) {
        String id = UUID.randomUUID().toString().replace("-", "");
        userMessage.setId(id);
        userMessage.setCreateTime(LocalDateTime.now().toString());
        userMessage.setUpdateTime(LocalDateTime.now().toString());
        userMessage.setName("孟祥鑫");
        userMessage.setAge(22);
        int insert = userMessageDao.insert(userMessage);
        return insert;
    }


    @Override
    public int UpdateWrapper(UserMessageDto dto) {
        LambdaUpdateWrapper<UserMessage> updateWrapper=new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserMessage::getId,dto.getId());
        updateWrapper.set(UserMessage::getAge,30);
        updateWrapper.set(UserMessage::getName,dto.getName());
        int update = userMessageDao.update(new UserMessage(), updateWrapper);
        return update;
    }

}
