package com.PlanKueue.springbootPlanKueue.controllers;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class AssignmentFormControllerTest {

    private AssignmentFormController controller;

    @Mock
    private TaskRepository repository;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new AssignmentFormController();
        controller.setCourseAssignmentRepository(repository);
    }

    @Test
    void testShowCreateForm() {
        String result = controller.showCreateForm(new Task());
        assertEquals("add-assignment", result);
    }

    @Test
    void testShowUpdateForm() {
        // given
        long assignmentId = 1L;
        Task courseAssignment = new Task();
        courseAssignment.setAssignmentId(assignmentId);

        when(repository.findById(anyLong())).thenReturn(Optional.of(courseAssignment));

        // when
        String result = controller.showUpdateForm(assignmentId, model);

        // then
        verify(repository, times(1)).findById(anyLong());
        verify(model, times(1)).addAttribute(eq("courseAssignment"), eq(courseAssignment));
        assertEquals("update-assignment", result);
    }

    @Test
    void testDeleteTodoItem() {
        // given
        long assignmentId = 1L;
        Task courseAssignment = new Task();
        courseAssignment.setAssignmentId(assignmentId);

        when(repository.findById(anyLong())).thenReturn(Optional.of(courseAssignment));

        // when
        String result = controller.deleteTodoItem(assignmentId, model);

        // then
        verify(repository, times(1)).findById(anyLong());
        verify(repository, times(1)).delete(eq(courseAssignment));
        assertEquals("redirect:/", result);
    }
}
