package com.vivarium.model;


import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Animal extends Organism {
	protected float health;
	protected float hunger;
	protected float vitality;
	protected float speed;
	protected ArrayList<AreaType> difficultArea;
	protected AreaType currArea;
	protected Sex type;

	public Animal(int posX, int posY, Vivarium v, float health, float hunger, float vitality, float speed, Sex type, ArrayList<AreaType> avArea, ArrayList<AreaType> dfArea) {
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


	/**
	 * Vérification de la valeur de d"HP (ne peut pas être négative)
	 */
	public void setHP(float hp) {
		if (hp < 0) {
			this.health = 0.0f;
		} else {
			this.health = hp;
		}
	}

	public float getHP() {
		return this.health;
	}


	/**
	 * Vérification de la valeur de d'hunger (ne peut pas être négative)
	 */
	public void setHunger(float hunger) {
		if (this.hunger < 0) {
			this.hunger = 0.0f;
		} else {
			this.hunger = hunger;
		}
	}

	public float getHunger() {
		return this.hunger;
	}

	public void setVitality(float vitality) {
		this.vitality = vitality;
	}

	public float getVitality() {
		return this.vitality;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getSpeed() {
		AreaType area = this.getCurrentAreaType();
		if (difficultArea.contains(area)) return this.speed / 2;
		else if (!availaibleArea.contains(area)) return this.speed / 8;
		return this.speed;
	}

	public void setType(Sex type) {
		this.type = type;
	}

	public Sex getType() {
		return this.type;
	}

	/*** /ACCESSEURS ***/

	/*** Deplacement ***/

	public void move(double dx, double dy) {
		if (this.getPos().getX() >= this.vivarium.getTerrain().getWidth() && dx > 0) {
			this.getPos().setX(-dx + getPos().getX());
			//evite la sortie de l'organisme a droite
		}
		else if (this.getPos().getX() <= 0 && dx < 0) {
			this.getPos().setX(-dx + getPos().getX());
			//evite la sortie de l'organisme a gauche
		}
		else this.getPos().setX(dx + getPos().getX()); // déplacment normal suivant x

		if (this.getPos().getY() >= this.vivarium.getTerrain().getWidth() && dy > 0) {
			this.getPos().setY(-dy + getPos().getY());
			//evite la sortie de l'organisme en bas
		}
		else if (this.getPos().getY() <= 0 && dy < 0) {
			this.getPos().setY(-dy + getPos().getY());
			//evite la sortie de l'rganisme en haut
		}

		else this.getPos().setY(dy + getPos().getY()); //deplacement normal sur y
		this.currArea = getCurrentAreaType();
	}


		/*** /Deplacement ***/

	}
