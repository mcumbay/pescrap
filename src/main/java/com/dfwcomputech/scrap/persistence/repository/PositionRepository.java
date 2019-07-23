package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{

	public Position findTopByCode(String code);
		
}
