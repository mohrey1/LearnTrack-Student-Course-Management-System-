package entity;

public class Student extends Person {

    private String batch;
    private boolean active;


    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public String getBatch() {
        return batch;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String getDisplayName(){
        return "Student: "+ firstName + " " + lastName + " (" + batch + ")";
    }
}
