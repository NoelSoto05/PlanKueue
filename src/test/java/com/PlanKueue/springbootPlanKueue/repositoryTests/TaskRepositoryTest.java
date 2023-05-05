package com.PlanKueue.springbootPlanKueue.repositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    private Task testTask;

    @BeforeEach
    void setUp() {
        testTask = new Task();
        testTask.setName("testName");
        testTask.setDueDate("2023-06-01");
        testTask.setPossiblePoints(100.0);
        testTask.setEarnedPoints(85.0);
        testTask.setCompleted(false);
    }

    @Test
    void saveTest() {
        Task savedTask = taskRepository.save(testTask);
        assertNotNull(savedTask.getAssignmentId());
    }

    @Test
    void findByIdTest() {
        Task savedTask = taskRepository.save(testTask);
        Optional<Task> foundTask = taskRepository.findById(savedTask.getAssignmentId());
        assertEquals(savedTask, foundTask.get());
    }

    @Test
    void findAllTest() {
        taskRepository.save(testTask);
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        assertEquals(1, tasks.size());
    }

    @Test
    void deleteByIdTest() {
        Task savedTask = taskRepository.save(testTask);
        taskRepository.deleteById(savedTask.getAssignmentId());
        Optional<Task> foundTask = taskRepository.findById(savedTask.getAssignmentId());
        assertEquals(false, foundTask.isPresent());
    }

}
