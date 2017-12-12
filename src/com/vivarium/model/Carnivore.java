include Herbivore;
include Animal
class Carnivore extends Animal
{
	public Carnivore(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type)
	{
		super(posX,posY,health,hunger,vitality,speed,type);
	}

	public boolean eat(Herbivore other);
	public void evoluate(float deltaTime);
}