package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.PlayingStyle;

@Repository
public interface PlayingStyleRepository extends JpaRepository<PlayingStyle, Integer>{

	public PlayingStyle findTopByName(String name);
	
	default PlayingStyle findByStyle(String style) {
		return findTopByName(style);
	}	
}
