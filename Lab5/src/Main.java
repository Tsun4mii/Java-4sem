import Task1.Auditorium;
import Task1.Student;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

class Vehicle extends Thread {
    String name;
    public boolean isStayed = false;
    Semaphore sem;
    int n;

    public Vehicle(int n, Semaphore sem) {
        this.n = n;
        this.sem = sem;
    }

    int num = 0;

    @Override
    public void run() {
        try {
            while (num < 3) {
                sem.acquire();
                System.out.println(this + " припарковался");
                Thread.sleep(400);
                num++;
                System.out.println(this + " освобождает разрешение");
                sem.release();
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {

        }
    }
}
public class Main {

    public static final int STUDENTCOUNT = 20;
    public static final int AUDITORIUMSIZE = 5;

    public static void main(String[] args) {
        Auditorium parking = new Auditorium(AUDITORIUMSIZE);
        // Random rand = new Random();

        for (int i = 0; i < STUDENTCOUNT; i++) {
            (new Student(i, parking)).start();
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){

            }
        }
        //Semaphore sem = new Semaphore(2);
        //for(int i=1;i<6;i++)
        //    new Vehicle(i, sem).start();
    }
}