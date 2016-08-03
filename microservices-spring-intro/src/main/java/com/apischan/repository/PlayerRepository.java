package com.apischan.repository;

import com.apischan.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="players", rel="player")
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
