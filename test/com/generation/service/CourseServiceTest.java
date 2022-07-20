package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
CourseService courseService;
    Course course1;
    Module module;

    @BeforeEach
    void setUp() {
        courseService =new CourseService();
         module = new Module( "INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs" );
        course1 = new Course("WEB-1","html",9,module);
    }

    @Test
    void registerCourse() {
        courseService.registerCourse(course1);
        assertEquals(course1,courseService.getCourse("WEB-1"));
    }

    @Test
    void getCourse() {
        assertEquals(null,courseService.getCourse("121"));
    }
}