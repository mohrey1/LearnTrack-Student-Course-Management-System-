package entity;

public class Course {

    private int id;
    private String CourseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course() {
    }

    public Course(int id, String courseName, String description, int durationInWeeks, boolean active) {
        this.id = id;
        CourseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getDescription() {
        return description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
