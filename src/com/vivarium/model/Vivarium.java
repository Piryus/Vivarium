package com.vivarium.model;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.abs;

/**
 * 
 */
public class Vivarium {

    private ArrayList<Organism> organisms;
    private Terrain terrain;
    /**
     * Default constructor
     */
    public Vivarium() {
        organisms = new ArrayList<>();
        terrain = new Terrain();
    }

    /**
     * @param o
     */
    public void add(Organism o) {
        organisms.add(o);
    }

    /**
     * @param o
     */
    public void delete(Organism o) {
        organisms.remove(o);
    }

    /**
     * @return
     */
    public Terrain getTerrain() {
        return terrain;
    }

    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }


    /***
     * Je récupère tous les animaux (pas tous les organismes)
     */
    public ArrayList<Animal> getAnimals()
    {
        ArrayList<Animal> ret = new ArrayList<>();
        for (Organism o: getOrganisms())
        {
            if(o instanceof Animal)
            {
                ret.add((Animal)o);
            }
        }
        return ret;
    }

    /**
     * renvoie l'organisme qui est à la position X,Y
     * Rq : peut renvoyer null, faire attention
     * */
    public Organism getOrganismAtPos(double posX, double posY)
    {
        for(Organism o :getOrganisms())
        {
            //if(o.getPos().getX() == posX && o.getPos().getY() == posY)
            if (abs(o.getPos().getX() - posX) <= o.getSize() && abs(o.getPos().getY() - posY) <= o.getSize())
            {
                return o;
            }
        }
        return null;
    }

    /**
     * On récupère la cible la plus proche de prédator
     * */
    public Animal getCloserPrey(ArrayList<Animal> preys, Animal predator)
    {
        Animal prey = null;
        Coordinates rep = new Coordinates(1000000,100000);
        ArrayList<Animal> catchablePreys = new ArrayList<>();

        for (Animal a:preys)
        {
            if(a.getSpeed() <= predator.getSpeed())
            {
                // Attrapable
                catchablePreys.add(a);
            }
        }

        // On recherche la cible la plus proche
        for(Animal a:catchablePreys)
        {
            if(predator.getPos().isCloser(a.getPos(),rep))
            {
                rep = a.getPos();
            }
        }

        prey = (Animal)getOrganismAtPos(rep.getX(),rep.getY());
        return prey;

    }


    /**
     * Récupère une proie pour l'animal source
     * */
    public Animal scanForPrey(Carnivore predator) throws NullPointerException
    {
        Animal prey = null;
        try
        {
            ArrayList<Animal> preys = new ArrayList<>();
            for (Animal a: getAnimals())
            {
                if (a instanceof Herbivore)
                {
                    preys.add(a);
                }
            }

            prey = getCloserPrey(preys,predator);

        }
        catch (NullPointerException e)
        {
            System.out.println("Attention, aucune proie trouvée ! "+e.getMessage());
        }
        return prey;
    }


    /**
     * Scanne la zone pour trouver un partenaire (le premier qu'il trouve)
     * Peut renvoyer null, faire attention
     * */
    public Animal scanOtherGender(Animal src)
    {
        Animal other = null;
        ArrayList<Animal> mates = new ArrayList<>();

        for (Animal a: getAnimals())
        {
            if(a.getClass().equals(src.getClass()))
            {
                if(!a.getType().toString().equals(src.getType().toString()))
                {
                    mates.add(a);
                }
            }
        }

        Coordinates rep = new Coordinates(100000,100000);

        for (Animal mate: mates)
        {
            if(src.getPos().isCloser(mate.getPos(),rep))
            {
                rep = mate.getPos();
            }
        }

        other = (Animal) getOrganismAtPos(rep.getX(),rep.getY());
        return other;
    }


    /**
     * Scan les environs d'un Organism quelconque, à la recheche d'autre Organism et renvoie la list des organism de
     * cette classe
     * */
    public  ArrayList<Organism> scan (Organism src, char a){
        ArrayList<Organism> dispo= new ArrayList<>();
        try {
            if (a == 'h') {
                for (Animal an: getAnimals()) {
                    if (an instanceof Herbivore) {
                        dispo.add(an);

                    }
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Attention, aucun herbivore trouvé ! "+e.getMessage());
        }
        try {
            if (a == 'c') {
                for (Animal an: getAnimals()) {
                    if (an instanceof Carnivore) {
                        dispo.add(an);

                    }
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Attention, aucun carnivore trouvé ! "+e.getMessage());
        }
        try {
            if (a == 'v') {
                for (int j = 0; j < (getOrganisms().size()); j++) {
                    if (getOrganisms().get(j) instanceof Vegetal) {
                        dispo.add(getOrganisms().get(j));

                    }
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Attention, aucun vegetal trouvé ! "+e.getMessage());
        }

        return dispo;
    }



    /** *renvoie l'organisme de type a  (h pour herbivore, v pour vegetal, c pour carnivore)  le plus proche de
    * l'organisme src
     **/
    public  Organism getCloser (Organism src, char a) {
        ArrayList<Organism> dispo = scan(src,a);
        Organism o= null;
        if (dispo.size()==0) return null ;
        o = dispo.get(0);
        for (int i = 1; i < dispo.size(); i++) {
            if (src.getPos().isCloser(dispo.get(i).getPos(), o.getPos())) {
                o = dispo.get(i);
            }
        }

        return o;
    }
}