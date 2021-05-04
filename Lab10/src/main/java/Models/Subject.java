package Models;

public class Subject {
    private int id;
    private String name;
    private String teacher;

    public Subject(String name, String teacher, String faculty) {
        this.name = name;
        this.teacher = teacher;
        this.faculty = faculty;
    }

    private String faculty;

    public Subject() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
