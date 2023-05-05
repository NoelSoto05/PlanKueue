package com.PlanKueue.springbootPlanKueue.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import com.PlanKueue.springbootPlanKueue.models.PlannerKueue;
import com.PlanKueue.springbootPlanKueue.models.Task;

public class PlannerKueueTests {

    @Test
    public void testNewPlannerKueue() {
        PlannerKueue pk = new PlannerKueue();
        assertNotNull(pk.getDaily_Planner_Queue());
        assertNotNull(pk.getGeneral_Planner_Queue());
    }

    @Test
    public void testAddTask() {
        PlannerKueue pk = new PlannerKueue();

        Task task = new Task("Assignment 1");
        task.setDueDate("05/05/2023");

        pk.addTask(task, "05/05/2023");
        PriorityQueue<Task> gpq = pk.getGeneral_Planner_Queue();
        PriorityQueue<Task> dpq = pk.getDaily_Planner_Queue();

        assertNotNull(pk.getDaily_Planner_Queue());
        assertNotNull(pk.getGeneral_Planner_Queue());
        assertEquals("Assignment 1", gpq.peek().getName());
        assertEquals("Assignment 1", dpq.peek().getName());
    }
}
