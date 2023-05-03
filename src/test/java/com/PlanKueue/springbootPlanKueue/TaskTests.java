package com.PlanKueue.springbootPlanKueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.PlanKueue.springbootPlanKueue.models.Task;

public class TaskTests {

    @Test
    public void testCreateTask() {
        Task task = new Task("Assignment 1");

        Assertions.assertEquals("Assignment 1", task.getName());
        Assertions.assertEquals(0.0, task.getGrade());
        Assertions.assertEquals(0.0, task.getPossiblePoints());
        Assertions.assertEquals(0.0, task.getEarnedPoints());
        Assertions.assertEquals("", task.getDueDate());
        Assertions.assertFalse(task.isCompleted());
    }

    @Test
    public void testSetName() {
        Task task = new Task();
        task.setName("Assignment 1");

        Assertions.assertEquals("Assignment 1", task.getName());
    }
}
