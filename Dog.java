package com.company;

public class Dog extends Animal implements Sound{

    /**
     * Returns an Lion object that can make sound
     *
     * @param  name  name of the animal
     * @param  type  type of the animal
     * @return      instance of an animal of the type dog
     * @see         Dog
     */
    public Dog(String name, String type, int birthYear){
        super(name, type, birthYear);
    }

    @Override
    public String makeSound() {
        return " Says: Woef.WOef. It's type = ";
    }
}
