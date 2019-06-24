package com.dfwcomputech.scrap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.common.PesFilter;
import com.dfwcomputech.scrap.domain.PesPlayer;
import com.dfwcomputech.scrap.persistence.Scrapper;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class SearchService {
	
	@Autowired
	private Scrapper scrapper;
	
	public List<PesPlayer> search(List<PesFilter> filters){
		List<PesPlayer> results = new ArrayList<PesPlayer>();
		
		scrapper.setPage(getSearchUrn(filters));
		HtmlTable table = scrapper.getTable("//table[@class='players']");
		
		List<HtmlTableRow> rows=table.getRows();
		
		for(int i=1;rows.size()>i;i++) {
			HtmlTableRow row =rows.get(i);
			List<HtmlTableCell> cells = row.getCells();
			
			PesPlayer player = new PesPlayer();
			player.setPosition(cells.get(0).asText());
			player.setName(cells.get(1).asText());
			player.setTeam(cells.get(2).asText());
			player.setNationality(cells.get(3).asText());
			player.setHeight(Integer.valueOf(cells.get(4).asText()));
			player.setWeight(Integer.valueOf(cells.get(5).asText()));
			player.setAge(Integer.valueOf(cells.get(6).asText()));
			
			player.setCondition(cells.get(cells.size()-2).asText().charAt(0));
			player.setRating(Integer.valueOf(cells.get(cells.size()-1).asText()));

			results.add(player);	
		}
		
		return results;
	}
		
	private String getSearchUrn(List<PesFilter> filters) {
		String searchUrn="?";
		if(filters==null ||filters.isEmpty())
			return searchUrn;
		
		for(PesFilter filter:filters) {			
			searchUrn+=filter.getFilter()+"&&";			
		}
		return searchUrn;
	}
}
