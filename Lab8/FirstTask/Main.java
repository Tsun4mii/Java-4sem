public class Main {
    public static void main(String[] args) {
        var connection = new InternetConnection();
        connection.getLocalHost();
        connection.getByName("www.google.com");
        byte ip[] = {(byte)216,(byte)58,(byte)212,(byte)142};
        connection.getByAdress("Unknown", ip);
        connection.ReadHTML("https://www.tut.by");
        connection.getInfo("https://www.tut.by");
    }
}