package com.company;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import java.util.ArrayList;

/**
 * Created by Ckhan on 19-3-2018.
 */
public class Cage {
    private int placeNr;
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    /**
     * Returns an Lion object that can make sound
     *
     * @param  place  cage nr
     * @return      instance of an cage
     * @see         Cage
     */
    public Cage(int place){
        this.placeNr = place;
    }

    // returns cage number
    public int getCageNr(){
        return this.placeNr;
    }

    /**
     * Puts and instance of an Animal object in the Array list
     *
     * @param  animal animal object
     * @throws   DuplicateNameException
     *
     */
    public void putAnimal(Animal animal) throws DuplicateNameException{
        if(!duplicatedAnimal(animal.getName())) {
            animals.add(animal);
        }
    }

    /**
     * gets and instance of an Animal object in the Array list by name
     *
     * @param  name name of the needed animal
     *
     */
    public Animal getAnimal(String name){
        Animal foundAnimal = null;
        for (Animal animal: animals) {
            if(animal.getName().equals(name)){
                foundAnimal = animal;
            }
        }
        return foundAnimal;
    }

    /**
     * Checks for duplicated named animals
     *
     * @param  name on which duplicated name we are searching for.
     * @return    boolean True = found, False = not found
     *
     */
    public boolean duplicatedAnimal(String name){
        boolean animalExists = false;
        for (Animal animal : animals) {
            if(animal.getName().equals(name)){
                animalExists = true;
            }
        }
        return animalExists;
    }

    /**
     * Returns amount of the animals listed in te array per Animal keeper
     *
     * @return    amount of animals taken care of
     *
     */
    public int getTotalAnimal(){
        int total = 0;
        for(int i = 0; i <= animals.size(); i++){
            total++;
        }
        return total;
    }


    /**
     * Removes the animal from the array list of the Animal keeper
     *not done!
     * @param name    name of the animal which will be removed
     *
     */
    public void removeAnimal(String name){
        Animal foundAnimal = getAnimal(name);
        if(animals.contains(foundAnimal)){
           animals.remove(foundAnimal);
        }
    }

    @Override
    public String toString() {
        return "Cage{" +
                "placeNr = " + placeNr +
                '}';
    }
}
