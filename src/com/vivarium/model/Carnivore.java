package com.vivarium.model;

import java.util.ArrayList;

class Carnivore extends Animal
{


	private int coefX = 1, coefY = 1; // pour debug

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

	public void lookForFood(Carnivore predator)
	{
		Animal prey = this.vivarium.scanForPrey(predator);

		if(prey != null)
		{
			if(prey.getPos().getX()<this.getPos().getX())
			{
				coefX = -1;
			}
			else
			{
				coefX =1;
			}
			if(prey.getPos().getY()<this.getPos().getY())
			{
				coefY =-1;
			}
			else
			{
				coefY=1;
			}
			if(this.getPos().equals(prey.getPos()))
			{
				this.eat((Herbivore)prey);
				this.setHunger(this.hunger-5.0f);
			}
		}
		else
		{
			if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() ){
				coefX = -1;
			}
			else if (this.getPos().getX()-getSize()/2  <0){
				coefX = 1;
			}
			if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() ){
				coefY = -1;
			}
			else if (this.getPos().getY()-getSize()/2 <0){
				coefY = 1;
			}
		}

	}

	public void lookForMate(Carnivore c)
	{
		Animal mate = this.vivarium.scanOtherGender(c);

		if(mate != null)
		{
			if(mate.getPos().getX()<this.getPos().getX())
			{
				coefX = -1;
			}
			else
			{
				coefX =1;
			}
			if(mate.getPos().getY()<this.getPos().getY())
			{
				coefY =-1;
			}
			else
			{
				coefY=1;
			}

			// todo : accouplement
		}
		else
		{
			if (this.getPos().getX()+getSize()/2> vivarium.getTerrain().getWidth() )
			{
				coefX = -1;
			}
			else if (this.getPos().getX()-getSize()/2 <0)
			{
				coefX = 1;
			}
			if (this.getPos().getY()+getSize()/2> vivarium.getTerrain().getHeight() )
			{
				coefY = -1;
			}
			else if (this.getPos().getY()-getSize()/2<0)
			{
				coefY = 1;
			}
		}

	}


	public boolean isHungry()
	{
		return getHunger()>=5;
	}

	@Override
	public void evoluate(long dt)
	{
		AreaType area = this.getCurrentAreaType();
		if(!availaibleArea.contains(area)) setVitality(getVitality()-1*dt);
		this.move(dt*getSpeed()*coefX,dt*getSpeed()*coefY);

		if(isHungry())
		{
			lookForFood(this);
		}
		else
		{
			lookForMate(this);
		}
		this.setHunger(this.hunger+(0.005f * dt ));
	}

}