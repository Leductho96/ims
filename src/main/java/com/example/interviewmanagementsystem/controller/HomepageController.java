package com.example.interviewmanagementsystem.controller;

import com.example.interviewmanagementsystem.config.security.SecurityUtils;
import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"imgAvatar", "imgAvatarNull"})
@RequiredArgsConstructor
public class HomepageController {

    private final UserService userService;

    @GetMapping("/")
    public String getHomepage(HttpSession session, Model model) {
        String username = SecurityUtils.getCurrentUserLogin().orElse("null");
        User user = userService.findByUserName(username);

        if (user.getAvatar() != null) {
            model.addAttribute("imgAvatar", user.getAvatar());
            model.addAttribute("imgAvatarNull", "off");
        } else {
            model.addAttribute("imgAvatar", "off");
            model.addAttribute("imgAvatarNull", "on");
        }

        return "homepage";
    }
}
