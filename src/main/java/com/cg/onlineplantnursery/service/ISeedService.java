package com.cg.onlineplantnursery.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.cg.onlineplantnursery.entity.Seed;

@Service
public interface ISeedService {

	public Seed addSeed(Seed seed) ;

	public Seed updateSeed(int seedId) throws SeedIdNotFoundException;

	public Seed deleteSeed(Seed seed) throws SeedIdNotFoundException;

	public Seed viewSeed(int seedId) throws SeedIdNotFoundException;

	public List<Seed> getSeedByCommonName(String commonName) throws SeedIdNotFoundException;

	public List<Seed> getAllSeeds() throws SeedIdNotFoundException;

	public List<Seed> getPlantByTypeOfSeeds(String typeOfSeeds) throws SeedIdNotFoundException;

}
