package com.example.demo;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GAMES", schema = "STUDENT", catalog = "")
public class Game {
    private long id;
    private String name;

    @Id
    @Column(name="ID")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id=id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id &&
                Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
