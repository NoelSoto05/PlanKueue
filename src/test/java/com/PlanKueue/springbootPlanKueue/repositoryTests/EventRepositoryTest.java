package com.PlanKueue.springbootPlanKueue.repositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.PlanKueue.springbootPlanKueue.models.Event;
import com.PlanKueue.springbootPlanKueue.repository.EventRepository;

@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private EventRepository eventRepository;

    private Event testEvent;

    @BeforeEach
    void setUp() {
        testEvent = new Event();
        testEvent.setDescription("testEvent");
        testEvent.setComplete(false);
        testEvent.setDueDate("");
        testEvent.setTaskNote("");
        testEvent.setReoccuring(false);
    }

    @Test
    void saveTest() {
        Event savedEvent = eventRepository.save(testEvent);
        assertNotNull(savedEvent.getId());
    }

    @Test
    void findByIdTest() {
        Event savedEvent = eventRepository.save(testEvent);
        Optional<Event> foundEvent = eventRepository.findById(savedEvent.getId());
        assertEquals(savedEvent, foundEvent.get());
    }

    @Test
    void findAllTest() {
        eventRepository.save(testEvent);
        List<Event> events = (List<Event>) eventRepository.findAll();
        assertEquals(1, events.size());
    }

    @Test
    void deleteByIdTest() {
        Event savedEvent = eventRepository.save(testEvent);
        eventRepository.deleteById(savedEvent.getId());
        Optional<Event> foundEvent = eventRepository.findById(savedEvent.getId());
        assertFalse(foundEvent.isPresent());
    }
}
