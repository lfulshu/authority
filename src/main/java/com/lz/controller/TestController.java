package com.lz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author liizzz
 * @Data 2019/9/4 21:36
 */
@Controller
@RequestMapping(value = "test")
@Slf4j
public class TestController {

    @RequestMapping(value = "hello")
    @ResponseBody
    public String hello(){
        log.info("hello");
        return "halo authority";
    }

}
