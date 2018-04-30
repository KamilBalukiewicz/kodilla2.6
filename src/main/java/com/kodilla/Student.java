package com.kodilla;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DecimalFormat;

public class Student {
    private String firstName;
    private String lastName;
    private String idNumber;

    public Student(String firstName, String lastName, String idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public boolean equals(Student s) {
        return (this.firstName == s.firstName) && (this.lastName == s.lastName) && (this.idNumber == s.idNumber);
    }

    public int hashCode() {
        return Integer.parseInt(idNumber.substring(2, 5));
    }

    public String toString() {
        return firstName + " " + lastName + " " + "<" + idNumber + ">";
    }
}

class Grades {
    private Double biology;
    private Double chemistry;
    private Double math;
    private Double physics;
    private Double it;
    private Double geography;
    private Double history;

    public Grades(Double biology, Double chemistry, Double math, Double physics, Double it, Double geography, Double history) {
        this.biology = biology;
        this.chemistry = chemistry;
        this.math = math;
        this.physics = physics;
        this.it = it;
        this.geography = geography;
        this.history = history;
    }

    public double getAverage() {
        return (biology + chemistry + math + physics + it + geography + history) / 7;

    }
}

class ShowAverageGrade {
    //zaokrąglenie średniej do dwóch miejsc po przecinku
    private static DecimalFormat df2 = new DecimalFormat(".##");
    public static void main (String[] args) throws java.lang.Exception
    {
        Student student1 = new Student("John", "Smith", "02011512345");
        Student student2 = new Student("Jan", "Kowalski", "02011623456");
        Student student3 = new Student("Juan", "Ferrera", "02021134567");
        Student student4 = new Student("Jane", "Doe", "02041845678");

        Grades grades1 = new Grades(5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0);
        Grades grades2 = new Grades(2.0, 3.0, 4.0, 5.0, 3.0, 4.0, 3.0);
        Grades grades3 = new Grades(3.0, 2.0, 4.0, 5.0, 6.0, 3.0, 4.0);
        Grades grades4 = new Grades(4.0, 4.0, 5.0, 6.0, 6.0, 4.0, 3.0);

        HashMap<Student, Grades> studentsGrades = new HashMap<Student, Grades>();

        studentsGrades.put(student1, grades1);
        studentsGrades.put(student2, grades2);
        studentsGrades.put(student3, grades3);
        studentsGrades.put(student4, grades4);

        for(Map.Entry<Student, Grades> entry : studentsGrades.entrySet()) {
            System.out.println("Average grade of " + entry.getKey() + " equals " + df2.format(entry.getValue().getAverage()));
        }
    }
}