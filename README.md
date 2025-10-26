# 🌳 Simple Decision Tree Implementation (Java)

A lightweight implementation of a **Decision Tree** built entirely from scratch in Java.  
This project demonstrates the core principles behind tree-based machine learning algorithms such as **ID3** and **CART**, using a simple dataset (e.g. *hours studied → grade achieved*).

---

## 🧠 Overview

This project provides an educational look into how a decision tree learns to split data based on information gain and how it can make predictions for new samples.

Key components:
- **Node Class** – Represents each node in the tree (feature, threshold, children, or leaf value).
- **DecisionTree Class** – Handles the training (`fit`) and prediction (`predict`) logic.
- **Main Class** – Provides a simple demonstration using example data.

---

## ⚙️ Features

- Builds a decision tree **without external ML libraries**  
- Uses **information gain** to find the best splits  
- Supports both **classification and regression** (depending on your dataset)  
- Easily extendable into more advanced models like **Random Forests**
