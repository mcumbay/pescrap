package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Scout;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, Integer>{

}
