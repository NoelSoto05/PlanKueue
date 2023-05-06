
package com.PlanKueue.springbootPlanKueue.controllers;

import com.PlanKueue.springbootPlanKueue.models.Task;
import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.models.Event;
import com.PlanKueue.springbootPlanKueue.repository.TaskRepository;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;
import com.PlanKueue.springbootPlanKueue.repository.EventRepository;
import com.PlanKueue.springbootPlanKueue.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;

@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private CourseRepository courseRepository;

    @MockBean
    private NoteRepository noteRepository;

    @MockBean
    private BindingResult result;

    @BeforeEach
    public void setUp() {
        // Set up test data here or inside each test method, as needed
    }

    @Test
    public void testCreateTodoItem() throws Exception {
        Event todoItem = new Event();

        when(eventRepository.save(any(Event.class))).thenReturn(todoItem);

        mockMvc.perform(post("/todo")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("description", "Test Event")
                .param("dueDate", "2023-05-06")
                .param("complete", "false")
                .param("taskNote", "")
                .param("reoccuring", "false"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));

        verify(eventRepository).save(any(Event.class));
    }

    @Test
    public void testUpdateTodoItem() throws Exception {
        Event todoItem = new Event();
        todoItem.setId(1L);

        when(eventRepository.findById(1L)).thenReturn(Optional.of(todoItem));
        when(eventRepository.save(any(Event.class))).thenReturn(todoItem);

        mockMvc.perform(post("/todo/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("description", "Updated Event")
                .param("dueDate", "2023-05-07")
                .param("complete", "false")
                .param("taskNote", "")
                .param("reoccuring", "false"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));

        verify(eventRepository).save(any(Event.class));
    }
    @Test
        public void testCreateCourseAssignment() throws Exception {
        mockMvc.perform(post("/courseAssignment")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .param("name", "Test Assignment")
            .param("dueDate", "2023-05-05")
            .param("possiblePoints", "100")
            .param("earnedPoints", "0")
            .param("completed", "false")
            .param("noteID", "1"))
            .andExpect(status().isFound())
            .andExpect(redirectedUrl("/"));

    verify(taskRepository).save(any(Task.class));
}
    @Test
    public void testUpdateCourseItem() throws Exception {
        Task assignmentItem = new Task();
        assignmentItem.setAssignmentId(400L);
    
        when(taskRepository.findById(400L)).thenReturn(Optional.of(assignmentItem));
        when(taskRepository.save(any(Task.class))).thenReturn(assignmentItem);
    
        mockMvc.perform(post("/courseAssignment/400")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "Updated Assignment")
                .param("dueDate", "2023-05-07")
                .param("possiblePoints", "100")
                .param("earnedPoints", "95")
                .param("completed", "true")
                .param("noteID", "2"))
                .andExpect(redirectedUrl("/"))
                .andExpect(redirectedUrl("/"))
                .andExpect(status().isFound());
       
    }
    


    private ResultMatcher redirectedUrlPattern(String string) {
        return null;
    }

    @Test
    public void testCreateCourse() throws Exception {
        Courses course = new Courses();

        when(courseRepository.save(any(Courses.class))).thenReturn(course);

        mockMvc.perform(post("/course")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("courseName", "Test Course")
                .param("courseCode", "CS101"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));

        verify(courseRepository).save(any(Courses.class));
    }

    @Test
    public void testUpdateCourse() throws Exception {
        Courses course = new Courses();
        course.setCourseId(1L);

        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
        when(courseRepository.save(any(Courses.class))).thenReturn(course);

        mockMvc.perform(post("/course/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("courseName", "Updated Course")
                .param("courseCode", "CS102"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));

        verify(courseRepository).save(any(Courses.class));
    }
}
