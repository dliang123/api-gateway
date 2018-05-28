package com.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author dengliang
 * @Email liang.deng@atzuche.cn
 * @Date Created in 16:56 2018/5/15
 */
@RestController
@RequestMapping("gradle")
public class TestController {

    @RequestMapping("hello")
    public String hello() {
        return "hello spring boot";
    }
}
