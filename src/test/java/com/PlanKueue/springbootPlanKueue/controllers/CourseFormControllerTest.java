package com.PlanKueue.springbootPlanKueue.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;

class CourseFormControllerTest {

    private CourseFormController courseFormController;

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        courseFormController = new CourseFormController();
        courseFormController.setCourseRepository(courseRepository);
    }

    @Test
    void testShowCreateCourseForm() {
        String expectedViewName = "add-course";
        String returnedViewName = courseFormController.showCreateCourseForm(model);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testShowUpdateCourseForm() {
        long courseId = 1L;
        Courses course = new Courses();
        course.setCourseId(courseId);
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

        String expectedViewName = "update-course";
        String returnedViewName = courseFormController.showUpdateCourseForm(courseId, model);
        assertEquals(expectedViewName, returnedViewName);
    }

    @Test
    void testDeleteTodoCourseItem() {
        long courseId = 1L;
        Courses course = new Courses();
        course.setCourseId(courseId);
        when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));

        String expectedRedirect = "redirect:/";
        String returnedRedirect = courseFormController.deleteTodoCourseItem(courseId, model);
        assertEquals(expectedRedirect, returnedRedirect);
    }

}
