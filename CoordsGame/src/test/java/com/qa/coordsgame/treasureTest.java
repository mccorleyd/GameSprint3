package com.qa.coordsgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class treasureTest {
	treasure treasureTest;

	@BeforeEach
	void setUp() throws Exception {
		treasureTest = new treasure();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testingSound() {
		String actualSound = treasureTest.output();
		Assertions.assertEquals(null,actualSound);
	}

	@Test
	void testingGetPosition() {
		int[] testPos = new int[2];
		boolean flag = false;
		testPos = treasureTest.getPosition();
		if (testPos[0] == 0 && testPos[1] == 0) {
			flag = false;
		}
		else {
			flag = true;
		}
		Assertions.assertTrue(flag);
	}
	
	@Test
	void testingUpdatePosition() {
		int[] exPos = new int[2];
		exPos[0] = 10;
		exPos[1] = 10;
		int[] actPos = new int[2];
		treasureTest.updatePosition(exPos);
		actPos = treasureTest.getPosition();
		Assertions.assertArrayEquals(exPos,actPos);
		
	}

}
