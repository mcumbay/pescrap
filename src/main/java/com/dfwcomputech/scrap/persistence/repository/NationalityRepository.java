package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Integer> {

	public Nationality findTopByName(String name);

	default Nationality findByNationalityName(String name) {
		return findTopByName(name);
	}
}
