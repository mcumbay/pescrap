package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	Team findTopByName(String name);
	
	default Team findByTeamName(String name) {
		return findTopByName(name);
	}
}
