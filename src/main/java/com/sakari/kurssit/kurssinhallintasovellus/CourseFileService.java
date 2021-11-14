package com.sakari.kurssit.kurssinhallintasovellus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CourseFileService implements ICourseFileService{
    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public CourseFileService() throws FileNotFoundException {
    }

    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException{
        File students_f = new File(filePath);
        if (students_f.exists()){
            Scanner s = new Scanner(students_f);

            while(s.hasNextLine()){
                String[] nm = s.nextLine().split(" ");

                students.add(new Student(nm[0],nm[1]));
            }
            s.close();
        }
        return students;
    } 

    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        File courses_f = new File(filePath);
        if (courses_f.exists()){
            Scanner s = new Scanner(courses_f);

            while(s.hasNextLine()){
                String[] crs = s.nextLine().split("--");
                List<Student> studentsInCourse = new ArrayList<>();

                courses.add(new Course(crs[0], crs[1], crs[2], studentsInCourse));
            }
            s.close();
        }
        return courses;
    }
    
}
