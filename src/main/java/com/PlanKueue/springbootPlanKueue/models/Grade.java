package com.PlanKueue.springbootPlanKueue.models;

public class Grade {
    private String courseName;
    private int credits;
    private double grade;

    public Grade(String courseName, int credits, double grade) {
        this.courseName = courseName;
        this.credits = credits;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
