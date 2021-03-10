package Task1;

public class Auditorium {
    private Student[] students;
    private int auditorumSize;

    public Auditorium(int size) {
        this.auditorumSize = size;
        students = new Student[size];
    }

    public int getFreePlace() {
        for (int i = 0; i < auditorumSize; i++) {
            if (students[i] == null)
                return i;
        }
        return -1;
    }

    public void setStudent(Student student) {
        System.out.println("Student " + student.getStudentName() + " is placed");
        students[getFreePlace()] = student;
    }

    public void leaveStudent(Student student){
        for(int i=0;i<auditorumSize;i++){
            if(students[i] == student){
                students[i] = null;
                System.out.println("Student " + student.getStudentName() + " leave the auditorium");
            }
        }
    }

    public void showAuditorium() {
        System.out.println("Auditorium places:{");
        for (int i = 0; i < auditorumSize; i++) {
            if(students[i] != null){
                System.out.println(i + ") " + students[i].getStudentName());
            }
            else{
                System.out.println(i + ") empty");
            }
        }
        System.out.println("}");
    }
}
