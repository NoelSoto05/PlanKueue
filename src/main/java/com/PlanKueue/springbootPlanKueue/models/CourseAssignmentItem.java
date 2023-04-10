package com.PlanKueue.springbootPlanKueue.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Course_Planner_Items")
public class CourseAssignmentItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /* Stores the Id of the Course Item */
    @Getter
    @Setter
    private Long id;

    /** Stores the name of the course item aka something that is due */
    @Getter
    @Setter
    @NotBlank(message = "Assignment must have a name")
    private String name;

    /** Marks wheather or not the assignment was completed */
    @Getter
    @Setter
    private boolean complete;
    /** Used for storage of the date the assignment is due */
    @Getter
    @Setter
    private String dueDate;
    /** Stores the points for the assignment */
    @Getter
    @Setter
    private double assignmentPoints;

    /** Stores a note for the assignment */
    @Getter
    @Setter
    private String assignmentNote;

    public CourseAssignmentItem() {

    }

    /**
     * Creates a new instance of the {@code CoursePlannerItem} class with the
     * specified name of the assignment.
     *
     * @param name the name of the course planner item
     * 
     *             Initializes the following fields:
     *             - {@link #complete} to false
     *             - {@link #dueDate} to an empty string
     *             - {@link #assignmentPoints} to 0.0
     *             - {@link #assignmentNote} to an empty string
     */
    public CourseAssignmentItem(String name) {

        this.name = name;
        this.complete = false;
        this.dueDate = "";
        this.assignmentPoints = 0.0;
        this.assignmentNote = "";

    }

    /**
     * Returns a string representation of this {@code PlanKueueItem} instance.
     * 
     * @return a string representation of this object
     * 
     *         The returned string includes the following fields:
     */
    @Override
    public String toString() {
        return String.format(
                "CourseAssignmentItem{id = '%d', assignmentPoints = '%d', name = '%s', complete = '%s', dueDate ='%s', assingmentNote = '%s'}",
                id, assignmentPoints, name, complete, dueDate, assignmentNote);
    }
}
