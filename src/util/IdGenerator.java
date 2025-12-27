package util;

public class IdGenerator {

    private static int studentIdCounter = 1000;
    private static int courseIdCounter = 2000;

    public static int getNextStudentId(){
        return studentIdCounter++;
    }


    public static int getNextCourseId() {
        return courseIdCounter++;
    }
}
