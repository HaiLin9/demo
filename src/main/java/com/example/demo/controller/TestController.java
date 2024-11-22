package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @GetMapping("/get")
    public String getSessionAttribute(HttpSession session) {
        return (String) session.getAttribute("key");
    }

    @GetMapping("/set")
    public String setSessionAttribute(HttpSession session) {
        session.setAttribute("key", "value");
        return "Session attribute set";
    }

}
