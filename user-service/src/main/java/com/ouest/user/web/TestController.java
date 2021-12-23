package com.ouest.user.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("test")
@RefreshScope
public class TestController {

    @Value("${dateformataa}")
    private String dateformat;

    @GetMapping("now")
    public String now() {
        System.out.println("------------------:"+dateformat+"|over");
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    }
}
