package com.sakari.kurssit.kurssinhallintasovellus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    @Autowired
    CourseService courseService;

    @GetMapping("students")
    public List<Student> getStudents(){
        return courseService.getStudents();
    }

    @GetMapping("courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("students/{id}")
        public String getStudentById(@PathVariable long id){
            Student studentInfo = courseService.getStudentById(id);
            List<String> courseInfo = new ArrayList<>();

            for (Course course : courseService.getCoursesOfStudent(id)) {
            courseInfo.add("<br>"+course.getName());
            }
            return "<h2>"+studentInfo.getLName()+" "+studentInfo.getFName()+"</h2>"+courseInfo.toString().replace("[", "").replace("]", "");
              
    }

    @GetMapping("courses/{id}")
        public String getCourseById(@PathVariable long id){
            Course courseInfo = courseService.getCourseById(id);
            List<String> studentInfo = new ArrayList<>();

            for (Student student : courseInfo.getStudents()) {
                studentInfo.add("<br>"+student.getFName()+" "+student.getLName());
            }

            return "<h2>"+courseInfo.getName().toString()+"</h2>"+studentInfo.toString().replace("[", "").replace("]", "");
              
    }

    @PostMapping("add")
    public boolean addStudentToCourse(@RequestBody Map<String, Long> jsonMapping) {
        return courseService.addStudentToCourse(jsonMapping.get("sid"), jsonMapping.get("cid"));
    }
    
}
