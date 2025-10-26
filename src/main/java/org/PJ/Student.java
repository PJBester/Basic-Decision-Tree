package org.PJ;

public class Student{
    int hoursStudied;
    String grade;
    String name;
    public Student(int hoursStudied, String grade, String name){
        this.name = name;
        this.hoursStudied = hoursStudied;
        this.grade = grade;
    }

    public int getHoursStudied() {
        return hoursStudied;
    }

    public String getGrade() {
        return grade;
    }
    public String getName() {
        return name;
    }
}
