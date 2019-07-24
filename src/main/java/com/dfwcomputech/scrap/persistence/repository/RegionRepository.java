package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	public Region findTopByName(String name);

	default Region findByRegionName(String name) {
		return findTopByName(name);
	}
}
