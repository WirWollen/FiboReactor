package com.example.FiboReact.controllers;

import com.example.FiboReact.services.LogicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Api("Swagger illustration")
public class ConfiguratorSecondController {
    @Autowired
    LogicService logicService;

    @GetMapping("/second")
    @ApiOperation("show configuratorSecondResult")
    public Flux<Integer> subsSecond(){
        return logicService.configuratorSecond();
    }
}
