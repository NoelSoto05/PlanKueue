package com.PlanKueue.springbootPlanKueue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PlanKueue.springbootPlanKueue.repository.PlanKueueItemRepository;

//this declares this class as a controller
@Controller
public class PlanKueueController {
    private final Logger logger = LoggerFactory.getLogger(PlanKueueController.class);

    @Autowired
    private PlanKueueItemRepository planKueueItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug("Request to GET index page");
        ModelAndView modelAndView = new ModelAndView("index");

        // pull all the items out of the database and adds them to a list object with
        // the key name PlannerItems
        modelAndView.addObject("PlannerItems", planKueueItemRepository.findAll());

        return modelAndView;
    }

}
