package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exception.SeedIdNotFoundException;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class SeedServiceImpl implements ISeedService {

	@Autowired
	private ISeedRepository seedRepo;

	@Override
	@Transactional
	public Seed addSeed(Seed seed) {
		
		Seed addSeed = seedRepo.save(seed);
		return addSeed;
	}

	@Override
	@Transactional
	public Seed updateSeed(int seedId) throws SeedIdNotFoundException {

		Seed updatedSeed = seedRepo.getReferenceById(seedId);
		seedRepo.save(updatedSeed);
		return updatedSeed;

	}

	@Override
	@Transactional
	public Seed deleteSeed(Seed seed) throws SeedIdNotFoundException {

		Optional<Seed> obj = seedRepo.findById(seed.getSeedId());
		if (obj.isPresent()) {
			seedRepo.delete(seed);
			return seed;
		} else {
			throw new SeedIdNotFoundException("This Seed is not present");
		}
	}

	@Override
	public Seed viewSeed(int seedId) throws SeedIdNotFoundException {

		Optional<Seed> viewSeed = seedRepo.findById(seedId);
		if (viewSeed.isPresent()) {
			return viewSeed.get();
		} else {
			throw new SeedIdNotFoundException("No Seed id found");
		}
	}

	@Override
	public List<Seed> getAllSeeds() throws SeedIdNotFoundException {

		List<Seed> seeds = seedRepo.findAll();
		if (seeds.size() > 0) {

			return seeds;
		} else {
			throw new SeedIdNotFoundException("Seed details are empty");
		}
	}

	@Override
	public List<Seed> getSeedByCommonName(String commonName) throws SeedIdNotFoundException {

		List<Seed> obj1 = seedRepo.getSeedByCommonName(commonName);
		System.out.println(obj1);

		if (obj1.size() > 0) {
			System.out.println(obj1);
			return obj1;
		} else {
			throw new SeedIdNotFoundException("Seed with the given common name is not present");

		}
	}

	@Override
	public List<Seed> getPlantByTypeOfSeeds(String typeOfSeeds) throws SeedIdNotFoundException {

		List<Seed> obj2 = seedRepo.getPlantByTypeOfSeeds(typeOfSeeds);
		System.out.println(obj2);

		if (obj2.size() > 0) {
			System.out.println(obj2);
			return obj2;
		} else {
			throw new SeedIdNotFoundException("Type of seed is not present");
		}
	}
}
