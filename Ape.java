package com.company;

public class Ape extends Animal implements Sound{
    /**
     * Returns an Lion object that can make sound
     *
     * @param  name  name of the animal
     * @param  type  type of the animal
     * @return      instance of an animal of the type ape
     * @see         Ape
     */
    public Ape(String name, String type, int birthYear){
        super(name, type, birthYear);
    }

    @Override
    public String makeSound() {
        return " Says: Oeh'u.Oeh'uH!. It's type = ";
    }
}
