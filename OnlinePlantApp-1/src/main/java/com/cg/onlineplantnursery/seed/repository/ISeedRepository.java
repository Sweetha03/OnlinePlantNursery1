package com.cg.onlineplantnursery.seed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.seed.entity.Seed;

@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer> {

	List<Seed> getPlantByTypeOfSeeds(String typeOfSeeds);

	List<Seed> getSeedByCommonName(String commonName);

}
