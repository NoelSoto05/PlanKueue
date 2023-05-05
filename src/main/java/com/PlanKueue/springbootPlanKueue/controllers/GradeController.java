package com.PlanKueue.springbootPlanKueue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PlanKueue.springbootPlanKueue.models.Grade;

@Controller
public class GradeController {

    private List<Grade> grades = new ArrayList<Grade>();

    @GetMapping("/GPA")
    public String index(Model model) {
        // add the list of grades to the model
        model.addAttribute("grades", grades);
        model.addAttribute("grade", new Grade()); // add a new Grade object to the model for the form
        return "grade";
    }

    @PostMapping("/addGrade")
    public String addGrade(@ModelAttribute("grade") Grade grade, Model model) {
        // add the new grade to the list of grades
        grades.add(grade);

        // add the list of grades to the model
        model.addAttribute("grades", grades);
        model.addAttribute("grade", new Grade()); // add a new Grade object to the model for the form

        return "grade";
    }

    @PostMapping("/calculateGPA")
    public String calculateGPA(Model model) {
        // calculate the GPA based on the grades in the model
        double gpa = 0.0;
        double totalPoints = 0.0;
        int totalCredits = 0;
        for (Grade grade : grades) {
            totalPoints += grade.getCredits() * grade.getGrade();
            totalCredits += grade.getCredits();
        }
        gpa = totalPoints / totalCredits;

        // add the GPA to the model and return the GPA view
        model.addAttribute("gpa", gpa);
        return "grade";
    }

    @PostMapping("/deleteGrade")
    public String deleteGrade(@RequestParam("index") int index) {
        grades.remove(index);
        return "redirect:/GPA";
    }

}
