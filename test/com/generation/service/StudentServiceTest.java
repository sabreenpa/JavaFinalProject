package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    StudentService studentService = new StudentService();

    Student student1;
    Student student2;
    Student student3;

    @BeforeEach
    void setUp() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        student1 = new Student("1234", "Sam", "sam@gmail.com", formatter.parse("11/12/1986"));
        student2 = new Student("5678", "John", "john@gmail.com", formatter.parse("09/12/1996"));
        student3 = new Student("1010", "Tom", "tom@gmail.com", formatter.parse("01/05/1992"));
studentService.subscribeStudent(student1);
        studentService.subscribeStudent(student2);
        studentService.subscribeStudent(student3);

    }

    @Test
    void findStudent() {
        Student actual = studentService.findStudent("1234");
        assertEquals(student1,actual);
    }


    @Test
    void enrollToCourse() {
        CourseService courseService =new CourseService();
        Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
                "Introductory module for the generation technical programs" );
        Course course1 = new Course("WEB-1","html",9,module);
        Course course2 = new Course("WEB-2","css",9,module);
        courseService.registerCourse(course1);
        courseService.registerCourse(course2);
        studentService.enrollToCourse("1234",course1);
        assertEquals(true,student1.isAttendingCourse("WEB-1"));

    }
}