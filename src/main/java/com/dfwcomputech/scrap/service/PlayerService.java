package com.dfwcomputech.scrap.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.Ability;
import com.dfwcomputech.scrap.persistence.domain.Patch;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.domain.Scout;
import com.dfwcomputech.scrap.persistence.repository.AbilityRepository;
import com.dfwcomputech.scrap.persistence.repository.PatchRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerDetailRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerRepository;
import com.dfwcomputech.scrap.persistence.repository.ScoutRepository;

@Service
public class PlayerService {

	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private PatchRepository patchRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerDetailRepository playerDetailRepository;
	@Autowired
	private AbilityRepository abilityRepository;
	@Autowired
	private ScoutRepository scoutRepository;
	@Autowired
	private ScrapService scrapService;
	

	public Player findPlayerByPesdbId(Integer pesdbId) {
		return playerRepository.findPlayerByPesdbId(pesdbId);
	}
	
	public Player savePlayer(Player player) {
		// Verify if there are player information
		if (player != null)
			// Verify if the Id was provided
			if (player.getPesdbId() != null)
				// Verify if the id already exist on DB
				if (!playerRepository.existsPlayerByPesdbId(player.getPesdbId())) {	
					Player completePlayer = scrapService.scrapPlayer(player.getPesdbId());
					return playerRepository.save(completePlayer);
				}
				else {
					logger.info("Player with Pes DB Id= {} already exists.", player.getPesdbId());
					return playerRepository.findPlayerByPesdbId(player.getPesdbId());
				} 
										
		return null;
					
	}

	public PlayerDetail saveDetails(PlayerDetail detail) {
		// Verify if there is detail information
		if (detail != null) {
			// Verify if PlayerId was provided
			if (detail.getId() != null && detail.getId().getPlayerId() != null) {
				// Verify if the detail already exists on DB
				Patch currentPatch = patchRepository.findLatestPatch();
				if (!playerDetailRepository.exists(currentPatch.getId(), detail.getId().getPlayerId())) {
					detail.getId().setPatchId(currentPatch.getId());
					return playerDetailRepository.save(detail);
				} else
					logger.info("Player Detail with[PatchId= {} PlayerId= {} ] already exists.", currentPatch.getId(),
							detail.getId().getPlayerId());
			}
		}
		return null;
	}
	
	public Ability saveAbilityByLevel(Ability ability,Integer level) {
		//Verify if there is ability and level information
		if(ability!=null && level!=null) {
			//Verify if Player Id was provided
			if(ability.getId()!=null && ability.getId().getPlayerId()!=null) {
				//Verify if the ability information already exists on DB
				Patch currentPatch = patchRepository.findLatestPatch();
				if(!abilityRepository.exists(currentPatch.getId(),ability.getId().getPlayerId(),level)) {
					ability.getId().setPatchId(currentPatch.getId());
					ability.getId().setLevel(level);
					return abilityRepository.save(ability);
				}else
					logger.info("Ability with [PatchId ={} PlayerId ={} Level ={}] already exists.",currentPatch.getId(),
							ability.getId().getPlayerId(),level);
			}
		}
		return null;
	}
	
	//By Default we save at level 30
	public Ability saveAbility(Ability ability) {
		return saveAbilityByLevel(ability,30);
	}
		
	public Scout saveScout(Scout scout) {
		//Verify that there are scout information
		if(scout!=null && 
			scout.getChance()!=null &&
			scout.getScout1()!=null &&
			scout.getLevel()!=null &&
			scout.getPlayer()!=null &&			
			scout.getPlayer().getId()!=null) {
			//Verify that the scout doesnt already exists
			Patch currentPatch = patchRepository.findLatestPatch();
			Player player = playerRepository.findById(scout.getPlayer().getId()).get();
			if(player==null) {
				logger.info("Player with Id= {} doesnt exists on DB",scout.getPlayer().getId());
				return null;
			}
				
			scout.setPatch(currentPatch);
			scout.setPlayer(player);
			Example<Scout> scoutExample = Example.of(scout);
			if(!scoutRepository.exists(scoutExample)) {
				return scoutRepository.save(scout);
			}
		}
		return null;
	}
	
}
