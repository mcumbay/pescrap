package com.dfwcomputech.scrap.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggerUtil {
	private static final Logger logger = LogManager.getLogger();
	
	public static void print(List<Object> results) {
		if (results != null && !results.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			logger.info("=========================================");
			for (Object entity : results)
				try {
					logger.info("{}", mapper.writeValueAsString(entity));
				} catch (JsonProcessingException e) {					
					e.printStackTrace();
				}
			logger.info("=========================================");
		} else
			logger.info("No results found");
	}
	
	public static void print(Object entity) {
		if(entity!=null) {
			ObjectMapper mapper = new ObjectMapper();  
			try {
				logger.info("{}", mapper.writeValueAsString(entity));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else
			logger.info("No Entity found");
		}	
}
