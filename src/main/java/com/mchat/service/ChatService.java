package com.mchat.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * ChatService
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:38
 */
public interface ChatService {
    List queryUser(Map para) throws Exception;

    List verifyLoginInfo(Map para) throws Exception;
}
