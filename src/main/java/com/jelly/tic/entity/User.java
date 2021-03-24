package com.jelly.tic.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;

public class User extends AbstractEntity implements Serializable {
    static final long serialVersionUID = 1L;

    private String username;
    private String password;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void setName(String username) {this.username = username;}

    public String getName() {return username;}

    public void setPassword(String password) {this.password = passwordEncoder.encode(password.trim());}

//    public void setPassword(String password) {this.password = password;}

    public String getPassword() {return password;}

    public User getUser() {return this;}

    public User authenticateUserByPassword(String username, String password) {
        return null;
    }
}
