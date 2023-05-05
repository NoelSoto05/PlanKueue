package com.PlanKueue.springbootPlanKueue.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.PlanKueue.springbootPlanKueue.models.Grade;

public class GradeTests {

    @Test
    public void testNewGrade() {
        Grade grade = new Grade();
        assertNotNull(grade);
    }

    @Test
    public void testGetSetCourseName() {
        Grade grade = new Grade();
        grade.setCourseName("IT 326");
        assertEquals("IT 326", grade.getCourseName());
    }

    @Test
    public void testGetSetCredits() {
        Grade grade = new Grade();
        grade.setCredits(5);
        assertEquals(5, grade.getCredits());
    }

    @Test
    public void testGetSetGrade() {
        Grade grade = new Grade();
        grade.setGrade(87.5);
        assertEquals(87.5, grade.getGrade());
    }
}
