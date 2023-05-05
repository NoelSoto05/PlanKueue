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

    public void setAssignmentId(Long assignmentId) {
        if (assignmentId < 0) {
            throw new IllegalArgumentException("Assignment ID cannot be negative");
        }
        this.assignmentId = assignmentId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setPossiblePoints(double possiblePoints) {
        if (possiblePoints < 0.0) {
            throw new IllegalArgumentException("Possible points cannot be negative");
        }
        this.possiblePoints = possiblePoints;
    }

    public void setEarnedPoints(double earnedPoints) {
        if (earnedPoints > possiblePoints) {
            throw new IllegalArgumentException("Earned points cannot be greater than possible points");
        }
        this.earnedPoints = earnedPoints;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate != null ? dueDate : "";
    }

    public double getGrade() {
        if (possiblePoints == 0.0) {
            return 0.0;
        }
        return earnedPoints / possiblePoints * 100.0;
    }

}
