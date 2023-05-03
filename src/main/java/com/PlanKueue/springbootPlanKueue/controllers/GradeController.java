package com.PlanKueue.springbootPlanKueue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PlanKueue.springbootPlanKueue.models.Grade;

@Controller
public class GradeController {
  
    private List<Grade> grades = new ArrayList<Grade>();
    @RequestMapping("/grades")
    @GetMapping("/")
    public String index(Model model) {
        // add the list of grades to the model
        model.addAttribute("grades", grades);
        return "index";
    }
    
    @PostMapping("/addGrade")
    public String addGrade(@ModelAttribute("grade") Grade grade, Model model) {
        // add the new grade to the list of grades
        grades.add(grade);
        
        return "redirect:/";
    }
    
    @GetMapping("/calculateGPA")
    public String calculateGPA(Model model) {
        // calculate the GPA based on the grades in the model
        double totalPoints = 0.0;
        int totalCredits = 0;
        for (Grade grade : grades) {
            totalPoints += grade.getCredits() * grade.getGrade();
            totalCredits += grade.getCredits();
        }
        double gpa = totalPoints / totalCredits;
        
        // add the GPA to the model and return the GPA view
        model.addAttribute("gpa", gpa);
        return "gpa";
    }
}
