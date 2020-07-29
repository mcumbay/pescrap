package com.dfwcomputech.scrap.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.common.PesFilter;
import com.dfwcomputech.scrap.persistence.Scrapper;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class SearchService {
	
	private static final Logger logger = LogManager.getLogger();
	@Autowired
	private Scrapper scrapper;
	
	@Autowired
	private PlayerService playerService;
	
	public List<Player> search(List<PesFilter> filters){
		List<Player> results = new ArrayList<Player>();
		
		scrapper.setPage(getSearchUrn(filters));
		HtmlTable table = scrapper.getTable("//table[@class='players']");
		
		List<HtmlTableRow> rows=table.getRows();
		
		for(int i=1;rows.size()>i;i++) {
			HtmlTableRow row =rows.get(i);
			List<HtmlTableCell> cells = row.getCells();
			
			Player player = new Player();
			
			HtmlAnchor href = (HtmlAnchor)cells.get(1).getFirstChild();
			player.setPesdbId(Integer.valueOf(href.getHrefAttribute().substring(6)));
			player.setName(cells.get(1).asText());
			results.add(player);
			//Saving the player on DB
			playerService.savePlayer(player);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		return results;
	}
		
	private String getSearchUrn(List<PesFilter> filters) {
		if(filters==null||filters.isEmpty())
			return "";
		String searchUrn="?";
		if(filters==null ||filters.isEmpty())
			return searchUrn;
		
		for(PesFilter filter:filters) {			
			searchUrn+=filter.getFilter()+"&&";			
		}
		return searchUrn;
	}
	
}
