package com.dfwcomputech.scrap.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Patch;

@Repository
public interface PatchRepository extends JpaRepository<Patch, Integer>{
	//Find all versions by year
	public List<Patch> findByPesYear(Integer year);
	//Find the latest version by year
	public Patch findTopByPesYearOrderByVersionDescSubversionDesc(Integer year);
}
