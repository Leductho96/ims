package com.example.interviewmanagementsystem.exceptionHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringExceptionController {
    @GetMapping("/no-permission")
    public String getError403() {
        return "error/403";
    }

}
