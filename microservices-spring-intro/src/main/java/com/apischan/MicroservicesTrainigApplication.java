package com.apischan;

import com.apischan.entity.Player;
import com.apischan.entity.Team;
import com.apischan.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class MicroservicesTrainigApplication {


    private final TeamRepository teamRepository;

    @Autowired
    public MicroservicesTrainigApplication(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesTrainigApplication.class, args);
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
}
