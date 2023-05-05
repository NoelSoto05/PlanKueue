package com.PlanKueue.springbootPlanKueue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;

@Controller
public class AssignmentFormController {

    private TaskRepository courseAssignmentRepository;

    @Autowired
    public void setCourseAssignmentRepository(TaskRepository courseAssignmentRepository) {
        this.courseAssignmentRepository = courseAssignmentRepository;
    }

    @GetMapping("/add-assignment")
    public String showCreateForm(Task courseAssignment) {
        return "add-assignment";
    }

    @GetMapping("/editAssignment/{assignmentId}")
    public String showUpdateForm(@PathVariable("assignmentId") long assignmentId, Model model) {
        Task courseAssignment = courseAssignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new IllegalArgumentException("assignemnt id: " + assignmentId + " not found"));

        model.addAttribute("courseAssignment", courseAssignment);
        return "update-assignment";

    }

    @GetMapping("/deleteAssignment/{assignmentId}")
    public String deleteTodoItem(@PathVariable("assignmentId") long courseId, Model model) {
        Task courseAssignment = courseAssignmentRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Assignment id: " + courseId + " not found"));

        courseAssignmentRepository.delete(courseAssignment);
        return "redirect:/";
    }

}
