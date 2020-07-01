package com.mchat.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhangwenzhi
 * @time: 2020/4/21 17:14
 */
@Controller
public class loginController {
    @RequestMapping({"/","/mchat"})
    public String mchat() throws  Exception{
        return "mchat/mchat";
    }

    @RequestMapping("/login")
    public String login() throws  Exception{
        return "mchat/mchat_login";
    }

    @RequestMapping("/index")
    public String index() throws  Exception{
        return "mchat/websocket";
    }

    @RequestMapping("/chatRoom")
    public String room() throws  Exception{
        return "mchat/chat_room";
    }

    @RequestMapping("/test")
    public String test() throws  Exception{
        return "test/test_main";
    }
}
