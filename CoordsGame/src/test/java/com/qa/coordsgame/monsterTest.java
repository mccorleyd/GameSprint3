package com.qa.coordsgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class monsterTest {
	monster mTest;
	
	@BeforeEach
	void setUp() throws Exception {
		mTest = new monster();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testingSound() {
		String actualSound = mTest.output();
		Assertions.assertEquals("Roar!",actualSound);
	}
	
	@Test
	void testingGetPosition() {
		int[] testPos = new int[2];
		boolean flag = false;
		testPos = mTest.getPosition();
		System.out.println(testPos[0]+"-" + testPos[1]);
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
		mTest.updatePosition(exPos);
		actPos = mTest.getPosition();
		Assertions.assertArrayEquals(exPos,actPos);
		
	}

}
