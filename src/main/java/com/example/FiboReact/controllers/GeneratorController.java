package com.example.FiboReact.controllers;

import com.example.FiboReact.elements.values.GetValue;
import com.example.FiboReact.services.LogicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Api(description = "Swagger illustration")
//@RequestMapping("/generator")
public class GeneratorController {
    @Autowired
    LogicService logicService;

    @GetMapping("/flux")
    @ApiOperation("show fluxGenerator")
    public  Flux<GetValue>  fluxGenerator(){
        return logicService.subscriberMaxSecond();
    }


}
