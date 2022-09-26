package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/test")
    public Map test() {
        Map<String, String> m = new HashMap<>();
        m.put("a", "1");
        m.put("b", "2");
        return m;
    }
}
