package com.mchat.mybatis;

import com.mchat.entity.User;

import java.util.List;
import java.util.Map;

/**
 * UserMapper
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/7/1 11:27
 */
public interface UserMapper {

    List verifyLoginInfo(Map para) throws Exception;
}
