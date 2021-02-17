package shust.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if(o1.getSalary() > o2.getSalary())
            return 1;
        else if(o1.getSalary() < o2.getSalary())
            return -1;
        else
            return 0;
    }
}
