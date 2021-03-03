package shust.team;

import shust.team.Human;

public class Middle extends Human {
    public Middle(String name, int age, int salary)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public Middle()
    {

    }
    public void Work(){
        System.out.println(this.name + " working on the project");
    }
}
