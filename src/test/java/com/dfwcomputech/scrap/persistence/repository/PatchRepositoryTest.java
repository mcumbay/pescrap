package com.dfwcomputech.scrap.persistence.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.persistence.domain.Patch;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PatchRepositoryTest {
	
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	private PatchRepository patchRepository;
		
	@Test
	public void whenFindingLatestVersion_thenCorrect() {		
		Patch currentPes = patchRepository.findLatestPatch();
		if(currentPes!=null) {
			logger.info("==================================================");
			logger.info("	YEAR       = {}", currentPes.getPesYear());
			logger.info("	DATAPACK   = {}", currentPes.getDataPack());
			logger.info("	VERSION    = {}", currentPes.getVersion());
			logger.info("	SUBVERSION = {}", currentPes.getSubversion());
			logger.info("==================================================");
		}

	}
	
}
