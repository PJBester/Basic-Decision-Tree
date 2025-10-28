package org.PJ.model;

import org.PJ.Student;
import org.PJ.model.utils.ID3;

import java.util.List;

public class Tree {
    public Node root;
    public int maxDepth = 5;
    public Tree(int MAX_DEPTH) {
        this.maxDepth = MAX_DEPTH;
        this.root = null;
    }
    public Node getRoot() {
        return root;
    }
    public Node buildTree(List<Student> students, int depth) {
        Node node = new Node();
        if(depth >= maxDepth) {
            node.isLeaf = true;
            node.value = majorityClass(students);
            return node;
        }
        List<Double> candidatePartitions = ID3.findCandidatePartitions(students);
        Double bestPartition = ID3.findBestPartition(students, candidatePartitions);
        if(bestPartition == -1.0 || candidatePartitions.isEmpty()) {
            node.isLeaf = true;
            node.value = majorityClass(students);
            return node;}
<<<<<<< HEAD
=======
        int featureIndex = 0;
        node.setFeatureIndex(featureIndex);
>>>>>>> 487ffc59d2c3f3b3c14754e8cc5ee6a58e15f56f
        node.setThreshold(bestPartition);
        node.threshold = bestPartition;
        List<Student> leftSubset = new java.util.ArrayList<>();
        List<Student> rightSubset = new java.util.ArrayList<>();
        for(Student student : students) {
            if (student.getHoursStudied() <= bestPartition) {
                leftSubset.add(student);
            } else {
                rightSubset.add(student);
            }
        }
        node.left = buildTree(leftSubset, depth + 1);
        node.right = buildTree(rightSubset, depth + 1);
        return node;

    }
    public String predictSample(Node node, Student student) {
        if(node.isLeaf) {
            return String.valueOf((char) node.value);
        }
        if(student.getHoursStudied() <= node.threshold) {
            return predictSample(node.left, student);
        } else {
            return predictSample(node.right, student);
        }
    }
    private double majorityClass(List<Student> students) {
        String[] labels = students.stream().map(Student::getGrade).toArray(String[]::new);
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for(String label : labels) {
            switch (label) {
                case "A" -> countA++;
                case "B" -> countB++;
                case "C" -> countC++;
            }
        }
        if(countA >= countB && countA >= countC) return 'A';
        else if(countB >= countA && countB >= countC) return 'B';
        else return 'C';
    }
}
