package shust.team;

import shust.team.Human;
import shust.team.ItCompany;

public class TeamLead extends Human {
    public TeamLead(String name, int age, int salary)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public void ManageWork(){
        System.out.println("Starting the meeting");
    }
}
