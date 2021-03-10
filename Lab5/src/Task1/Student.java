package Task1;

import java.util.Random;

public class Student extends Thread {

    public String studentName;
    Auditorium auditorium;
    Random random = new Random();

    public Student(int studentName, Auditorium auditorium) {
        this.studentName = String.valueOf(studentName);
        this.auditorium = auditorium;
        System.out.println("Student " + this.studentName + "  come");
    }

    @Override
    public void run() {
        synchronized (auditorium) {
            if (auditorium.getFreePlace() == -1) {
                int waitingTime = random.nextInt(1000);
                System.out.println("Student " + this.getStudentName() + " is waiting...");
                try{
                    auditorium.wait(waitingTime);
                }
                catch(InterruptedException e){
                }
            }
        }
        if(auditorium.getFreePlace() != -1){
            auditorium.setStudent(this);
            auditorium.showAuditorium();
            try{
                Thread.sleep(random.nextInt(3000));
            }
            catch(Exception e){
            }

            auditorium.leaveStudent(this);
            synchronized (auditorium){
                auditorium.notify();
            }
        }
        else{
            System.out.println("Student " + this.getStudentName() + " left");
        }
    }

    public String getStudentName(){
        return this.studentName;
    }
}

