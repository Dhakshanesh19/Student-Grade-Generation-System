// ==================== StudentBean.java ====================
// File: src/com/wipro/studentgrade/bean/StudentBean.java

package com.wipro.studentgrade.bean;

public class StudentBean {
    private String studentId;
    private String name;
    private int mark1;
    private int mark2;
    private int mark3;
    private int mark4;
    private int mark5;
    private int total;
    private double average;
    private String grade;

    // Default constructor
    public StudentBean() {}

    // Constructor with parameters
    public StudentBean(String name, int mark1, int mark2, int mark3, int mark4, int mark5) {
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public int getMark3() {
        return mark3;
    }

    public void setMark3(int mark3) {
        this.mark3 = mark3;
    }

    public int getMark4() {
        return mark4;
    }

    public void setMark4(int mark4) {
        this.mark4 = mark4;
    }

    public int getMark5() {
        return mark5;
    }

    public void setMark5(int mark5) {
        this.mark5 = mark5;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", marks=[" + mark1 + "," + mark2 + "," + mark3 + "," + mark4 + "," + mark5 + "]" +
                ", total=" + total +
                ", average=" + average +
                ", grade='" + grade + '\'' +
                '}';
    }
}
