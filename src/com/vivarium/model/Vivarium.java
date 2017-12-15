package com.vivarium.model;
import java.lang.reflect.Array;
import java.util.*;

/**
 * 
 */
public class Vivarium {

    private ArrayList<Organism> organisms;
    private Terrain terrain;
    private HashMap<Integer, Long> lastCall;
    private ArrayList<String> animalClasses = new ArrayList<>(Arrays.asList(new String[]{"class com.vivarium.model.Bear","class com.vivarium.model.Blowfish","class com.vivarium.model.Bouquetin","class com.vivarium.model.Camel","class com.vivarium.model.Cow","class com.vivarium.model.Dog","class com.vivarium.model.Dragon","class com.vivarium.model.Eagle","class com.vivarium.model.Fish","class com.vivarium.model.Fox","class com.vivarium.model.FreshwaterFish","class com.vivarium.model.Rabbit","class com.vivarium.model.Trex","class com.vivarium.model.Wolf"}));
    private ArrayList<String> herbivoreClasses = new ArrayList<>(Arrays.asList(new String[]{"class com.vivarium.model.Bouquetin","class com.vivarium.model.Camel","class com.vivarium.model.Cow","class com.vivarium.model.Rabbit"}));
    /**
     * Default constructor
     */
    public Vivarium() {
        organisms = new ArrayList<>();
        terrain = new Terrain();
        lastCall = new HashMap<>();
    }

    /**
     * 
     */
    /*
    public void loop() {
        long t;
        for (Organism o: organisms)
        {
            t = System.currentTimeMillis();
            o.evoluate(t-lastCall.get(o.getID()));
            lastCall.replace(o.getID(),t);
        }
    }
    */
    /**
     * @param o
     */
    public void add(Organism o) {
        organisms.add(o);
        lastCall.put(o.getID(),System.currentTimeMillis());
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
            if(animalClasses.contains(o.getClass().toString()))
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
            if(o.getPos().getX() == posX && o.getPos().getY() == posY)
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
                if(herbivoreClasses.contains(a.getClass().toString()))
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
     * Recherce la zone par source, pour trouver un partenaire (le premier qu'il trouve)
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
     * Scan les environs d'un Organism quelconque, à la recheche d'un autre Organism
     * */
    public  Organism scan (Organism src, char a){
        Organism o= null;
        ArrayList<Organism> dispo=null;
        if (a=='h')
        {
            for(int j=0;j<(getOrganisms().size()); j++)
            {
                if (getOrganisms().get(j) instanceof Herbivore)
                {
                    dispo.add(getOrganisms().get(j));

                }
            }
        }
        if (a=='c')
        {
            for(int j=0;j<(getOrganisms().size()); j++)
            {
                if (getOrganisms().get(j) instanceof Carnivore)
                {
                    dispo.add(getOrganisms().get(j));

                }
            }
        }
        if (a=='v')
        {
            for(int j=0;j<(getOrganisms().size()); j++)
            {
                if (getOrganisms().get(j) instanceof Vegetal)
                {
                    dispo.add(getOrganisms().get(j));

                }
            }
        }
        o=dispo.get(0);
        for (int i=1;i<dispo.size();i++)
        {
            if (src.getPos().isCloser(dispo.get(i).getPos(),o.getPos()))
            {
                o=dispo.get(i);
            }
        }

        return o;
    }

}