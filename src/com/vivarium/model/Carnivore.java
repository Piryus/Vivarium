package com.vivarium.model;

import java.util.ArrayList;

abstract class Carnivore extends Animal
{

	public Carnivore(int posX, int posY, Vivarium v, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> availableArea, ArrayList<AreaType> dfArea)
	{
		super(posX,posY,v,health,hunger,vitality,speed,type,availableArea, dfArea);
	}

	boolean eat(Herbivore other)
	{
		if(this.speed > other.speed)
		{
			other.setHP(0);
			return  true;
		}
		return false;
	}

	public Animal lookForFood(Carnivore predator)
	{
		Animal prey = this.vivarium.scanForPrey(predator);
		return prey;
	}

	public Animal lookForMate(Carnivore c)
	{
		Animal mate = this.vivarium.scanOtherGender(c);
		return mate;
	}

	abstract public void evoluate(long dt);
}