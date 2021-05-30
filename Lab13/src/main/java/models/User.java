package models;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String login;
    private String password;

    public int getId() {
        return id;
    }
    public String getLogin() {return login;}

    public String getPassword() {return password;}

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return getLogin() + getPassword();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String passw) {
        this.password = password;
    }
}