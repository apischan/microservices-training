package com.apischan.controllers;

import com.apischan.entity.Player;
import com.apischan.entity.Team;
import com.apischan.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.*;

//@RestController
public class TeamController {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostConstruct
    public void init() {
        List<Team> list = new ArrayList<>();

        Set<Player> players = new HashSet<>(Arrays.asList(
                new Player("David", "Forward"),
                new Player("Donald", "Defender")
        ));

        Team team = new Team("Globetrotters", "Harlem", players);
        list.add(team);

        players = new HashSet<>(Arrays.asList(
                new Player("Pavel", "Midfielder"),
                new Player("Ivan", "Goalkeeper")
        ));
        team = new Team("Washington", "Generals", players);
        list.add(team);

        teamRepository.save(list);
    }

    @RequestMapping("/teams/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamRepository.findOne(id);
    }

    @RequestMapping("/teams")
    public Iterable<Team> getTeams() {
        return teamRepository.findAll();
    }

}
