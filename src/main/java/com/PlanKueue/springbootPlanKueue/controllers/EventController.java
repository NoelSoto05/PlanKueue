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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.models.Event;
import com.PlanKueue.springbootPlanKueue.models.Note;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;
import com.PlanKueue.springbootPlanKueue.repository.EventRepository;
import com.PlanKueue.springbootPlanKueue.repository.NoteRepository;

import jakarta.validation.Valid;

//this declares this class as a controller
@Controller
public class EventController {
    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventRepository planKueueItemRepository;

    @Autowired
    private TaskRepository courseItemRepository;

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/")
    public ModelAndView index() {

        // this logger is at info level and will display the information in the
        // parameter when this call is ran
        logger.debug("Request to GET index page");
        ModelAndView modelAndView = new ModelAndView("index");

        // pull all the items out of the database and adds them to a list object with
        // the key name PlannerItems
        modelAndView.addObject("PlannerItems", planKueueItemRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid Event todoItem, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "add-todo-item";
        }

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

        planKueueItemRepository.save(todoItem);
        return "redirect:/";

    }

    @PostMapping("/courseAssignment")
    public String createCourseAssignment(@Valid Task courseItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-assignment";
        }
        courseItemRepository.save(courseItem);
        return "redirect:/";
    }

    @PostMapping("/courseAssignment/{courseId}")
    public String updateCourseItem(@PathVariable("courseId") long courseId, @Valid Task courseItem,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            courseItem.setAssignmentId(courseId);
            return "update-assignment";
        }
        courseItemRepository.save(courseItem);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveText(@RequestParam("note") String text){
        Note newNote = new Note(text);
        noteRepository.save(newNote);
        return "redirect:/";
    }
}
