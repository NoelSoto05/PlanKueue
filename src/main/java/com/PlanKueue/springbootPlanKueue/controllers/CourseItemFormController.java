package com.PlanKueue.springbootPlanKueue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PlanKueue.springbootPlanKueue.models.CourseItem;
import com.PlanKueue.springbootPlanKueue.repository.CourseItemRepository;

@Controller
public class CourseItemFormController {

    private final Logger logger = LoggerFactory.getLogger(CourseItemFormController.class);

    @Autowired
    private CourseItemRepository courseItemRepository;

    @GetMapping("/add-course")
    public String showCreateForm(CourseItem courseItem){
        return "add-course-item";
    }

    @GetMapping("/edit/{courseId}")
    public String showUpdateForm(@PathVariable("courseId") long courseId, Model model) {
        CourseItem courseItem = courseItemRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + courseId + " not found"));

        model.addAttribute("courseAssignment", courseItem);
        return "update-course-item";

    }

    @GetMapping("/delete/{courseId}")
    public String deleteTodoItem(@PathVariable("courseId") long courseId, Model model) {
        CourseItem courseItem = courseItemRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + courseId + " not found"));

        courseItemRepository.delete(courseItem);
        return "redirect:/";
    }

}
