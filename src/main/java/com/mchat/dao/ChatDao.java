package com.mchat.dao;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ChatDao
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:39
 */
@Service
public interface ChatDao {
    List queryUser() throws Exception;
}
