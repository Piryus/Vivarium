package com.vivarium.model;

/**
 * 
 */
public class Trex extends Carnivore {

    private AreaType area;
    public Trex(int posX,int posY,float health, float hunger, float vitality,float speed, Sex type,AreaType a)
    {
        super(posX,posY,health,hunger,vitality,speed,type);
        this.area = a;
    }

    @Override
    void setArea(AreaType a) {

    }


    @Override
    public void evoluate(long dt) {

    }

}