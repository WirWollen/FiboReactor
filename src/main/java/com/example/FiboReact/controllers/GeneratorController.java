package com.example.FiboReact.controllers;

import com.example.FiboReact.Logic;
import com.example.FiboReact.entities.ValueOfYAML;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@RestController
@Api(description = "Swagger illustration")
@RequestMapping("/generator")
public class GeneratorController {
    @Autowired
    Logic logic;

    @GetMapping
    @ApiOperation("show generator")
    public Flux fluxGenerator(){
        return logic.fluxGenerator();
    }

}
