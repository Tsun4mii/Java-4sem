import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class InternetConnection {

    public void getLocalHost() {
        try {
            var currentLocalHostIP = InetAddress.getLocalHost();
            System.out.println("IP -> " + currentLocalHostIP.getHostAddress());
        } catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getByName(String web) {
        try {
            var pageIP = InetAddress.getByName(web);
            System.out.println(pageIP.getHostAddress());
        } catch (UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getByAdress(String name, byte[] ip) {
        try {
            var pageIP = InetAddress.getByAddress(name, ip);
            System.out.println(pageIP.isReachable(100));
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void ReadHTML(String URL) {
        try {
            var url = new URL(URL);
            try (var reader = new BufferedReader(new InputStreamReader((url.openStream())))) {
                var HTMLLine = "";
                while((HTMLLine = reader.readLine()) != null) {
                    System.out.println(HTMLLine);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getInfo(String UrlName) {
        var timeout= 10_000;
        try{
            var url = new URL(UrlName);
            final var connection = url.openConnection();
            connection.setConnectTimeout(timeout);

            System.out.println(UrlName + " content type: \n"
                    +connection.getContentType()+"\n"+
                    connection.getClass()+"\n"+
                    connection.getContentLength());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}