package com.mchat.service.impl;

import com.mchat.dao.ChatDao;
import com.mchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ChatServiceImpl
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:38
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatDao chatDao;

    @Override
    public List queryUser() throws Exception {
        return chatDao.queryUser();
    }
}
