package com.PlanKueue.springbootPlanKueue.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;

@DataJpaTest
public class CoursesTest {

    @Autowired
    private CourseRepository coursesRepository;

    @Test
    public void testCreateCourses() {
        Courses course = new Courses("Math");
        Courses savedCourse = coursesRepository.save(course);

        assertNotNull(savedCourse.getCourseId());
        assertEquals("Math", savedCourse.getCourseName());
        assertEquals(0.0, savedCourse.getCurrentCourseGrade());
        assertEquals(0.0, savedCourse.getDesiredCourseGrade());
    }

    @Test
    public void testUpdateCourses() {
        Courses course = new Courses("Math");
        Courses savedCourse = coursesRepository.save(course);

        savedCourse.setCurrentCourseGrade(80.0);
        savedCourse.setDesiredCourseGrade(90.0);
        savedCourse.setCourseDescription("Intro to Math");
        coursesRepository.save(savedCourse);

        Courses updatedCourse = coursesRepository.findById(savedCourse.getCourseId()).orElse(null);
        assertNotNull(updatedCourse);
        assertEquals(80.0, updatedCourse.getCurrentCourseGrade());
        assertEquals(90.0, updatedCourse.getDesiredCourseGrade());
        assertEquals("Intro to Math", updatedCourse.getCourseDescription());
    }

    @Test
    public void testDeleteCourses() {
        Courses course = new Courses("Math");
        Courses savedCourse = coursesRepository.save(course);

        coursesRepository.delete(savedCourse);

        Courses deletedCourse = coursesRepository.findById(savedCourse.getCourseId()).orElse(null);
        assertNull(deletedCourse);
    }

    @Test
    public void testFindCoursesById() {
        Courses course = new Courses("Math");
        Courses savedCourse = coursesRepository.save(course);

        Courses foundCourse = coursesRepository.findById(savedCourse.getCourseId()).orElse(null);
        assertNotNull(foundCourse);
        assertEquals("Math", foundCourse.getCourseName());
    }

    @Test
    public void testFindAllCourses() {
        Courses course1 = new Courses("Math");
        Courses course2 = new Courses("English");
        Courses course3 = new Courses("Science");
        coursesRepository.save(course1);
        coursesRepository.save(course2);
        coursesRepository.save(course3);

        List<Courses> courses = new ArrayList<>();
        coursesRepository.findAll().forEach(courses::add);
        assertNotNull(courses);
        assertEquals(3, courses.size());
    }

    @Test
    public void testCoursesWithDifferentGrades() {
        Courses course1 = new Courses("Math");
        course1.setCurrentCourseGrade(80.0);
        course1.setDesiredCourseGrade(90.0);
        Courses savedCourse1 = coursesRepository.save(course1);

        Courses course2 = new Courses("English");
        course2.setCurrentCourseGrade(70.0);
        course2.setDesiredCourseGrade(85.0);
        Courses savedCourse2 = coursesRepository.save(course2);

        Courses course3 = new Courses("Science");
        course3.setCurrentCourseGrade(60.0);
        course3.setDesiredCourseGrade(80.0);
        Courses savedCourse3 = coursesRepository.save(course3);

        Courses foundCourse1 = coursesRepository.findById(savedCourse1.getCourseId()).orElse(null);
        assertNotNull(foundCourse1);
        assertEquals(80.0, foundCourse1.getCurrentCourseGrade());
        assertEquals(90.0, foundCourse1.getDesiredCourseGrade());

        Courses foundCourse2 = coursesRepository.findById(savedCourse2.getCourseId()).orElse(null);
        assertNotNull(foundCourse2);
        assertEquals(70.0, foundCourse2.getCurrentCourseGrade());
        assertEquals(85.0, foundCourse2.getDesiredCourseGrade());

        Courses foundCourse3 = coursesRepository.findById(savedCourse3.getCourseId()).orElse(null);
        assertNotNull(foundCourse3);
        assertEquals(60.0, foundCourse3.getCurrentCourseGrade());
        assertEquals(80.0, foundCourse3.getDesiredCourseGrade());
    }

}
