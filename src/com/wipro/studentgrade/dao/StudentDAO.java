

// ==================== StudentDAO.java ====================
// File: src/com/wipro/studentgrade/dao/StudentDAO.java

package com.wipro.studentgrade.dao;

import com.wipro.studentgrade.bean.StudentBean;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
    private static int sequenceCounter = 1;
    private static Map<String, StudentBean> database = new HashMap<>();

    public String generateId(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "STU" + String.format("%03d", sequenceCounter++);
        }

        String[] nameParts = name.trim().split("\\s+");
        StringBuilder initials = new StringBuilder();

        for (String part : nameParts) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }

        String studentId = initials.toString().toUpperCase() + String.format("%03d", sequenceCounter++);
        return studentId;
    }

    public String insertStudent(StudentBean bean) {
        try {
            if (bean == null) {
                return "Error: Student bean is null";
            }

            // Generate ID if not already set
            if (bean.getStudentId() == null || bean.getStudentId().trim().isEmpty()) {
                String id = generateId(bean.getName());
                bean.setStudentId(id);
            }

            // Store in database
            database.put(bean.getStudentId(), bean);

            return "Student record inserted successfully with ID: " + bean.getStudentId();
        } catch (Exception e) {
            return "Error inserting student record: " + e.getMessage();
        }
    }

    // Additional method to retrieve student (for testing purposes)
    public StudentBean getStudent(String studentId) {
        return database.get(studentId);
    }

    // Method to get all students (for testing purposes)
    public Map<String, StudentBean> getAllStudents() {
        return new HashMap<>(database);
    }

    // Method to get database size (for testing purposes)
    public int getDatabaseSize() {
        return database.size();
    }
}