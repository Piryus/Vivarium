package com.vivarium.model;

public class OrganismFactory {
    //private static List<String> animalSpecies = Arrays.asList("Bear","Blowfish","Bouquetin","Camel","Cow","Dog","Dragon","Eagle","Fish","FreshwaterFish","Rabbit","Trex","Wolf");
    //private static List<String> vegetalSpecies = Arrays.asList("Aubergine","Cactus","Grass","Mushroom","Tree");

    public static Animal AnimalFactory(String specie, int x, int y, Vivarium v, Sex s) throws Exception{
        Animal a = null;
        switch(specie){
            case "Bear" : a = new Bear(x,y,v,s); break;
            case "Blowfish": a = new Blowfish(x,y,v,s); break;
            case "Bouquetin" : a = new Bouquetin(x,y,v,s); break;
            case "Camel" : a = new Camel(x,y,v,s); break;
            case "Cow" : a = new Cow(x,y,v,s); break;
            case "Dog" : a = new Dog(x,y,v,s); break;
            case "Dragon" : a = new Dragon(x,y,v,s); break;
            case "Eagle" : a = new Eagle(x,y,v,s); break;
            case "FreshwaterFish" : a = new FreshwaterFish(x,y,v,s); break;
            case "Rabbit" : a = new Rabbit(x,y,v,s); break;
            case "Trex" : a = new Trex(x,y,v,s); break;
            case "Wolf" : a = new Wolf(x,y,v,s); break;
            default: throw new Exception(specie +" is not an animal specie");
        }
        return a;
    }


    public static Vegetal VegetalFactory(String specie, int x, int y, Vivarium v) throws  Exception{
        Vegetal jocaste = null;
        switch (specie){
            case "Aubergine" : jocaste = new Aubergine(x,y,v); break;
            case "Cactus" : jocaste = new Cactus(x,y,v); break;
            case "Grass" : jocaste = new Grass(x,y,v); break;
            case "Mushroom" : jocaste = new Mushroom(x,y,v); break;
            case "Tree" : jocaste = new Tree(x,y,v); break;
            default: throw new Exception(specie +" is not a vegetal specie");
        }
        return jocaste;
    }
}
