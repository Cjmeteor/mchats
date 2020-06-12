package com.mchat.service;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 * ChatService
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:38
 */
public interface ChatService {
    List queryUser() throws Exception;
}
