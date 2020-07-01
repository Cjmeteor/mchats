package com.mchat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TestLoginController
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/16 9:35
 */
@Controller
@RequestMapping(path = "/test")
public class TestLoginController {
    @RequestMapping("/regular_expression")
    public String index() throws  Exception{
        return "test/regular_expression_test";
    }
}
