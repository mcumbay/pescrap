package com.dfwcomputech.scrap;

import java.util.ArrayList;
import java.util.List;

import com.dfwcomputech.scrap.common.PesFilter;
import com.dfwcomputech.scrap.domain.PesPlayer;
import com.dfwcomputech.scrap.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebScrapperApplication {

	public static void main(String[] args ) {
		
		System.out.println("Test");
		SearchService searchService = new SearchService();
		
		List<PesPlayer> results = searchService.search(getFilters());
		
		ObjectMapper mapper = new ObjectMapper();
		
		if(results==null)
			System.out.println("No Players found");
		else
			results.forEach(pesPlayer -> {try {
				System.out.println(mapper.writeValueAsString(pesPlayer));
			} catch (Exception e) {
				e.printStackTrace();
			}});
	}
	
	private static List<PesFilter> getFilters(){
		List<PesFilter> filters = new ArrayList<PesFilter>();		
		PesFilter filter;
		
		//Looking for a fast Gem?
		filter= new PesFilter("speed", "90-99");
		filters.add(filter);
		filter= new PesFilter("explosive_power", "80-99");
		filters.add(filter);
		filter= new PesFilter("form", "6-8");
		filters.add(filter);
		filter= new PesFilter("overall_rating", "40-79");
		filters.add(filter);
		
		return filters;
	}
}
