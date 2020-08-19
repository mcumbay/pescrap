package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public User findByEmail(String email);
}
