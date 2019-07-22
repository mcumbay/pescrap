package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Patch;

@Repository
public interface PatchRepository extends JpaRepository<Patch, Integer>{
		
	public Patch findTopByPesYearOrderByDataPackDescVersionDescSubversionDesc(Integer year);
	public Patch findTopByOrderByPesYearDescDataPackDescVersionDescSubversionDesc();
	
	
	//Find the latest patch
	public default Patch findLatestPatch() {
		return findTopByOrderByPesYearDescDataPackDescVersionDescSubversionDesc();
	}
	//Find the latest patch by Year
	public default Patch findLatestPatchByYear(Integer year) {
		return findTopByPesYearOrderByDataPackDescVersionDescSubversionDesc(year);
	}
}
