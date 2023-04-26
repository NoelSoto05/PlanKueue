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

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.models.Event;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;
import com.PlanKueue.springbootPlanKueue.repository.EventRepository;

import jakarta.validation.Valid;

//this declares this class as a controller
@Controller
public class EventController {
    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private TaskRepository assignmentItemRepository;
    private CourseRepository courseRepository;
    private EventRepository planKueueItemRepository;

    @GetMapping("/")
    public ModelAndView index() {

        // this logger is at info level and will display the information in the
        // parameter when this call is ran
        logger.debug("Request to GET index page");
        ModelAndView modelAndView = new ModelAndView("index");

        // pull all the items out of the database and adds them to a list object with
        // the key name PlannerItems
        modelAndView.addObject("PlannerItems", planKueueItemRepository.findAll());
        modelAndView.addObject("CourseItems", courseRepository.findAll());

        return modelAndView;
    }

//Events
    @PostMapping("/todo")
    public String createTodoItem(@Valid Event todoItem, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-todo-item";
        }

        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        planKueueItemRepository.save(todoItem);

        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid Event todoItem, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModifiedDate(Instant.now());

        planKueueItemRepository.save(todoItem);
        return "redirect:/";

    }

//Tasks
    @PostMapping("/courseAssignment")
    public String createCourseAssignment(@Valid Task courseItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-assignment";
        }
        assignmentItemRepository.save(courseItem);
        return "redirect:/";
    }

    @PostMapping("/courseAssignment/{courseId}")
    public String updateCourseItem(@PathVariable("assignmentId") long assignmentId, @Valid Task assignmentItem,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            assignmentItem.setAssignmentId(assignmentId);
            return "update-assignment";
        }
        assignmentItemRepository.save(assignmentItem);
        return "redirect:/";
    }

//Courses
    @PostMapping("/course")
    public String createCourse(@Valid Courses course, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-course";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

    @PostMapping("/course{courseId}")
    public String updateCourse(@PathVariable("courseId") long courseId, @Valid Courses courses, BindingResult result, Model model){
        if (result.hasErrors()){
            courses.setCourseId(courseId);
            return "update-course";
        }
        courseRepository.save(courses);
        return "redirect:/";
    }
}
