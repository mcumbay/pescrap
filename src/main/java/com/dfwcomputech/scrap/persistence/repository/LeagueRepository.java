package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer>{
	public League findTopByName(String name);
	default League findByLeagueName(String leagueName) {
		return findTopByName(leagueName);
	}
}
