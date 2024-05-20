package com.ijse.coursework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("api/v3/students")
public class DocumentationController {

    @GetMapping("/docs")
    public RedirectView redirectToSwaggerUI() {
        return new RedirectView("/swagger-ui/index.html");
    }
}