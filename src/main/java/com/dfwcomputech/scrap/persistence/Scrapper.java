package com.dfwcomputech.scrap.persistence;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.common.PescrapConstants;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

@Repository
public class Scrapper {
	private static final Logger logger = LogManager.getLogger(Scrapper.class);
	@Autowired
	private WebClient client;
	
	private HtmlPage page;
	
	public HtmlPage setPage(String urn) {
		logger.debug("Scrapper: Setting Page...=>"+urn);
		System.out.println("Scrapper: Setting Page...=>"+urn);
		try {
			this.page = this.client.getPage(PescrapConstants.pesURL+urn); 
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}			
	}
	
	public HtmlTable getTable(String xpath) {
		//Return the first table founded
		List<HtmlTable> results = this.page.getByXPath(xpath);
		if(results!=null)
			return results.get(0);
		return null;
	}

	
}
