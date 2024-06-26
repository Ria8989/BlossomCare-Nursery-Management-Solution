package com.spe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spe.Entity.Planter;
import com.spe.Exception.PlanterException;

@Repository
public interface PlanterRepository extends JpaRepository<Planter, Integer>{

	public List<Planter> findByPlanterShape(String planterShape) throws PlanterException;
	
	public List<Planter> findByPlanterCostBetween(Double startCost, Double endCost) throws PlanterException;
	
}
