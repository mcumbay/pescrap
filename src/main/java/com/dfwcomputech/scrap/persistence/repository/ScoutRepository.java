package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Combination;

@Repository
public interface ScoutRepository extends JpaRepository<Combination, Integer>{

}
