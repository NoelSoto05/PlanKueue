package com.PlanKueue.springbootPlanKueue.modelTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.PlanKueue.springbootPlanKueue.models.Task;

@DataJpaTest
class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    void testParameterizedConstructor() {
        task = new Task("Math Homework");
        assertNotNull(task);
        assertEquals("Math Homework", task.getName());
        assertEquals(0.0, task.getGrade());
        assertEquals("", task.getDueDate());
        assertEquals(0.0, task.getPossiblePoints());
        assertEquals(0.0, task.getEarnedPoints());
        assertFalse(task.isCompleted());
    }

    @Test
    void testSettersAndGetters() {
        task.setAssignmentId(1L);
        task.setName("English Essay");
        task.setGrade(90.0);
        task.setDueDate("2022-12-31");
        task.setPossiblePoints(100.0);
        task.setEarnedPoints(90.0);
        task.setCompleted(true);

        assertEquals(1L, task.getAssignmentId());
        assertEquals("English Essay", task.getName());
        assertEquals(90.0, task.getGrade());
        assertEquals("2022-12-31", task.getDueDate());
        assertEquals(100.0, task.getPossiblePoints());
        assertEquals(90.0, task.getEarnedPoints());
        assertTrue(task.isCompleted());
    }

    @Test
    void testSetAssignmentIdWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> task.setAssignmentId(-1L));
    }

    @Test
    void testSetNameWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    void testSetNameWithEmptyStringValue() {
        assertThrows(IllegalArgumentException.class, () -> task.setName(""));
    }

    @Test
    void testSetDueDateWithNullValue() {
        task.setDueDate(null);
        assertEquals("", task.getDueDate());
    }

    @Test
    void testSetPossiblePointsWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> task.setPossiblePoints(-1.0));
    }

    void testSetEarnedPointsWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> task.setEarnedPoints(-1.0));
    }

    @Test
    void testEarnedPointsGreaterThanPossiblePoints() {
        task.setPossiblePoints(100.0);
        assertThrows(IllegalArgumentException.class, () -> task.setEarnedPoints(101.0));
    }

    @Test
    void testCalculateGrade() {
        task.setPossiblePoints(100.0);
        task.setEarnedPoints(90.0);
        double expectedGrade = 90.0 / 100.0 * 100.0;
        assertEquals(expectedGrade, task.getGrade());
    }
}
