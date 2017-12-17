
package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Wolf extends Carnivore {

    //private ArrayList<AreaType> suitableAreas = new ArrayList<>();
    //private AreaType currentArea;

    public Wolf(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 1, 0, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert,AreaType.Water})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Desert})));
        currArea = AreaType.Plain;
    }

    private int coefX = 1, coefY = 1; // pour debug

    public boolean isHungry()
    {
        return getHunger()>=5;
    }

    public Animal hunt(Carnivore c)
    {
        return super.lookForFood(c);
    }

    public Animal findMate(Carnivore c) { return super.lookForMate(c);}

    public void lookForFood()
    {
        Animal prey = hunt(this);
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

    public void lookForMate()
    {
        Animal mate = findMate(this);
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

    @Override
    public void evoluate(long dt)
    {
        this.move(dt*getSpeed()*coefX,dt*getSpeed()*coefY);

        if(isHungry())
        {
            lookForFood();
        }
        else
        {
            lookForMate();
        }
        if(this.currArea.equals(AreaType.Water))
        {
            if(this.health >0)
            {
                this.setHP(this.health-0.005f );
                //System.out.println("Wooooooolf on the waaaaater ...");
            }
            else
            {

                //System.out.println("Dead Wooooooolf on the waaaaater ...");
            }
        }
        this.setHunger(this.hunger+0.005f);
    }

}