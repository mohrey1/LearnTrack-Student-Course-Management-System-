package service;

import java.util.ArrayList;
import java.util.List;

import entity.Course;
import util.IdGenerator;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    /* ================= ADD COURSE ================= */

    public void addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, courseName, description, durationInWeeks, true);
        courses.add(course);
    }

    /* ================= VIEW COURSES ================= */

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println(
                    "ID: " + c.getId() +
                            ", Name: " + c.getCourseName() +
                            ", Duration: " + c.getDurationInWeeks() + " weeks" +
                            ", Active: " + c.isActive()
            );
        }
    }

    /* ================= SEARCH COURSE ================= */

    public Course findCourseById(int courseId) {
        for (Course c : courses) {
            if (c.getId() == courseId) {
                return c;
            }
        }
        return null;
    }

    /* ================= ACTIVATE / DEACTIVATE COURSE ================= */

    public boolean toggleCourseStatus(int courseId) {
        Course c = findCourseById(courseId);
        if (c != null) {
            c.setActive(!c.isActive());
            return true;
        }
        return false;
    }
}
