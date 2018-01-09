package com.vivarium.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 */
public abstract class Fish extends Herbivore {

    private int coefX, coefY;

    /**
     * Default constructor
     */
    public Fish(int posX,int posY,Vivarium v, Sex type) {
        super(posX, posY, v, 100, 42, 0.05f, 0.05f, type,
                new ArrayList<>(Arrays.asList(new AreaType[]{AreaType.Water})),
                new ArrayList<>(Arrays.asList(new AreaType[]{})));
        currArea = AreaType.Water;
        coefX = -1;
        coefY = -1;
    }

    /**
     * Permet au poisson de bouger
     * @param dt
     */
    public void move(long dt){
        AreaType a = getAreaType( new Coordinates(this.getPos().getX()+dt * 2*getSpeed() * coefX, this.getPos().getY()) );
        if (a != AreaType.Water){
            coefX*= -1;
            System.out.println(a);
        }
        a = getAreaType( new Coordinates(this.getPos().getX(), this.getPos().getY()+dt * 2*getSpeed() * coefY));
        if ( a != AreaType.Water){
            coefY*= -1;
            System.out.println(a);
        }
        move(dt * getSpeed() * coefX, dt * getSpeed() * coefY);
    }

    /**
     * permet de déterminer dans quelle Area se situe une coordonnée. Utilisé pour empêcher que les Fish sortent de l'eau
     * @param c
     * @return
     */
    private AreaType getAreaType(Coordinates c) {
        AreaType CurrentAreaType = AreaType.Water;
        for(int i=0;i<vivarium.getTerrain().getAreasList().size();i++) {
            if((c.getX()>vivarium.getTerrain().getAreasList().get(i).getCoords().getX()&&c.getX()<=vivarium.getTerrain().getAreasList().get(i).getCoords().getX()+80)&&
                    (this.getPos().getY()>vivarium.getTerrain().getAreasList().get(i).getCoords().getY()&&c.getY()<=vivarium.getTerrain().getAreasList().get(i).getCoords().getY()+80)) {
                CurrentAreaType = vivarium.getTerrain().getAreasList().get(i).getAreaType();
                break;
            }
        }
        return CurrentAreaType;
    }

}