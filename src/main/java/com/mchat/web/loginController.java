package com.mchat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: zhangwenzhi
 * @time: 2020/4/21 17:14
 */
@Controller
public class loginController {
    @RequestMapping({"/","/login"})
    public String meteor() throws  Exception{
        return "websocket";
    }

    @RequestMapping("/index")
    public String index() throws  Exception{
        return "index";
    }
}
