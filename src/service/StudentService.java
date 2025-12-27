package service;

import entity.Student;
import exception.EntityNotFoundException;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    /* ================= ADD STUDENT ================= */

    // Overloaded method 1: add existing student object
    public void addStudent(Student student) {
        students.add(student);
    }

    // Overloaded method 2: create & add student
    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch, true);
        students.add(student);
    }

    /* ================= VIEW STUDENTS ================= */

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(
                    "ID: " + s.getId() +
                            ", Name: " + s.getDisplayName() +
                            ", Email: " + s.getEmail() +
                            ", Batch: " + s.getBatch() +
                            ", Active: " + s.isActive()
            );
        }
    }

    /* ================= SEARCH STUDENT ================= */

    public Student findStudentById(int studentId) {
        for (Student s : students) {
            if (s.getId() == studentId) {
                return s;
            }
        }
        throw new EntityNotFoundException("Student with ID " + studentId + " not found.");
    }

    /* ================= UPDATE STUDENT ================= */

    public boolean updateStudentEmail(int studentId, String newEmail) {
        Student s = findStudentById(studentId);
        if (s != null) {
            s.setEmail(newEmail);
            return true;
        }
        return false;
    }

    /* ================= DEACTIVATE STUDENT ================= */

    public boolean deactivateStudent(int studentId) {
        Student s = findStudentById(studentId);
        if (s != null) {
            s.setActive(false);   // soft delete
            return true;
        }
        return false;
    }
}
