import entity.Person;
import entity.Student;
import exception.EntityNotFoundException;
import service.CourseService;
import service.EnrollmentService;
import service.StudentService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n==== LEARN TRACK =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> studentMenu(sc);
                case 2 -> courseMenu(sc);
                case 3 -> enrollmentMenu(sc);
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
        System.out.println("Application closed.");


    }

    private static void enrollmentMenu(Scanner sc) {

        System.out.println("\n--- Enrollment Management ---");
        System.out.println("1. Enroll Student");
        System.out.println("2. View Enrollments by Student");
        System.out.println("3. Update Enrollment Status");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Student ID: ");
                int sid = sc.nextInt();
                System.out.print("Course ID: ");
                int cid = sc.nextInt();

                enrollmentService.enrollStudent(sid, cid);
                System.out.println("Enrollment successful!");
            }

            case 2 -> {
                System.out.print("Student ID: ");
                int sid = sc.nextInt();
                enrollmentService.viewEnrollmentsByStudent(sid);
            }

            case 3 -> {
                System.out.print("Enrollment ID: ");
                int eid = sc.nextInt();
                System.out.print("New Status (ACTIVE/COMPLETED/CANCELLED): ");
                String status = sc.next();

                enrollmentService.updateEnrollmentStatus(eid, status);
                System.out.println("Status updated");
            }
        }
    }


        private static void courseMenu(Scanner sc) {

        System.out.println("\n--- Course Management ---");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Activate/Deactivate Course");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Course Name: ");
                String name = sc.nextLine();
                System.out.print("Description: ");
                String desc = sc.nextLine();
                System.out.print("Duration (weeks): ");
                int weeks = sc.nextInt();

                courseService.addCourse(name, desc, weeks);
                System.out.println("Course added!");
            }

            case 2 -> courseService.listCourses();

            case 3 -> {
                System.out.print("Course ID: ");
                int id = sc.nextInt();
                courseService.toggleCourseStatus(id);
                System.out.println("Course status updated");
            }
        }
    }


    private static void studentMenu(Scanner sc) {

        System.out.println("\n--- Student Management ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Deactivate Student");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1 -> {
                System.out.print("First Name: ");
                String fn = sc.nextLine();
                System.out.print("Last Name: ");
                String ln = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Batch: ");
                String batch = sc.nextLine();

                studentService.addStudent(fn, ln, email, batch);
                System.out.println("Student added successfully!");
            }

            case 2 -> studentService.listStudents();

            case 3 -> {
                try {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    Student s = studentService.findStudentById(id);
                    System.out.println("Student Found: " + s.getDisplayName());

                } catch (EntityNotFoundException e) {
                    System.out.println( e.getMessage());
                }
            }


            case 4 -> {
                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                boolean result = studentService.deactivateStudent(id);
                System.out.println(result ? "Student deactivated" : "Student not found");
            }
        }
    }

}