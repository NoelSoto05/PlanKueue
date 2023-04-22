package com.PlanKueue.springbootPlanKueue.models;

import java.time.Instant;
import java.util.ArrayList;

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

    // Array of categories belonging to the course
    // private ArrayList<CategoryItem> categoryList = new
    // ArrayList<CategoryItem>(10);

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
    }

    // Functionality for pure java
    // Adds category to categoryList if category doesn't exist
    /*
     * public void addCategory(String categoryName){
     * int index = inList(categoryName);
     * if (index == -1){
     * CategoryItem newCategory = new CategoryItem(categoryName);
     * categoryList.add(newCategory);
     * }
     * }
     * 
     * private int inList(String taskName){
     * int at = -1;
     * for (int i = 0; i < categoryList.size(); i++){
     * if (categoryList.get(i).getCategoryName().equals(taskName))
     * at = i;
     * }
     * return at;
     * }
     */
}
