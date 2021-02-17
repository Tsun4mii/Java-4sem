package shust.team.manager;

import shust.team.CustomComparator;
import shust.team.Human;
import shust.team.ItCompany;
import java.util.ArrayList;
import java.util.Collections;

public class CompanyManager extends Human {
    public void printCompany(ItCompany comp)
    {
        for (Human k : comp.getItCompany())
        {
            System.out.println("Имя " + k.name + " Зарплата: "+ k.salary);
        }
    }
    public int TeamSize(ItCompany comp)
    {
        return comp.getItCompany().size();
    }
    public void Sort(ArrayList<Human> list) {
        Collections.sort(list, new CustomComparator());
    }
    public void CompanyInfo(ItCompany company)
    {
        System.out.println("Имя комании: " + company.companyName + "\n" + "Кол-во сотрудников: " + company.getCountTeam());
    }
}
