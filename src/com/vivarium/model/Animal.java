package com.vivarium.model;


abstract class Animal extends Organism
{
	protected float health;
	protected float hunger;
	protected float vitality;
	protected float speed;
	protected Sex type;

	public Animal(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type)
	{
		super(posX,posY);
		this.health = health;
		this.hunger = hunger;
		this.vitality = vitality;
		this.speed = speed;
		this.type = type;
	}

	abstract public void evoluate(long deltaTime); // Fonction à redéfinir dans chaque classe fille pour définir le comportement de l'animal

	/*** ACCESSEURS ***/

	public void setHP(float hp)
	{
		this.health = hp;
	}
	public float getHP()
	{
		return this.health;
	}

	public void setHunger(float hunger)
	{
		this.hunger = hunger;
	}
	public float setHunger()
	{
		return this.hunger;
	}

	public void setVitality(float vitality)
	{
		this.vitality = vitality;
	}
	public float getVitality()
	{
		return this.vitality;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}
	public float getSpeed()
	{
		return this.speed;
	}

	public void setType(Sex type)
	{
		this.type =type;
	}
	public Sex getType()
	{
		return  this.type;
	}

	/*** /ACCESSEURS ***/

}