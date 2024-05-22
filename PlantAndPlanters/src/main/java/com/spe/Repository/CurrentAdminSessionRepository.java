package com.spe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spe.Entity.CurrentAdminSession;

public interface CurrentAdminSessionRepository extends JpaRepository<CurrentAdminSession, Integer> {

	public CurrentAdminSession findByToken(String token);
}
