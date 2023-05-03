package com.PlanKueue.springbootPlanKueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.PlanKueue.springbootPlanKueue.models.Event;

public class EventTests {

    @Test
    public void testConstructor() {
        String description = "Test event description";
        Event event = new Event(description);

        Assertions.assertEquals(description, event.getDescription());
        Assertions.assertFalse(event.isComplete());
        Assertions.assertNotNull(event.getCreatedDate());
        Assertions.assertNotNull(event.getModifiedDate());
        Assertions.assertEquals("", event.getDueDate());
        Assertions.assertEquals("", event.getTaskNote());
    }

    @Test
    public void testToString() {
        String description = "Test event description";
        Event event = new Event(description);
        String expected = String.format(
                "PlanKueueItem{id='%d', description = '%s', complete = '%s', createdDate = '%s', modifiedDate ='%s', dueDate = %s}",
                event.getId(), description, event.isComplete(), event.getCreatedDate(), event.getModifiedDate(), event.getDueDate());

        Assertions.assertEquals(expected, event.toString());
    }

    @Test
    public void testGettersAndSetters() {
        Event event = new Event();
        Long id = 1L;
        String description = "Test event description";
        boolean complete = true;
        String dueDate = "2023-06-01";
        String taskNote = "Test task note";
        event.setId(id);
        event.setDescription(description);
        event.setComplete(complete);
        event.setDueDate(dueDate);
        event.setTaskNote(taskNote);

        Assertions.assertEquals(id, event.getId());
        Assertions.assertEquals(description, event.getDescription());
        Assertions.assertEquals(complete, event.isComplete());
        Assertions.assertEquals(dueDate, event.getDueDate());
        Assertions.assertEquals(taskNote, event.getTaskNote());
    }
}
