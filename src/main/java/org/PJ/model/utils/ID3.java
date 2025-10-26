package org.PJ.model.utils;

import org.PJ.Student;

import java.util.List;

public class ID3 {
    public static List<Double> findCandidatePartitions(List<Student> data) {
        List<Double> partitions = new java.util.ArrayList<>();
        Double pastValue = null;
        for(Student student : data) {
            if(pastValue == null)
                pastValue = (double) student.getHoursStudied();
            else {
                Double currentValue = (double) student.getHoursStudied();
                if(currentValue !=(pastValue)) {
                    Double partition = (pastValue + currentValue) / 2;
                    partitions.add(partition);
                    pastValue = currentValue;
                }
            }
        }
        return partitions;
    }
    public static double calculateEntropy(List<Student> data) {
        int sum = data.size();
        if(sum == 0) return 0.0;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        for(Student student : data) {
            switch (student.getGrade()) {
                case "A" -> countA++;
                case "B" -> countB++;
                case "C" -> countC++;
            }
        }
        double pA = (double) countA / sum;
        double pB = (double) countB / sum;
        double pC = (double) countC / sum;
        double entropy = 0.0;
        if(pA > 0) entropy -= pA * log2(pA);
        if(pB > 0) entropy -= pB * log2(pB);
        if(pC > 0) entropy -= pC * log2(pC);
        return entropy;
    }
    private static double log2(double n) {
        return Math.log(n) / Math.log(2);
    }
    public static double findBestPartition(List<Student> data, List<Double> partitions) {
        double baseEntropy = calculateEntropy(data);
        double bestInfoGain = -1.0;
        double bestPartition = -1.0;
        for(Double partition : partitions) {
            List<Student> leftSubset = new java.util.ArrayList<>();
            List<Student> rightSubset = new java.util.ArrayList<>();
            for(Student student : data) {
                if(student.getHoursStudied() <= partition) {
                    leftSubset.add(student);
                } else {
                    rightSubset.add(student);
                }
            }
            double leftEntropy = calculateEntropy(leftSubset);
            double rightEntropy = calculateEntropy(rightSubset);
            double weightedEntropy = ((double) leftSubset.size() / data.size()) * leftEntropy +
                    ((double) rightSubset.size() / data.size()) * rightEntropy;
            double infoGain = baseEntropy - weightedEntropy;
            if(infoGain > bestInfoGain) {
                bestInfoGain = infoGain;
                bestPartition = partition;
            }
        }
        return bestPartition;
    }
}
