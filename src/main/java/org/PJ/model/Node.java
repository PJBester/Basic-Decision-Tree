package org.PJ.model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    double threshold;
    Node left;
    Node right;
    double value;
    boolean isLeaf;
    public Node(){
        this.isLeaf = false;
        this.left = null;
        this.right = null;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}
