package com.dfwcomputech.scrap.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.Scrapper;
import com.dfwcomputech.scrap.persistence.domain.Ability;
import com.dfwcomputech.scrap.persistence.domain.AbilityId;
import com.dfwcomputech.scrap.persistence.domain.Nationality;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetailId;
import com.dfwcomputech.scrap.persistence.domain.PlayingStyle;
import com.dfwcomputech.scrap.persistence.domain.Position;
import com.dfwcomputech.scrap.persistence.domain.Scout;
import com.dfwcomputech.scrap.persistence.domain.Team;
import com.dfwcomputech.scrap.persistence.repository.PlayingStyleRepository;
import com.dfwcomputech.scrap.persistence.repository.PositionRepository;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class ScrapService {

	private static final Logger logger = LogManager.getLogger();
	
	private static final Integer MAIN_TABLE_ROW_ATTRIBUTES = 0;
	private static final Integer MAIN_TABLE_ROW_LEVEL_BAR = 1;
	private static final Integer MAIN_TABLE_ROW_IMAGE_AND_SOCIAL_MEDIA = 2;
	private static final Integer MAIN_TABLE_ROW_ADVERTISING = 3;
	private static final Integer MAIN_TABLE_ROW_SCOUTS = 3;
	
	private static final Integer FIRST_COLUMN=0, ROW_1 = 0;
	private static final Integer SECOND_COLUMN=1 ,ROW_2=1;
	private static final Integer THIRD_COLUMN =2, ROW_3=2;
	private static final Integer FOURTH_COLUMN =3, ROW_4=3;
	
	@Autowired
	private Scrapper scrapper;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private LeagueService leagueService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private ScoutService scoutService;	
	
	@Autowired
	private PlayingStyleRepository playingStyleRepository ;
	
	@Autowired
	private PositionRepository positionRepository;
	
	public Player scrapPlayer(Integer pesdbId) {

		scrapper.setPage("?id=" + pesdbId);
		HtmlTable mainTable = scrapper.getTable("//table[@class='player']");
		HtmlTableCell attributesColumn1 = mainTable.getCellAt(MAIN_TABLE_ROW_ATTRIBUTES, FIRST_COLUMN);

		// 1. Getting Player information
		Player player = new Player();

		player.setName(scrapDetailString(attributesColumn1, 0));
		player.setPesdbId(pesdbId);
		
		String nationalityName = scrapDetailString(attributesColumn1, 4);
		String regionName = scrapDetailString(attributesColumn1, 5);
		Nationality nationality = regionService.getNationality(nationalityName, regionName);
		player.setNationality(nationality);
		
		player = playerService.savePlayer(player);

		// 2. Getting Player Details for the current Patch
		PlayerDetail detail = scrapPlayerDetails(pesdbId,scrapper);

		// 3. Getting Player Abilities (level 30)
		Ability ability = scrapAbilities(pesdbId,scrapper);
		
		//4. Getting Scouts
		List<Scout> scouts = scrapScouts(pesdbId,scrapper);

		return player;
	}

	private PlayerDetail scrapPlayerDetails(Integer pesdbId,Scrapper scrapper) {
		Player player = playerService.findPlayerByPesdbId(pesdbId);
		
		//scrapper.setPage("?id=" + pesdbId);
		HtmlTable mainTable = scrapper.getTable("//table[@class='player']");		
		HtmlTableCell attributesColumn1 = mainTable.getCellAt(MAIN_TABLE_ROW_ATTRIBUTES, FIRST_COLUMN);		
		HtmlTableCell attributesColumn3 = mainTable.getCellAt(MAIN_TABLE_ROW_ATTRIBUTES, THIRD_COLUMN);
		HtmlTableCell attributesColumn4 = mainTable.getCellAt(MAIN_TABLE_ROW_ATTRIBUTES, FOURTH_COLUMN);
		
		PlayerDetail detail = new PlayerDetail();

		PlayerDetailId detailId = new PlayerDetailId(null, player.getId());
		detail.setId(detailId);
		detail.setSquatNumber(Integer.valueOf(scrapDetailString(attributesColumn1, 1)));
		detail.setHeight(Integer.valueOf(scrapDetailString(attributesColumn1, 6)));
		detail.setWeight(Integer.valueOf(scrapDetailString(attributesColumn1, 7)));
		detail.setAge(Integer.valueOf(scrapDetailString(attributesColumn1, 8)));
		detail.setFoot(scrapDetailString(attributesColumn1, 9));
		detail.setCurrentCondition(scrapDetailString(attributesColumn1, 10));
		detail.setOprAtLevel30(Integer.valueOf(scrapDetailString(attributesColumn3, 13)));
				
		String leagueName = scrapDetailString(attributesColumn1, 3);		
		String teamName = scrapDetailString(attributesColumn1, 2);
		Team team = leagueService.getTeam(teamName, leagueName);
		detail.setTeam(team);
		
		String preferedPositionCode = scrapDetailString(attributesColumn1, 11);
		if(preferedPositionCode!=null) {
			Position preferedPosition = positionRepository.findTopByCode(preferedPositionCode);
			if(preferedPosition!=null)
				detail.setPreferedPosition(preferedPosition);
			
		}
		
		String playingStyleName = scrapDetailString(attributesColumn4, 1,false);
		if(playingStyleName!=null) {
			PlayingStyle playingStyle = playingStyleRepository.findTopByName(playingStyleName);
			if(playingStyle!=null)
				detail.setPlayingStyle(playingStyle);
		}
						
		return playerService.saveDetails(detail);
		
	}
	
	private Ability scrapAbilities(Integer pesdbId,Scrapper scrapper) {
		Player player = playerService.findPlayerByPesdbId(pesdbId);
		
		//scrapper.setPage("?id=" + pesdbId);
		HtmlTable mainTable = scrapper.getTable("//table[@class='player']");
		HtmlTableCell attributesColumn2 = mainTable.getCellAt(MAIN_TABLE_ROW_ATTRIBUTES, SECOND_COLUMN);
		HtmlTableCell attributesColumn3 = mainTable.getCellAt(MAIN_TABLE_ROW_ATTRIBUTES, THIRD_COLUMN);
		
		Ability ability = new Ability();
		AbilityId abilityId = new AbilityId(null, player.getId(), null);
		ability.setId(abilityId);

		ability.setAttackingProwness(Integer.valueOf(scrapDetailString(attributesColumn2, 0)));
		ability.setBallControl(Integer.valueOf(scrapDetailString(attributesColumn2, 1)));
		ability.setDribbling(Integer.valueOf(scrapDetailString(attributesColumn2, 2)));
		ability.setLowPass(Integer.valueOf(scrapDetailString(attributesColumn2, 3)));
		ability.setLoftedPass(Integer.valueOf(scrapDetailString(attributesColumn2, 4)));
		ability.setFinishing(Integer.valueOf(scrapDetailString(attributesColumn2, 5)));
		ability.setPlaceKicking(Integer.valueOf(scrapDetailString(attributesColumn2, 6)));
		ability.setSwerve(Integer.valueOf(scrapDetailString(attributesColumn2, 7)));
		ability.setHeader(Integer.valueOf(scrapDetailString(attributesColumn2, 8)));
		ability.setDefensiveProwness(Integer.valueOf(scrapDetailString(attributesColumn2, 9)));
		ability.setBallWinning(Integer.valueOf(scrapDetailString(attributesColumn2, 10)));
		ability.setKickingPower(Integer.valueOf(scrapDetailString(attributesColumn2, 11)));
		ability.setSpeed(Integer.valueOf(scrapDetailString(attributesColumn2, 12)));
		ability.setExplosivePower(Integer.valueOf(scrapDetailString(attributesColumn2, 13)));
		ability.setUnwaveringBalance(Integer.valueOf(scrapDetailString(attributesColumn2, 14)));
		ability.setPhysicalContact(Integer.valueOf(scrapDetailString(attributesColumn3, 0)));
		ability.setJump(Integer.valueOf(scrapDetailString(attributesColumn3, 1)));
		ability.setGoalkeeping(Integer.valueOf(scrapDetailString(attributesColumn3, 2)));
		ability.setGkcatch(Integer.valueOf(scrapDetailString(attributesColumn3, 3)));
		ability.setClearing(Integer.valueOf(scrapDetailString(attributesColumn3, 4)));
		ability.setReflexes(Integer.valueOf(scrapDetailString(attributesColumn3, 5)));
		ability.setCoverage(Integer.valueOf(scrapDetailString(attributesColumn3, 6)));
		ability.setStamina(Integer.valueOf(scrapDetailString(attributesColumn3, 7)));
		ability.setWeakFootUsage(Integer.valueOf(scrapDetailString(attributesColumn3, 8)));
		ability.setWeakFootAccuracy(Integer.valueOf(scrapDetailString(attributesColumn3, 9)));
		ability.setForm(Integer.valueOf(scrapDetailString(attributesColumn3, 10)));
		ability.setInjuryResistance(Integer.valueOf(scrapDetailString(attributesColumn3, 11)));
		ability.setRating(Integer.valueOf(scrapDetailString(attributesColumn3, 13)));

		return playerService.saveAbility(ability);
	}
	
	public List<Scout> scrapScouts(Integer pesdbId,Scrapper scrapper) {
		//scrapper.setPage("?id=" + pesdbId);
		Player player = playerService.findPlayerByPesdbId(pesdbId);
		
		if(player!=null) {
			List<Scout> scoutList = new ArrayList<Scout>();
			
			HtmlTable scoutTable = scrapper.getTable("//table[@class='scouts']");
			List<HtmlTableRow> scoutRows = scoutTable.getRows();		
			for(HtmlTableRow scoutRow:scoutRows) {
				String rowClass = scoutRow.getAttribute("class");
				if(rowClass!=null && rowClass.equals("scout_row")) {
					String ballLevel = scoutRow.getCell(0).asText().replace("*","");
					String scout1 = scoutRow.getCell(1).asText();
					String scout2 = scoutRow.getCell(2).asText();
					String scout3 = scoutRow.getCell(3).asText();
					String chance = scoutRow.getCell(4).asText().replace("%", "");
					
					Scout scout = new Scout();
					scout.setPlayer(player);
					scout.setChance(Integer.valueOf(chance));
					scout.setLevel(Integer.valueOf(ballLevel));
					scout.setScout1(scout1);
					scout.setScout2(scout2);
					scout.setScout3(scout3);
					
					scoutList.add(scoutService.addScout(scout));
				}
			}
			return scoutList;
		}
		return null;
	}
	
	private String scrapDetailString(HtmlTableCell tableCell, Integer row) {
		return scrapDetailString(tableCell,row,true);
	}
	
	private String scrapDetailString(HtmlTableCell tableCell, Integer row, Boolean hasLabelBefore) {

		HtmlTable internalTable = (HtmlTable) tableCell.getFirstElementChild();		
		HtmlTableRow squatNumberRow = internalTable.getRows().get(row);
		
		List<HtmlTableCell> squatNumberRowCells = squatNumberRow.getCells();
		if(hasLabelBefore)
			return squatNumberRowCells.get(SECOND_COLUMN).asText();
		else
			return squatNumberRowCells.get(FIRST_COLUMN).asText();

	}
}
