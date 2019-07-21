package com.dfwcomputech.scrap.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.persistence.domain.Position;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PositionRepositoryTest {

	@Autowired
	private PositionRepository positionRepository;
	
	@Test
	//@Rollback(false)
	public void whenSave_thenPrint() {
		Position position = new Position(); 
		
		position.setId(0);
		position.setCode("GK");
		position.setDescription("Goalkeeper");
		
		positionRepository.save(position);
		
	}
	
	
}
