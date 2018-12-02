package com.irving.rabbitmq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: rabbitmqProject2
 * Date: 2018-12-01
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
