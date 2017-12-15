package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public class Eagle extends Carnivore
{

    private int coefX = 1, coefY = 1; // pour debug
    public Eagle(int posX,int posY,Vivarium v, Sex type) {

        super(posX, posY, v, 50, 0, 0.05f, 0.10f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Mountain, AreaType.Plain, AreaType.Desert,AreaType.Water})),
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Desert})));
        currArea = AreaType.Mountain;
    }

    public boolean isHungry()
    {
        return getHunger()>=5;
    }

    public void lookForFood()
    {
        Animal prey = this.vivarium.scanForPrey(this  );
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
        Animal mate = this.vivarium.scanOtherGender(this);
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
    }

}