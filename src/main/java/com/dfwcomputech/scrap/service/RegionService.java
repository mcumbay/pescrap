package com.dfwcomputech.scrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.Nationality;
import com.dfwcomputech.scrap.persistence.domain.Region;
import com.dfwcomputech.scrap.persistence.repository.NationalityRepository;
import com.dfwcomputech.scrap.persistence.repository.RegionRepository;
import com.google.common.base.Strings;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private NationalityRepository nationalityRepository;
	
	public Nationality getNationality(String nationalityName,String regionName) {
		if(!Strings.isNullOrEmpty(nationalityName)) {
			Nationality nationality = nationalityRepository.findByNationalityName(nationalityName);
			if(nationality==null) {
				Region region = regionRepository.findByRegionName(regionName);

				nationality= new Nationality();
				nationality.setName(nationalityName);
				nationality.setRegion(region);
				return nationalityRepository.save(nationality);
			}
				
		}
		return null;
	}
}
