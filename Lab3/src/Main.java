import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import shust.team.Human;
import shust.team.Middle;
import shust.team.TeamLead;
import shust.team.lab4.SaxParser;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static{
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        try {
             Middle a = new Middle("Bob", 23, 1000);
            Middle b = new Middle("Nick", 25,1220);
            TeamLead c = new TeamLead("Mike", 36,2000);
            /*ItCompany comp = new ItCompany("Random company");
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
            manager.CompanyInfo(comp);*/
            //--Парсинг XML
            ArrayList<Human> h = new ArrayList<Human>();
            h.add(a);
            h.add(b);
            h.add(c);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SaxParser saxp = new SaxParser();
            parser.parse(new File("files/Middle.xml"), saxp);
            Middle Bobby = saxp.getResult();
            System.out.println(Bobby.name);
            System.out.println(Bobby.age);
            System.out.println(Bobby.salary);
            //--Сериализация XML
            System.out.println("--------------Сериализация XML------------------");
            FileOutputStream out = new FileOutputStream("files/Serialize.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(Bobby);
            xmlEncoder.close();
            //--Десиреализация XML
            System.out.println("--------------Десериализация XML------------------");
            FileInputStream in = new FileInputStream("files/Serialize.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            Middle Bobby2 = (Middle) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println(Bobby2.name);
            System.out.println(Bobby2.age);
            System.out.println(Bobby2.salary);
            //--Сериализация Json
            System.out.println("-----------------Сериализация JSON---------------");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(Bobby);
            System.out.println(json);
            FileOutputStream jsonOut = new FileOutputStream("files/Serialize.json");
            byte[] outText = json.getBytes(StandardCharsets.UTF_8);
            jsonOut.write(outText, 0, outText.length);
            //--Десериализация Json
            System.out.println("--------------Десериализация JSON---------------");
            Scanner scanner = new Scanner(new File("files/Serialize.json"));
            String res = "";
            while(scanner.hasNext())
                res += scanner.nextLine();
            scanner.close();
            Middle m3 = gson.fromJson(res, Middle.class);
            System.out.println(m3.name);
            System.out.println(m3.age);
            System.out.println(m3.salary);
            //--Stream API
            System.out.println("-------------------Stream API-------------");
            Stream<Human> res_stream = h.stream().filter(w -> w.getSalary() > 1000);
            for(var x: res_stream.collect(Collectors.toList()))
            {
                System.out.println(x.name + " " + x.salary);
            }
            System.out.println("----------------------------------");
            Stream<Human> res_stream2 = h.stream().limit(2);
            for(var x: res_stream2.collect(Collectors.toList()))
            {
                System.out.println(x.name + " " + x.salary);
            }
        }
        catch (Exception e)
        {
            LOG.info(e.getMessage());
        }
    }
}
