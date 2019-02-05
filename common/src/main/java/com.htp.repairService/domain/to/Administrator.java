package com.htp.repairService.domain.to;

import java.util.Objects;

public class Administrator {
    private String login = new String();
    private String password = new String();
    private String role = new String();


    public Administrator(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Administrator() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int hashCode(){
        return 7 * this.login.hashCode() + 7 * this.password.hashCode() + 7 * this.role.hashCode();
    }
}
