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
public class CourseFormController {

    private final Logger logger = LoggerFactory.getLogger(CourseFormController.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/add-course")
    public String showCreateCourseForm(Model model) {
        model.addAttribute("course", new Courses());
        return "add-course";
    }

    @GetMapping("/editCourse/{courseId}")
    public String showUpdateCourseForm(@PathVariable("courseId") long courseId, Model model) {
        Courses course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course id: " + courseId + " not found"));

        model.addAttribute("course", course);
        return "update-course";

    }

    @GetMapping("/deleteCourse/{courseId}")
    public String deleteTodoCourseItem(@PathVariable("courseId") long courseId, Model model) {
        Courses course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course id: " + courseId + " not found"));

        courseRepository.delete(course);
        return "redirect:/";
    }

}
