package com.PlanKueue.springbootPlanKueue.controllers;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PlanKueue.springbootPlanKueue.models.CourseItem;
import com.PlanKueue.springbootPlanKueue.models.PlanKueueItem;
import com.PlanKueue.springbootPlanKueue.repository.CourseItemRepository;
import com.PlanKueue.springbootPlanKueue.repository.PlanKueueItemRepository;

import jakarta.validation.Valid;

//this declares this class as a controller
@Controller
public class PlanKueueController {
    private final Logger logger = LoggerFactory.getLogger(PlanKueueController.class);

    @Autowired
    private PlanKueueItemRepository planKueueItemRepository;

    @Autowired
    private CourseItemRepository courseItemRepository;

    @GetMapping("/")
    public ModelAndView index() {

        //this logger is at info level and will display the information in the parameter when this call is ran
        logger.debug("Request to GET index page");
        ModelAndView modelAndView = new ModelAndView("index");

        // pull all the items out of the database and adds them to a list object with
        // the key name PlannerItems
        modelAndView.addObject("PlannerItems", planKueueItemRepository.findAll());

        return modelAndView;
    }
    @PostMapping("/todo")
    public String createTodoItem(@Valid PlanKueueItem todoItem, BindingResult result, Model model){

        if(result.hasErrors()){
            return "add-todo-item";
        }

        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        planKueueItemRepository.save(todoItem);
        
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid PlanKueueItem todoItem, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModifiedDate(Instant.now());

        planKueueItemRepository.save(todoItem);
        return "redirect:/";

    }

    @PostMapping("/courseAssignment")
    public String createCourseAssignment(@Valid CourseItem courseItem, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-course-item";
        }
        courseItemRepository.save(courseItem);
        return "redirect:/";
    }

    @PostMapping("/courseAssignment{courseId}")
    public String updateCourseItem(@PathVariable("courseId") long courseId, @Valid CourseItem courseItem, BindingResult result, Model model){
        if (result.hasErrors()){
            courseItem.setCourseId(courseId);
            return "update-course-item";
        }
        courseItemRepository.save(courseItem);
        return "redirect:/";
    }
}
