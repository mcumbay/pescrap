package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
