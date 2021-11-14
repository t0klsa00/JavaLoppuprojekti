package com.sakari.kurssit.kurssinhallintasovellus;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService{
    
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public CourseService() throws FileNotFoundException {
        CourseFileService courseFileService = new CourseFileService();
        this.students = courseFileService.readStudentsFromFile("src\\docs\\students.txt");
        this.courses = courseFileService.readCoursesFromFile("src\\docs\\courses.txt");
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    public Student getStudentById(long studentId) {
        return students.get((int) studentId);
    }

    public Course getCourseById(long courseId) {
        return courses.get((int) courseId);
    }

    public List<Course> getCoursesOfStudent(long studentId)
    {
        List<Course> courseToAdd = new ArrayList<>();

        for (Course course : this.courses) {
            for (Student student : course.getStudents()) {
                if (student.getId() == studentId) {
                    courseToAdd.add(course);
                }
            }
        }
        return courseToAdd;
    }

    public boolean addStudentToCourse(long studentId, long courseId) {
        List<Course> courseToAdd = new ArrayList<>();

            for (Course course: this.courses) {
                if (course.getId() == courseId) {
                courseToAdd.add(course);
                }
            }
            if (courseToAdd.isEmpty()) {
                return false;
            }
            List<Student> studentToAdd = new ArrayList<>();

            for (Student student : this.students) {
                if (student.getId() == studentId) {
                studentToAdd.add(student);
                }
            }
            if (studentToAdd.isEmpty()) {
                return false;
            }

            return courseToAdd.get(0).addStudent(studentToAdd.get(0));
        
    }
    

    

}
