package com.qa.coordsgame;

import java.util.concurrent.ThreadLocalRandom;

public abstract class GameEntity {
	private int positionX, positionY;

	public GameEntity() {
		super();
		this.positionX = ThreadLocalRandom.current().nextInt(0, 20);
		this.positionY = ThreadLocalRandom.current().nextInt(0, 20);
	}
	
	public int[] getPosition() {
		int[] position = new int[2];
		position[0] = this.positionX;
		position[1] = this.positionY;
		// Array for X and Y position.
		return position;
	}
	
	public abstract String output();
	
	
	public void updatePosition(int[] newPosition) {
		this.positionX = newPosition[0];
		this.positionY = newPosition[1];
	}
	
}
