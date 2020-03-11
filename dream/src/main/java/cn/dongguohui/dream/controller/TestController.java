package cn.dongguohui.dream.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return new Date().toString();
    }
}
