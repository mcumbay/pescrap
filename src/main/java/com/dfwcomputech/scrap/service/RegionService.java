package com.dfwcomputech.scrap.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.Nationality;
import com.dfwcomputech.scrap.persistence.domain.Region;
import com.dfwcomputech.scrap.persistence.repository.NationalityRepository;
import com.dfwcomputech.scrap.persistence.repository.RegionRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private NationalityRepository nationalityRepository;
	
	public Nationality getNationality(String nationalityName,String regionName) {
		if(Strings.isEmpty(nationalityName)) {
			log.error("Nationality Name is mandatory");
			return null;
		}
		
		if(Strings.isEmpty(regionName)) {
			log.error("Region Name is mandatory");
			return null;
		}
		Nationality nationality = nationalityRepository.findByNationalityName(nationalityName);
		if(nationality==null) {
			log.info("Nationality not found. Adding {} to DB",nationalityName);
			Region region = regionRepository.findByRegionName(regionName);
			if(region==null) {
				log.info("Region not found. Adding {} to DB", regionName);
				region = new Region();
				region.setName(regionName);
				region = regionRepository.save(region);
			}
			nationality= new Nationality();
			nationality.setName(nationalityName);
			nationality.setRegion(region);
			return nationalityRepository.save(nationality);
		}
		return nationality;	
	}
}
