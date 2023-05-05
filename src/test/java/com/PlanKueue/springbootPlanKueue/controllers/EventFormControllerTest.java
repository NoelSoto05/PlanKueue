package com.PlanKueue.springbootPlanKueue.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.PlanKueue.springbootPlanKueue.models.Event;
import com.PlanKueue.springbootPlanKueue.repository.EventRepository;

class EventFormControllerTest {

    private EventFormController eventFormController;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        eventFormController = new EventFormController();
        eventFormController.setEventRepository(eventRepository);
    }

    @Test
    void testShowCreateForm() {
        String expectedViewName = "add-todo-item";
        String returnedViewName = eventFormController.showCreateForm(new Event());
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testShowUpdateForm() {
        long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        String expectedViewName = "update-planner-item";
        String returnedViewName = eventFormController.showUpdateForm(eventId, model);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testDeleteTodoItem() {
        long eventId = 1L;
        Event event = new Event();
        event.setId(eventId);
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        String expectedRedirect = "redirect:/";
        String returnedRedirect = eventFormController.deleteTodoItem(eventId, model);
        assertEquals(expectedRedirect, returnedRedirect);
    }

}
