package com.jelly.tic.entity;

import java.io.Serializable;

public class Role extends AbstractEntity implements Serializable {

    static final long serialVersionUID = 1L;

    private String name;

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}
}
