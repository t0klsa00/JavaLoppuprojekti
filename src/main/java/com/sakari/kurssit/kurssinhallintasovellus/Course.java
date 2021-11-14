package com.sakari.kurssit.kurssinhallintasovellus;

import java.util.ArrayList;
import java.util.List;

public class Course{
    private String name = "";
    private long id = 0;
    private String teacher = "";
    private String address = "";
    private static long idCounter = 0;
    private List<Student> students = new ArrayList<>();

    public Course(String name, String teacher, String address, List<Student> students) {
        this.id = idCounter++;
        this.name = name;
        this.address = address;
        this.teacher = teacher;
        this.students = students;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public boolean addStudent(Student student){
        if (this.students.size()<25){
        this.students.add(student);
        return true;}
        else{return false;}
    }
}
