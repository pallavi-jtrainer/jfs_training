package com.springpeople.projectx.inheritance;

public abstract class Animal {
	protected String animalType;
	
	public String getAnimalType() {
		return animalType;
	}
	
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	
	public abstract void displayData();
}
