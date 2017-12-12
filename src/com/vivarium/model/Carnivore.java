package com.vivarium.model;

abstract class Carnivore extends Animal
{

	public Carnivore(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type)
	{
		super(posX,posY,health,hunger,vitality,speed,type);
	}

	boolean eat(Herbivore other)
	{
		if(this.speed > other.speed)
		{
			other.setHP(0);
			return  true;
		}
	}
	abstract public void evoluate(float deltaTime);
}