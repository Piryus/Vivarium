package com.vivarium.model;

import java.util.ArrayList;

abstract class Carnivore extends Animal
{

	public Carnivore(int posX, int posY, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> availableArea)
	{
		super(posX,posY,health,hunger,vitality,speed,type,availableArea);
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
	abstract public void evoluate(long dt);
}