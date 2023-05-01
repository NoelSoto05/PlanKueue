package com.PlanKueue.springbootPlanKueue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PlanKueue.springbootPlanKueue.models.Account;

@Controller
public class Register {

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    /**
     * @param account
     * @param result
     * @return
     */
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("account") Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        
        return "redirect:/login";
    }
}
