package com.arthas.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linyang on 19/7/15.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(@RequestParam String msg) {
        return "hello " + msg;
    }
}
