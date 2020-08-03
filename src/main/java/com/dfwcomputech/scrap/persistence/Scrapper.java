package com.dfwcomputech.scrap.persistence;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dfwcomputech.scrap.common.PescrapConstants;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Scrapper {

	@Autowired
	private WebClient client;
	
	private String uri;
	
	private HtmlPage page;
	
	public HtmlPage setPage(String uri) {
		log.info("Scrapper: Requesting Uri={}",uri);
		if(Strings.isEmpty(this.uri)||!this.uri.contentEquals(uri)) {
			try {
				this.uri =uri;
				page = this.client.getPage(PescrapConstants.pesURL+this.uri); 
				return page;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return page;	
	}
	
	public HtmlTable getTable(String xpath) {
		//Return the first table founded
		List<HtmlTable> results = this.page.getByXPath(xpath);
		if(results!=null)
			return results.get(0);
		return null;
	}

	
}
