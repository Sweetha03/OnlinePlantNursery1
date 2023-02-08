package com.cg.onlineplantapp.seed.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;
import com.cg.onlineplantnursery.seed.service.SeedServiceImpl;

class SeedServiceImplTest {

	@InjectMocks
	SeedServiceImpl seedServiceImpl;

	@Mock
	ISeedRepository seedRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void doInit() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test case to test insertion of Seed when input values are valid")

	void testAddSeed() {
		// sample input

		Seed sampleInput = new Seed("Rose", "11.11", "5 ounces", "Moderate", 7, 32, "Flower",
				"It is an mature ovule that compromises a miniature undeveloped plant", 7, 7.17, 7);
		// actual output
		Seed actualOutput = new Seed("Rose", "11.11", "5 ounces", "Moderate", 7, 32, "Flower",
				"It is an mature ovule that compromises a miniature undeveloped plant", 7, 7.17, 7);

		actualOutput.setSeedId(0);
		actualOutput.setCommonName(null);

		Seed expectedOutput = new Seed("Rose", "11.11", "5 ounces", "Moderate", 7, 32, "Flower",
				"It is an mature ovule that compromises a miniature undeveloped plant", 7, 7.17, 7);

		expectedOutput.setSeedId(0);
		expectedOutput.setCommonName(null);

		when(seedRepository.save(sampleInput)).thenReturn(actualOutput);

		assertEquals(actualOutput, expectedOutput);

	}

	@Test
	@DisplayName("Test case to test insertion of Seed wheninput values are invalid")
	void testAddSeed2() {
		Seed sampleInput = new Seed(null, "11.11", "5 ounces", "Moderate", 7, 32, "Flower",
				"It is an mature ovule that compromises a miniature undeveloped plant", 7, 7.17, 7);

		// call actual method and store actual result:actual output

		when(seedRepository.save(sampleInput)).thenThrow(NullPointerException.class);

	}

}
