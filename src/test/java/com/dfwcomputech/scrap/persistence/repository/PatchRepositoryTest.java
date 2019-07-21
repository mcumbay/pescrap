package com.dfwcomputech.scrap.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.persistence.domain.Patch;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PatchRepositoryTest {
	
	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private PatchRepository patchRepository;
	
	//***********************************
	//Insert a new PES version here
	//Uncomment the Rollback annotation to persist
	//**********************************
	@Test
	//@Rollback(false)	
	public void whenFindingAllVersionsByYear_thenCorrect() {
		Patch pes = new Patch();		
		pes.setPesYear(2020);
		pes.setVersion(1);
		pes.setSubversion(0);
		
		entityManager.persist(pes);
		entityManager.flush();
		
		//When pesYear is 2020
		List<Patch> pesList =patchRepository.findByPesYear(pes.getPesYear());		
		//Then
		assertThat(pesList.get(0).getPesYear()).isEqualTo(pes.getPesYear());
	}
	
	@Test
	public void whenFindingLatestVersionByYear_thenCorrect() {
		Integer year =2019;
		Patch currentPes = patchRepository.findTopByPesYearOrderByVersionDescSubversionDesc(year);
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
