package com.dfwcomputech.scrap.service;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlayerService {

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


	public Player findPlayerByPesdbId(Integer pesdbId) {
		return playerRepository.findByPesdbId(pesdbId);
	}
	
	public Player savePlayer(Player player) {
		log.info("Saving player to DB");		
		if ((player != null)&&(player.getPesdbId() != null)) {
			if (!playerRepository.existsPlayerByPesdbId(player.getPesdbId())) {	
				log.info("{}={}",player.getPesdbId(),player.getName());
				return playerRepository.save(player);
			}
			else {
				log.info("Player with Pes DB Id= {} already exists.", player.getPesdbId());
				return playerRepository.findByPesdbId(player.getPesdbId());
			} 
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
					log.info("Player Detail with[PatchId= {} PlayerId= {} ] already exists.", currentPatch.getId(),
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
					log.info("Ability with [PatchId ={} PlayerId ={} Level ={}] already exists.",currentPatch.getId(),
							ability.getId().getPlayerId(),level);
			}
		}
		return null;
	}
	
	//By Default we save at level 30
	public Ability saveAbility(Ability ability) {
		return saveAbilityByLevel(ability,1);
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
				log.info("Player with Id= {} doesnt exists on DB",scout.getPlayer().getId());
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
	
	public PlayerDetail findCurrentDetails(Integer pesdbId) {
		
		Patch currentPatch = patchRepository.findLatestPatch();
		Player player = playerRepository.findByPesdbId(pesdbId);
		if(player!=null)
			return playerDetailRepository.findByIdPatchIdAndIdPlayerId(currentPatch.getId(),player.getId());
		return null;
	}
}
