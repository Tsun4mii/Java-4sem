package shust.team;
import java.util.ArrayList;


public class ItCompany implements Company {
    public String companyName;
    private int countTeam;
    private ArrayList<Human> itCompany = new ArrayList<>();
    public void setItCompany(ArrayList<Human> comps)
    {
        this.itCompany = comps;
    }
    public ArrayList<Human> getItCompany()
    {
        return itCompany;
    }
    public void AddWorker(Human human) {
        itCompany.add(human);
        countTeam++;
    }
    public int getCountTeam()
    {
        return countTeam;
    }
    public void setCountTeam(int count) throws Exception {
        if(count > 30)
            throw new Exception("Превышен размер команды");
        countTeam = count;
    }
    public ItCompany(String name)
    {
        this.companyName = name;
    }
}
