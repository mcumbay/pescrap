package com.dfwcomputech.scrap.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.Patch;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.repository.PatchRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerRepository;

@Service
public class PlayerService {
	
	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PatchRepository patchRepository;
	
	
	public void save(Player player) {
		//Verify if there are player information
		if(player!=null) {
			//Verify if the Id was provided
			if(player.getPesdbId()!=null) {
				//Verify if the id already exist on DB
				if(!playerRepository.existsPlayerByPesdbId(player.getPesdbId())) {
					playerRepository.save(player);
				}else {
					logger.info("Player with Pes DB Id= {} already exists.",player.getPesdbId());
				}
					
			}
		}
	}
	
	public void saveDetail(PlayerDetail detail) {
		//Verify if there are detail information
		if(detail!=null) {
			//Verify if PlayerId was provided
			if(detail.getId()!=null && detail.getId().getPlayerId()!=null) {
				//Verify if the detail already exists on DB
				Patch currentPatch = patchRepository.findLatestPatch();
				
			}
		}
	}
}
