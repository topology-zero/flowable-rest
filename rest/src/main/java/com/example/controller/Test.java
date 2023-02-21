package com.example.controller;

import org.flowable.form.api.FormRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Test {

    @Autowired
    private FormRepositoryService formRepositoryService;

    @GetMapping("/test")
    public Map x() {
        formRepositoryService.createDeployment()
                .addString("xxx.form", "{}")
                .deploy();
        return new HashMap();
    }
}
