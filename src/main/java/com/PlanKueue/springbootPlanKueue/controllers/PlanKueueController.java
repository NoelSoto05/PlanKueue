package com.PlanKueue.springbootPlanKueue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//this declares this class as a controller
@Controller
public class PlanKueueController {
    private final Logger logger = LoggerFactory.getLogger(PlanKueueController.class);

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("Request to GET index page");
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

}
