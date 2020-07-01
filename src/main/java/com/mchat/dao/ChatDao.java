package com.mchat.dao;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ChatDao
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:39
 */
@Service
public interface ChatDao {
    List queryUser(Map para) throws Exception;

    /**
     * 登录验证
     * @author zhangwenzhi
     * @date 2020/6/30 15:56
     */
    List verifyLoginInfo(Map para) throws Exception;
}
