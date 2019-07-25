package com.dfwcomputech.scrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.Scout;
import com.dfwcomputech.scrap.persistence.repository.PatchRepository;
import com.dfwcomputech.scrap.persistence.repository.ScoutRepository;

@Service
public class ScoutService {
	
	@Autowired
	private ScoutRepository scoutRepository;
	@Autowired
	private PatchRepository patchRepository;
	
	
	public Scout addScout(Scout scout) {		
		if(scout!=null) {
			//Verify Player Id is present
			if(scout.getPlayer()!=null && scout.getPlayer().getId()!=null) {
				//Verify Scout information is present
				if(scout.getLevel()!=null &&scout.getScout1()!=null) {					
					scout.setPatch(patchRepository.findLatestPatch());
					return scoutRepository.save(scout);
				}
			}	
		}
		return null;
	}
}
