package com.example.FiboReact.controllers;

import com.example.FiboReact.Logic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Api(description = "Swagger illustration")
public class SubsMaxSecond {
    @Autowired
    Logic logic;

    @GetMapping("/second")
    @ApiOperation("show subscriberMaxSecond")
    public Flux<Integer> subsSecond(){
        return logic.subscriberMaxSecond();
    }
}
