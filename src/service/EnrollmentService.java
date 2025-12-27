package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entity.Enrollment;
import enums.EnrollmentStatus;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();
    private static int enrollmentIdCounter = 3000;

    /* ================= ENROLL STUDENT ================= */

    public void enrollStudent(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(
                ++enrollmentIdCounter,
                studentId,
                courseId,
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        );
        enrollments.add(enrollment);
    }

    /* ================= VIEW ENROLLMENTS BY STUDENT ================= */

    public void viewEnrollmentsByStudent(int studentId) {
        boolean found = false;

        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                System.out.println(
                        "Enrollment ID: " + e.getId() +
                                ", Course ID: " + e.getCourseId() +
                                ", Date: " + e.getEnrollmentDate() +
                                ", Status: " + e.getStatus()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for this student.");
        }
    }

    /* ================= UPDATE ENROLLMENT STATUS ================= */

    public boolean updateEnrollmentStatus(int enrollmentId, String status) {
        for (Enrollment e : enrollments) {
            if (e.getId() == enrollmentId) {
                e.setStatus(EnrollmentStatus.valueOf(status));
                return true;
            }
        }
        return false;
    }
}

