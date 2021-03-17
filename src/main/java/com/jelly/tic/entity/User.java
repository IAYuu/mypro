package com.jelly.tic.entity;

public class User {
    private Long id;

    private String name;
    private String password;
//    private String sex;
//    private int age;

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public void setPassword(String password) {this.password = password;}

    public String getPassword() {return password;}

    public User authenticateUserByPassword(String name, String password) {
        return null;
    }
}
