package com.PlanKueue.springbootPlanKueue.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.models.Event;
import com.PlanKueue.springbootPlanKueue.models.PlannerKueue;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;
import com.PlanKueue.springbootPlanKueue.repository.EventRepository;
import com.PlanKueue.springbootPlanKueue.repository.NoteRepository;

import jakarta.validation.Valid;

//this declares this class as a controller
@Controller
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private EventRepository planKueueItemRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CourseRepository courseRepository;

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
        modelAndView.addObject("Courses", courseRepository.findAll());
        modelAndView.addObject("Tasks", taskRepository.findAll());

        Iterable<Task> tasks = taskRepository.findAll();
        PlannerKueue queue = new PlannerKueue();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = now.format(formatter);

        // Add all tasks to the queue
        for (Task task : tasks) {
            if (task.getDueDate() != null) {
                queue.addTask(task, formattedDate);
            }
        }
        modelAndView.addObject("DQueue", queue.getDaily_Planner_Queue());
        modelAndView.addObject("GQueue", queue.getGeneral_Planner_Queue());
        modelAndView.addObject("Notes", noteRepository.findAll());
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
    public String createCourseAssignment(@Valid Task assignmentItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-assignment";
        }
        taskRepository.save(assignmentItem);
        return "redirect:/";
    }

   @PostMapping("/courseAssignment/{assignmentId}")
public String updateCourseItem(@PathVariable Long assignmentId, @ModelAttribute("task") Task task, Model model) {
    //update the task with the new information
    taskRepository.save(task);

    //redirect back to the root URL after the form has been submitted
    return "redirect:/";
}

    @PostMapping("/course")
    public String createCourse(@Valid @ModelAttribute("course") Courses course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }
        courseRepository.save(course);
        return "redirect:/";
    }

    @PostMapping("/course/{courseId}")
    public String updateCourse(@PathVariable("courseId") long courseId, @Valid Courses course,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setCourseId(courseId);
            return "update-course";
        }
        courseRepository.save(course);
        return "redirect:/";
    }
    

}
