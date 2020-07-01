package com.mchat.web;

import com.alibaba.fastjson.JSONObject;
import com.mchat.entity.User;
import com.mchat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map queryUser(@RequestBody Map para) throws  Exception{
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",true);
        List data = new ArrayList();
        try{
            data = chatService.queryUser(para);
        }catch (Exception e){
            result.put("success",false);
            result.put("msg",e.getMessage());
        }
        result.put("data",data);
        return result;
    }

    /**
     * 登录验证
     * @author zhangwenzhi
     * @date 2020/6/30 14:49
     */
    @PostMapping("/doUserAuth")
    @ResponseBody
    public Map doUserAuth(@RequestBody Map map) throws  Exception{
        List list = chatService.verifyLoginInfo(map);

        Map<String,Object> result = new HashMap<String,Object>();
        User user = new User();
        if(list.size()<1){
            result.put("success",false);
            return result;
        }
        user = (User)list.get(0);
        result.put("success",true);
        result.put("userid",user.getUserid());
        return result;
    }

}
