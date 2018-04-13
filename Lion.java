package com.company;

public class Lion extends Animal implements Sound{

    /**
     * Returns an Lion object that can make sound
     *
     * @param  name  name of the animal
     * @param  type  type of the animal
     * @return      instance of an animal of the type lion
     * @see         Lion
     */
    public Lion(String name, String type, int birthYear){
        super(name, type, birthYear);
    }

    @Override
    public String makeSound() {
        return " Says: RAWRRRRR.RAAAAWWRRR. It's type = ";
    }
}