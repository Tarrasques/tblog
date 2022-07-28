package com.tblog.tlog.controller;

import com.tblog.tlog.utils.TLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/s")
    @TLog(operateClass = "TestsController",operateMethod = "test")
    public String tests(String id){
        return "hello AOP"+id;
    }

    @GetMapping("/e")
    @TLog(operateClass = "TesteController",operateMethod = "test")
    public void teste(String id){
        int i = 0;
        i = i/0;
    }
}
