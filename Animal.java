package com.company;

/**
 * Created by Ckhan on 19-3-2018.
 */
public class Animal {
    private String name;
    private String type;
    private int birthYear;
    private int cageNr;

    /**
     * Returns an Lion object that can make sound
     *
     * @param  name  name of the animal
     * @param  type  type of the animal
     * @param birthYear birth year of the animal
     * @return      instance of an Animal
     * @see         Animal
     */
    public Animal(String name, String type, int birthYear){
        this.name = name;
        this.type = type;
        this.birthYear = birthYear;
    }

    // returns name
    public String getName() {
        return name;
    }

    // returns type
    public String getType() {
        return type;
    }

   // return birth year
    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name = " + name + '\'' +
                ", type = " + type + '\'' +
                ", birthYear = " + birthYear +
                ", cage number = " + this.cageNr +
                '}';
    }
}
