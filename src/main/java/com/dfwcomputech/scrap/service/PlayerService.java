package com.dfwcomputech.scrap.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.Scrapper;
import com.dfwcomputech.scrap.persistence.domain.Patch;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.repository.PatchRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerDetailRepository;
import com.dfwcomputech.scrap.persistence.repository.PlayerRepository;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class PlayerService {

	private static final Logger logger = LogManager.getLogger();
	@Autowired
	private Scrapper scrapper;
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerDetailRepository playerDetailRepository;
	@Autowired
	private PatchRepository patchRepository;

	public void save(Player player) {
		// Verify if there are player information
		if (player != null)
			// Verify if the Id was provided
			if (player.getPesdbId() != null)
				// Verify if the id already exist on DB
				if (!playerRepository.existsPlayerByPesdbId(player.getPesdbId()))
					playerRepository.save(player);
				else
					logger.info("Player with Pes DB Id= {} already exists.", player.getPesdbId());
	}

	public void saveDetail(PlayerDetail detail) {
		// Verify if there are detail information
		if (detail != null) {
			// Verify if PlayerId was provided
			if (detail.getId() != null && detail.getId().getPlayerId() != null) {
				// Verify if the detail already exists on DB
				Patch currentPatch = patchRepository.findLatestPatch();
				if (playerDetailRepository.exists(currentPatch.getId(), detail.getId().getPlayerId())) {
					detail.getId().setPatchId(currentPatch.getId());
					playerDetailRepository.save(detail);
				} else
					logger.info("Player Detail with[PatchId= {} PlayerId= {} ] already exists.", currentPatch.getId(),
							detail.getId().getPlayerId());
			}
		}
	}
	
	public PlayerDetail scrapPlayer(Integer pesdbId) {
		
		scrapper.setPage("?id="+pesdbId);
		HtmlTable table = scrapper.getTable("//table[@class='player']");
		List<HtmlTableRow> rows=table.getRows();
		
		
		PlayerDetail playerDetail = new PlayerDetail();
		//Getting Player Details
		HtmlTableRow detailsRow =rows.get(0);
		List<HtmlTableCell> cells = detailsRow.getCells();
		
		String squatNumberString =  scrapDetailString(cells,0,1);
		String teamName =scrapDetailString(cells,0,2);
		String league = scrapDetailString(cells,0,3);
		String height = scrapDetailString(cells,0,5);
		String weight = scrapDetailString(cells,0,6);
		String age = scrapDetailString(cells,0,7);
		String foot = scrapDetailString(cells,0,8);
		String currentCondition = scrapDetailString(cells,0,9);
		String preferedPosition = scrapDetailString(cells,0,10);
		String oprAtLevel30 = scrapDetailString(cells,2,13);
		
		playerDetail.setAge(Integer.valueOf(age));
		playerDetail.setOprAtLevel30(Integer.valueOf(oprAtLevel30));
		playerDetail.setTeam(teamName);
		playerDetail.setLeague(league);
		
		//Second Column Table for Player Details
		HtmlTableCell detailCell2 = cells.get(1);
		
		//Third Column Table for Player Details
		HtmlTableCell detailCell3 = cells.get(2);
		
		//Playing Style/Player Skills/ COM Playing Styles
		HtmlTableCell detailCell4 = cells.get(3);
		
		
		
		
		HtmlTableRow levelBarRow =rows.get(1);
		HtmlTableRow pictureSocialMediaRow =rows.get(2);
		HtmlTableRow ScoutsRow =rows.get(4);
		
		
		
//		player.setTeam(cells.get(2).asText());
//		player.setPosition(cells.get(0).asText());			
//		player.setHeight(Integer.valueOf(cells.get(4).asText()));
//		player.setWeight(Integer.valueOf(cells.get(5).asText()));
//		player.setAge(Integer.valueOf(cells.get(6).asText()));
//		player.setCondition(cells.get(cells.size()-2).asText().charAt(0));
//		player.setRating(Integer.valueOf(cells.get(cells.size()-1).asText()));
		
		return playerDetail;
	}
	
	
	private String scrapDetailString(List<HtmlTableCell> cells, Integer column, Integer row) {
		HtmlTableCell detailCell1 = cells.get(column);
		HtmlTable detailTable1 = (HtmlTable)detailCell1.getFirstChild();
		List<HtmlTableRow> detailrows1=detailTable1.getRows();
		//Detail Cell
		HtmlTableRow squatNumberRow = detailrows1.get(row);
		List<HtmlTableCell> squatNumberRowCells = squatNumberRow.getCells();
		return squatNumberRowCells.get(1).asText();
	}
}
