package com.mchat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mchat.dao.ChatDao;
import com.mchat.mybatis.UserMapper;
import com.mchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private UserMapper userMapper;

    @Override
    public List queryUser(Map para) throws Exception {
        return chatDao.queryUser(para);
    }

    @Override
    public List verifyLoginInfo(Map para) throws Exception{
        //return chatDao.verifyLoginInfo(para);
        return userMapper.verifyLoginInfo(para);
    }
}
