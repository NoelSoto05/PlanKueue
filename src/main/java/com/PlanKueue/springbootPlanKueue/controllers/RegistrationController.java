package com.PlanKueue.springbootPlanKueue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PlanKueue.springbootPlanKueue.models.Account;

import de.japrost.jabudget.repository.AccountRepository;

@Controller
public class RegistrationController {

    @Autowired
    private AccountRepository accountRepository;

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
        
        AccountRepository.save(account);
        
        return "redirect:/login";
    }
}
