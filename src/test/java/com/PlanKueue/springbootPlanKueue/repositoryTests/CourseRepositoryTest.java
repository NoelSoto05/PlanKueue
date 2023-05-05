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

import com.PlanKueue.springbootPlanKueue.models.Courses;
import com.PlanKueue.springbootPlanKueue.repository.CourseRepository;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    private Courses testCourse;

    @BeforeEach
    void setUp() {
        testCourse = new Courses();
        testCourse.setCourseName("testCourse");
        testCourse.setCurrentCourseGrade(0.0);
        testCourse.setDesiredCourseGrade(0.0);
        testCourse.setCourseDescription("testDescription");
    }

    @Test
    void saveTest() {
        Courses savedCourse = courseRepository.save(testCourse);
        assertNotNull(savedCourse.getCourseId());
    }

    @Test
    void findByIdTest() {
        Courses savedCourse = courseRepository.save(testCourse);
        Optional<Courses> foundCourse = courseRepository.findById(savedCourse.getCourseId());
        assertEquals(savedCourse, foundCourse.get());
    }

    @Test
    void findAllTest() {
        courseRepository.save(testCourse);
        List<Courses> courses = (List<Courses>) courseRepository.findAll();
        assertEquals(1, courses.size());
    }

    @Test
    void deleteByIdTest() {
        Courses savedCourse = courseRepository.save(testCourse);
        courseRepository.deleteById(savedCourse.getCourseId());
        Optional<Courses> foundCourse = courseRepository.findById(savedCourse.getCourseId());
        assertFalse(foundCourse.isPresent());
    }
}
