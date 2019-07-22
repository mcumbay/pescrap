package com.dfwcomputech.scrap.common;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggerUtil {
	private static final Logger logger = LogManager.getLogger();
	
	public static void printPlayerList(List<Player> results) {
		if (results != null && !results.isEmpty()) {
			logger.info("=========================================");
			for (Player player : results)
				logger.info("{} - {} - {}", player.getPesdbId(), player.getName(), player.getNationality());
			logger.info("=========================================");
		} else
			logger.info("No results found");
	}
	
	public static void printPlayerDetail(PlayerDetail detail) {
		if(detail!=null) {
			ObjectMapper mapper = new ObjectMapper();  
			try {
				logger.info("{}", mapper.writeValueAsString(detail));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else
			logger.info("No Player found");
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
