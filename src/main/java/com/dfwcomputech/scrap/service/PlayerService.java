package com.dfwcomputech.scrap.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.Scrapper;
import com.dfwcomputech.scrap.persistence.domain.Ability;
import com.dfwcomputech.scrap.persistence.domain.AbilityId;
import com.dfwcomputech.scrap.persistence.domain.Patch;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetailId;
import com.dfwcomputech.scrap.persistence.domain.Scout;
import com.dfwcomputech.scrap.persistence.repository.AbilityRepository;
import com.dfwcomputech.scrap.persistence.repository.PatchRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerDetailRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerRepository;
import com.dfwcomputech.scrap.persistence.repository.ScoutRepository;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class PlayerService {

	private static final Logger logger = LogManager.getLogger();
	@Autowired
	private Scrapper scrapper;
	
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
	

	public Player savePlayer(Player player) {
		// Verify if there are player information
		if (player != null)
			// Verify if the Id was provided
			if (player.getPesdbId() != null)
				// Verify if the id already exist on DB
				if (!playerRepository.existsPlayerByPesdbId(player.getPesdbId()))
					return playerRepository.save(player);
				else {
					logger.info("Player with Pes DB Id= {} already exists.", player.getPesdbId());
					return playerRepository.findPlayerByPesdbId(player.getPesdbId());
				} 
										
		return null;
					
	}

	public void saveDetails(PlayerDetail detail) {
		// Verify if there is detail information
		if (detail != null) {
			// Verify if PlayerId was provided
			if (detail.getId() != null && detail.getId().getPlayerId() != null) {
				// Verify if the detail already exists on DB
				Patch currentPatch = patchRepository.findLatestPatch();
				if (!playerDetailRepository.exists(currentPatch.getId(), detail.getId().getPlayerId())) {
					detail.getId().setPatchId(currentPatch.getId());
					playerDetailRepository.save(detail);
				} else
					logger.info("Player Detail with[PatchId= {} PlayerId= {} ] already exists.", currentPatch.getId(),
							detail.getId().getPlayerId());
			}
		}
	}
	
	public void saveAbilityByLevel(Ability ability,Integer level) {
		//Verify if there is ability and level information
		if(ability!=null && level!=null) {
			//Verify if Player Id was provided
			if(ability.getId()!=null && ability.getId().getPlayerId()!=null) {
				//Verify if the ability information already exists on DB
				Patch currentPatch = patchRepository.findLatestPatch();
				if(!abilityRepository.exists(currentPatch.getId(),ability.getId().getPlayerId(),level)) {
					ability.getId().setPatchId(currentPatch.getId());
					ability.getId().setLevel(level);
					abilityRepository.save(ability);
				}else
					logger.info("Ability with [PatchId ={} PlayerId ={} Level ={}] already exists.",currentPatch.getId(),
							ability.getId().getPlayerId(),level);
			}
				
		}
	}
	
	//By Default we save at level 30
	public void saveAbility(Ability ability) {
		saveAbilityByLevel(ability,30);
	}
	public PlayerDetail scrapPlayer(Integer pesdbId) {
		
		scrapper.setPage("?id="+pesdbId);
		HtmlTable mainTable = scrapper.getTable("//table[@class='player']");
		
		//1. Getting Player information
		Player player = new Player();
		
		String playerName = scrapDetailString(mainTable.getCellAt(0, 0),0);
		String nationality = scrapDetailString(mainTable.getCellAt(0, 0),4);
		String region = scrapDetailString(mainTable.getCellAt(0, 0),5);
		
		player.setName(playerName);
		player.setNationality(nationality);
		player.setRegion(region);
		player.setPesdbId(pesdbId);
		
		player = savePlayer(player);
						
		//2. Getting Player Details
		PlayerDetail playerDetail = new PlayerDetail();
		
		String squatNumber =  scrapDetailString(mainTable.getCellAt(0, 0),1);
		String teamName =scrapDetailString(mainTable.getCellAt(0, 0),2);
		String league = scrapDetailString(mainTable.getCellAt(0, 0),3);
		String height = scrapDetailString(mainTable.getCellAt(0, 0),6);
		String weight = scrapDetailString(mainTable.getCellAt(0, 0),7);
		String age = scrapDetailString(mainTable.getCellAt(0, 0),8);
		String foot = scrapDetailString(mainTable.getCellAt(0, 0),9);
		String currentCondition = scrapDetailString(mainTable.getCellAt(0, 0),10);
		String preferedPosition = scrapDetailString(mainTable.getCellAt(0, 0),11);
		String oprAtLevel30 = scrapDetailString(mainTable.getCellAt(0, 2),13);
		
		PlayerDetailId detailId = new PlayerDetailId(null, player.getId());
		playerDetail.setId(detailId);
		playerDetail.setSquatNumber(Integer.valueOf(squatNumber));
		playerDetail.setTeam(teamName);
		playerDetail.setLeague(league);
		playerDetail.setHeight(Integer.valueOf(height));
		playerDetail.setWeight(Integer.valueOf(weight));
		playerDetail.setAge(Integer.valueOf(age));
		playerDetail.setFoot(foot);
		playerDetail.setCurrentCondition(currentCondition);
		playerDetail.setPreferedPosition(preferedPosition);
		playerDetail.setOprAtLevel30(Integer.valueOf(oprAtLevel30));

		saveDetails(playerDetail);
		
		//3. Getting Player Abilities (lvl 30)
		Ability ability = new Ability();
		AbilityId abilityId= new AbilityId(null, player.getId(), null);		
		ability.setId(abilityId);
		
		ability.setAttackingProwness(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),0)));
		ability.setBallControl(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),1)));
		ability.setDribbling(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),2)));
		ability.setLowPass(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),3)));
		ability.setLoftedPass(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),4)));
		ability.setFinishing(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),5)));
		ability.setPlaceKicking(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),6)));
		ability.setSwerve(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),7)));
		ability.setHeader(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),8)));
		ability.setDefensiveProwness(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),9)));
		ability.setBallWinning(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),10)));
		ability.setKickingPower(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),11)));
		ability.setSpeed(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),12)));
		ability.setExplosivePower(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),13)));
		ability.setUnwaveringBalance(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 1),14)));
		ability.setPhysicalContact(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),0)));
		ability.setJump(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),1)));
		ability.setGoalkeeping(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),2)));
		ability.setGkcatch(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),3)));
		ability.setClearing(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),4)));
		ability.setReflexes(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),5)));
		ability.setCoverage(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),6)));
		ability.setStamina(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),7)));
		ability.setWeakFootUsage(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),8)));
		ability.setWeakFootAccuracy(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),9)));
		ability.setForm(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),10)));
		ability.setInjuryResistance(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),11)));
		ability.setRating(Integer.valueOf(scrapDetailString(mainTable.getCellAt(0, 2),13)));
		
		saveAbility(ability);				
						
		//HtmlTableRow levelBarRow =rows.get(1);
		//HtmlTableRow pictureSocialMediaRow =rows.get(2);
		//HtmlTableRow ScoutsRow =rows.get(4);
				
		return playerDetail;
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
	
	private String scrapDetailString(HtmlTableCell tableCell, Integer row) {

		HtmlTable detailTable1 =(HtmlTable)tableCell.getFirstElementChild();
		List<HtmlTableRow> detailrows1=detailTable1.getRows();
		//Detail Cell
		HtmlTableRow squatNumberRow = detailrows1.get(row);
		List<HtmlTableCell> squatNumberRowCells = squatNumberRow.getCells();
		return squatNumberRowCells.get(1).asText();
		
	}
}
