package com.PlanKueue.springbootPlanKueue.models;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Course")
@Validated
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Getter
    @Setter
    private Long courseId;

    @Getter
    @Setter
    @NotBlank(message = "Course name cannot be empty")
    private String courseName;

    @Getter
    @Setter
    private double currentCourseGrade;

    @Getter
    @Setter
    private double desiredCourseGrade;

    @Getter
    @Setter
    private String courseDescription;

    public Courses() {

    }

    public Courses(String courseName) {
        this.courseName = courseName;

        this.currentCourseGrade = 0.0;
        this.desiredCourseGrade = 0.0;
    }

    @Override
    public String toString() {
        return String.format(
                "Courses{id='%d', courseName = '%s', currentCourseGrade = '%d', desiredCourseGrade = '%d'}",
                courseId, courseName, currentCourseGrade, desiredCourseGrade);

    }

}