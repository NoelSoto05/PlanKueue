package com.PlanKueue.springbootPlanKueue.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.PlanKueue.springbootPlanKueue.models.Event;

public class EventTests {

    @Test
    public void testEventDescription() {
        Event event = new Event("Test Event");
        assertNotNull(event);
        assertEquals("Test Event", event.getDescription());
    }

    @Test
    public void testEventComplete() {
        Event event = new Event("Test Event");
        assertNotNull(event);
        assertEquals(false, event.isComplete());
    }

    @Test
    public void testEventDueDate() {
        Event event = new Event("Test Event");
        assertNotNull(event);
        assertEquals("", event.getDueDate());
    }

    @Test
    public void testEventTaskNote() {
        Event event = new Event("Test Event");
        assertNotNull(event);
        assertEquals("", event.getTaskNote());
    }

    @Test
    public void testEventReoccuring() {
        Event event = new Event("Test Event");
        assertNotNull(event);
        assertEquals(false, event.getReoccuring());
    }

    @Test
    public void testEventUpdateDueDate() {
        Event event = new Event("Test Event");
        event.setDueDate("01/01/2022");
        event.setComplete(true);
        event.setReoccuring(true);
        assertNotNull(event);
        assertEquals("02/01/2022", event.updateDueDate());
        assertEquals(false, event.isComplete());
    }
}
