package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="PLAYER",schema = "STUDENT",catalog = "")
public class Player {
    private long id;
    private String name;
    private String gameResult;
    Date date = new Date();

    public Player(int id, String name) {

    }

    public Player() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
