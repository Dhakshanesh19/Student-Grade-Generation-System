package com.wipro.studentgrade.service;

import com.wipro.studentgrade.bean.StudentBean;
import com.wipro.studentgrade.dao.StudentDAO;
import com.wipro.studentgrade.util.InvalidMarkException;
import java.util.Scanner;

public class GradeProcessor {

    public String generateGrade(StudentBean bean) throws InvalidMarkException {
        // Validate marks
        validateMarks(bean);

        // Calculate total
        int total = bean.getMark1() + bean.getMark2() + bean.getMark3() +
                bean.getMark4() + bean.getMark5();
        bean.setTotal(total);

        // Calculate average
        double average = total / 5.0;
        bean.setAverage(average);

        // Assign grade based on average
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 75) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        bean.setGrade(grade);

        // Insert into database
        StudentDAO dao = new StudentDAO();
        String result = dao.insertStudent(bean);

        return "Grade: " + grade + " | " + result;
    }

    private void validateMarks(StudentBean bean) throws InvalidMarkException {
        int[] marks = {bean.getMark1(), bean.getMark2(), bean.getMark3(),
                bean.getMark4(), bean.getMark5()};

        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarkException("Invalid Marks: Mark " + (i + 1) +
                        " (" + marks[i] + ") is not in range 0-100");
            }
        }
    }

    public static void main(String[] args) {
        GradeProcessor processor = new GradeProcessor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Generation System ===\n");

        while (true) {
            try {
                System.out.print("Enter student name (or 'exit' to quit): ");
                String name = scanner.nextLine().trim();

                if (name.equalsIgnoreCase("exit")) {
                    break;
                }

                if (name.isEmpty()) {
                    System.out.println("Error: Student name cannot be empty. Please try again.\n");
                    continue;
                }

                System.out.println("Enter marks for 5 subjects (0-100):");
                System.out.print("Subject 1 Mark: ");
                int mark1 = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Subject 2 Mark: ");
                int mark2 = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Subject 3 Mark: ");
                int mark3 = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Subject 4 Mark: ");
                int mark4 = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Subject 5 Mark: ");
                int mark5 = Integer.parseInt(scanner.nextLine().trim());

                StudentBean student = new StudentBean(name, mark1, mark2, mark3, mark4, mark5);
                String result = processor.generateGrade(student);

                System.out.println("\n" + "=".repeat(50));
                System.out.println("STUDENT GRADE REPORT");
                System.out.println("=".repeat(50));
                System.out.println("Student ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Marks: [" + mark1 + ", " + mark2 + ", " + mark3 + ", " + mark4 + ", " + mark5 + "]");
                System.out.println("Total: " + student.getTotal());
                System.out.println("Average: " + String.format("%.2f", student.getAverage()));
                System.out.println("Grade: " + student.getGrade());
                System.out.println("Status: " + result.split("\\|")[1].trim());
                System.out.println("=".repeat(50) + "\n");

            } catch (InvalidMarkException e) {
                System.out.println("\nError: " + e.toString());
                System.out.println("Please enter marks between 0-100 only.\n");
            } catch (NumberFormatException e) {
                System.out.println("\nError: Please enter valid integer marks (0-100)");
                System.out.println("Make sure you don't enter letters or special characters.\n");
            } catch (Exception e) {
                System.out.println("\nUnexpected Error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }

        scanner.close();
        System.out.println("Thank you for using Student Grade Generation System!");
        System.out.println("Goodbye!");
    }

}