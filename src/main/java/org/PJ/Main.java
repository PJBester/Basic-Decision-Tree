package org.PJ;

import org.PJ.model.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        students.add(new Student(12, "A", "Alice"));
        students.add(new Student(6, "B", "Bob"));
        students.add(new Student(9, "A", "Charlie"));
        students.add(new Student(3, "C", "David"));
        students.add(new Student(7, "B", "Eve"));
        Tree decisionTree = new Tree(3);
        decisionTree.root = decisionTree.buildTree(students, 0);
        System.out.println("Enter hours studied:");
        Scanner scanner = new Scanner(System.in);
        int hoursStudied = scanner.nextInt();
        Student newStudent = new Student(hoursStudied, "", "Frank");
        String predictedGrade = decisionTree.predictSample(decisionTree.getRoot(), newStudent);
        System.out.println("Predicted Grade: " + predictedGrade);
    }
}