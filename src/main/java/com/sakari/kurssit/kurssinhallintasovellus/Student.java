package com.sakari.kurssit.kurssinhallintasovellus;

public class Student {
    private String l_name;
    private String f_name;
    private long id;

    private static long idCounter = 0;

    public Student(String f_name, String l_name) {
        this.l_name = l_name;
        this.f_name = f_name;
        this.id = idCounter++;
    }

    public String getLName() {
        return this.l_name;
    }

    public void setLName(String l_name) {
        this.l_name = l_name;
    }

    public String getFName() {
        return this.f_name;
    }

    public void setFName(String f_name) {
        this.l_name = f_name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}