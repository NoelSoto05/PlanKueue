package com.PlanKueue.springbootPlanKueue.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.PlanKueue.springbootPlanKueue.models.PlanKueueItem;
import com.PlanKueue.springbootPlanKueue.repository.PlanKueueItemRepository;

@Controller
public class PlanKueueFormController {

    private final Logger logger = LoggerFactory.getLogger(PlanKueueFormController.class);

    @Autowired
    private PlanKueueItemRepository planKueueItemRepository;

    @GetMapping("/create-todo")
    public String showCreateForm(PlanKueueItem todoItem) {

        return "add-todo-item";

    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        PlanKueueItem plannerItem = planKueueItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", plannerItem);
        return "update-planner-item";

    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        PlanKueueItem todoItem = planKueueItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        planKueueItemRepository.delete(todoItem);
        return "redirect:/";
    }

}
