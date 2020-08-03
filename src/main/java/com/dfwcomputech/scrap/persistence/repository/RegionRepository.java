package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	public Region findTopByName(String name);

	@Query(value="select max(r.id) from Region r")
	public Integer findMaxId();
	default Region findByRegionName(String name) {
		return findTopByName(name);
	}
}
