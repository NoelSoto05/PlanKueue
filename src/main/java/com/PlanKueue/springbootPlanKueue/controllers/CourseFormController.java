package com.PlanKueue.springbootPlanKueue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;

@Controller
public class CourseFormController{

private final Logger logger = LoggerFactory.getLogger(EventFormController.class);

    @Autowired
    private CourseRepository courseItemRepository;

    @GetMapping("/addCourse")
    public String showCreateForm(Courses courseItem) {

        return "add-course";

    }

    @GetMapping("/editCourse/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Courses courseItem = courseItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course id: " + id + " not found"));

        model.addAttribute("course", courseItem);
        return "update-course";

    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        Courses courseItem = courseItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course id: " + id + " not found"));

        courseItemRepository.delete(courseItem);
        return "redirect:/";
    }
}