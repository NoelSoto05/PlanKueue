package com.PlanKueue.springbootPlanKueue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;

@Controller
public class AssignmentFormController {

    private final Logger logger = LoggerFactory.getLogger(AssignmentFormController.class);

    @Autowired
    private TaskRepository courseAssignmentRepository;

    @GetMapping("/add-assignment")
    public String showCreateForm(Task courseAssignment) {
        return "add-assignment";
    }

    @GetMapping("/editAssignment/{courseId}")
    public String showUpdateForm(@PathVariable("assignmentId") long courseId, Model model) {
        Task courseAssignment = courseAssignmentRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("assignemnt id: " + courseId + " not found"));

        model.addAttribute("courseAssignment", courseAssignment);
        return "update-assignment";

    }

    @GetMapping("/deleteAssignment/{courseId}")
    public String deleteTodoItem(@PathVariable("assignmentId") long courseId, Model model) {
        Task courseAssignment = courseAssignmentRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment id: " + courseId + " not found"));

        courseAssignmentRepository.delete(courseAssignment);
        return "redirect:/";
    }

}
