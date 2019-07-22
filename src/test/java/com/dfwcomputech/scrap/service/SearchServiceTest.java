package com.dfwcomputech.scrap.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.common.LoggerUtil;
import com.dfwcomputech.scrap.common.PesFilter;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SearchServiceTest {

	@Autowired
	private SearchService searchService;
	
	
	@Test
	public void whenSearchPlayers_thenCorrect() {
		LoggerUtil.printPlayerList(searchService.search(getFilters()));
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
