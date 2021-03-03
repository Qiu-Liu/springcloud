package com.example.bootdemo.controller;

import com.example.bootdemo.entity.People;
import com.example.bootdemo.entity.User;
import com.example.bootdemo.util.ParmOne;
import com.example.bootdemo.util.ParmTwo;
import com.example.bootdemo.util.TradeCheck;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class SpringBootTestController {

    @TradeCheck
    @PostMapping("/test")
    public String getTest(@RequestBody @ParmOne User user, @ParmTwo People people){
        return "success";
    }
}
