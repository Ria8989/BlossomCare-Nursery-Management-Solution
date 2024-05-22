package com.spe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spe.Entity.*;

public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByToken(String token);
}
