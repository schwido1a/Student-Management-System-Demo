package com.example.demo.forFrontEnd;


//this contains all info that is needed for front end developer
public class StudentFFE {
    private long id;

    private String name;

    private String email;

    //I choose not to give front end "Age" which could potentially be a sensitive factor in real life

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
