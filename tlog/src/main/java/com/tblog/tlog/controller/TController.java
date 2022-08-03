package com.tblog.tlog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("T")
public class TController {


    @GetMapping("log")
    public String log() {
        return "log";
    }
}
