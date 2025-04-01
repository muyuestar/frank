package com.frank.googleguava;

/**
 * @author: kst
 * @date: 2024/12/3 18:04
 */
public class Student {

    private String name;
    private String age;
    private String school;

    public Student(String name, String age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
