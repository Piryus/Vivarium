package com.vivarium.model;


import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class Animal extends Organism
{
	protected float health;
	protected float hunger;
	protected float vitality;
	protected float speed;
	protected ArrayList<AreaType> difficultArea;
	protected AreaType currArea;
	protected Sex type;

	public Animal(int posX,int posY, Vivarium v, float health, float hunger, float vitality,float speed, Sex type,ArrayList<AreaType> avArea, ArrayList<AreaType> dfArea)
	{
		super(posX, posY, v, avArea);
		this.health = health;
		this.hunger = hunger;
		this.vitality = vitality;
		this.speed = speed;
		this.type = type;
		difficultArea = dfArea;

	}

	abstract public void evoluate(long dt); // Fonction à redéfinir dans chaque classe fille pour définir le comportement de l'animal

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
	public float getHunger()
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
	public float getSpeed() // TODO décommenter ce code une fois que Terrain.getArea a été implémenté
	{
		/*
		AreaType area = vivarium.getTerrain().getArea(this).getAreaType();
		if ( difficultArea.contains(area)) return this.speed/2;
		else if (!availaibleArea.contains(area)) return 0;
		*/
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

	/*** Deplacement ***/

	public void move(double dx, double dy)
	{
		this.getPos().setX(dx+getPos().getX());
		this.getPos().setY(dy+getPos().getY());
	}


	/*** /Deplacement ***/

}