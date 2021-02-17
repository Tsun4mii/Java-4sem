import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import shust.team.*;
import shust.team.manager.CompanyManager;

public class Main {
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        try {
            Middle a = new Middle("Bob", 23, 1000);
            Middle b = new Middle("Nick", 25,1000);
            TeamLead c = new TeamLead("Mike", 36,2000);
            ItCompany comp = new ItCompany("Random company");
            a.Work();
            CompanyManager manager = new CompanyManager();
            comp.AddWorker(a);
            comp.AddWorker(c);
            comp.AddWorker(b);
            b.Work();
            c.ManageWork();
            comp.setCountTeam(34);
            System.out.println("----------- До сортировки -----------");
            manager.printCompany(comp);
            manager.Sort(comp.getItCompany());
            System.out.println("----------- После сортировки -----------");
            manager.printCompany(comp);
            manager.CompanyInfo(comp);
        }
        catch (Exception e)
        {
            LOG.info(e.getMessage());
        }
    }
}
