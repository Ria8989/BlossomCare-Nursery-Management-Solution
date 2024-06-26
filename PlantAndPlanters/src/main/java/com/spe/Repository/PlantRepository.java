package com.spe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spe.Entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

	@Query("select p from Plant p where p.commonName=?1")
	public List<Plant> getByCommonName(String commonName);
	
	
	@Query("select p from Plant p where p.typeOfPlant=?1")
	public List<Plant> getByTypeOfPlant(String typeOfPlant);
}
