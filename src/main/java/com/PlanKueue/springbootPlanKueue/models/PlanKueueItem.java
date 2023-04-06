package com.PlanKueue.springbootPlanKueue.models;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PlanKueue_Item")
public class PlanKueueItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    /*
     * FYI:
     * 
     * @Getter and @Setter are functions of the Lombok library which allows us to
     * avoid having to write the getter and setter for every variable.
     * Instead what his does is it acts as a boiletplate which lets us avoid
     * writting giant ammounts of code for each setter and getter without
     * sacrificing functionality, making it easier to work with and maintain in the
     * long run.
     */

    /* Stores the ID if the task */
    @Getter
    @Setter
    private Long id;

    /* Stores the description of the task */
    @Getter
    @Setter
    private String description;

    /* Stores wether or not a task was completed, Default is false */
    @Getter
    @Setter
    private boolean complete;

    /* Fetches the date the task is created */
    @Getter
    @Setter
    private Instant createdDate;
    /* Fetches the date the task was modified at */
    @Getter
    @Setter
    private Instant modifiedDate;

    /* Fetches the due date for the assignment */
    @Getter
    @Setter
    private String dueDate;
    /* Fetches the amount of points the assignment is worth */

    @Getter
    @Setter
    private double assignmentPoints;
    /* Fetches a note if it was added to the task */
    @Getter
    @Setter
    private String taskNote;

    // empty default constructor
    public PlanKueueItem() {

    }

    /**
     * 
     * 
     * Main constructor which initiates multiple variables that are needed to create
     * and item or task in the planner
     * A description of the item needs to be passed in to create a new item.
     * Initializes complete as false;
     * initializes createDate to current time
     * initializes modifiedDate to current time
     * 
     * @param description
     */
    public PlanKueueItem(String description) {

        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
        this.dueDate = "";
        this.assignmentPoints = 0.0;
        this.taskNote = "";

    }

    /*
     * Here we are overidding the string method so that the system knows how to
     * display all the data we just assined.
     */
    @Override
    public String toString() {
        return String.format(
                "PlanKueueItem{id='%d', description = '%s', complete = '%s', createdDate= '%s', modifiedDate ='%s'}",
                id, description, complete, createdDate, modifiedDate, dueDate);
    }

}
