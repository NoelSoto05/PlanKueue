package com.PlanKueue.springbootPlanKueue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//Assignments
@Entity
@Table(name = "Course_Assignment")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long assignmentId;

    @Getter
    @Setter
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Getter
    @Setter
    private double grade;

    @Getter
    @Setter
    private String dueDate;

    @Getter
    @Setter
    private double possiblePoints;

    @Getter
    @Setter
    private double earnedPoints;

    @Getter
    @Setter
    private boolean completed;

    // Default constructor
    public Task() {
    }

    // Parameterized constructor
    public Task(String name) {
        this.name = name;
        this.grade = 0.0;
        this.possiblePoints = 0.0;
        this.earnedPoints = 0.0;
        this.dueDate = "";
        this.completed = false;
    }
}
