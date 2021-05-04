package Servlets.SecondServlet.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class UsersJson {
    private Gson gson;
    private ArrayList<User> users;
    private String fileName = "E:\\2nd course\\Java\\9\\src\\Servlets\\SecondServlet\\Model\\Users.json";

    public UsersJson() throws FileNotFoundException {
        users = getUsersFromFile();
    }

    public ArrayList<User> getUsersFromFile() {
        gson = new GsonBuilder().create();
        ArrayList<User> users = null;

        try (Reader reader = Files.newBufferedReader(new File(fileName).toPath(), StandardCharsets.UTF_8)) {
            users = gson.fromJson(reader, new TypeToken<ArrayList<User>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (users == null)
            users = new ArrayList<>();

        return users;
    }

    public void addUser(User user) throws IOException {
        gson = new Gson();
        users.add(user);

        try (FileOutputStream file = new FileOutputStream(fileName);
             OutputStreamWriter out = new OutputStreamWriter(file, StandardCharsets.UTF_8)) {
            gson.toJson(users, out);
        }
    }

    public boolean checkUser(User user) {
        for (User us: users) {
            if(us.toString().equals(user.toString())){
                return true;
            }
        }

        return false;
    }
}
