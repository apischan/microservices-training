package com.apischan.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Team {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String location;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="teamId")
    private Set<Player> players;

    public Team() {}

    public Team(String name, String location, Set<Player> players) {
        this.name = name;
        this.location = location;
        this.players = players;
    }


}
