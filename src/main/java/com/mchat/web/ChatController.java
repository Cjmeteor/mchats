package com.mchat.web;

import com.mchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ChatController
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:36
 */
@Controller
@RequestMapping(path = "/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/queryUser")
    @ResponseBody
    public List queryUser() throws  Exception{
        return chatService.queryUser();
    }

}
