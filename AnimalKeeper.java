package com.company;

import java.lang.reflect.Array;

/**
 * Created by Ckhan on 19-3-2018.
 */
public class AnimalKeeper extends Employee {
    private static int baseSalary = 1500;
    private static int hourWages = 15;
    private int salary;
    private int nrAssistant = 0;
    private final int MAX_ASSISTANTS = 2;
    private Assistant[] assistants = new Assistant[MAX_ASSISTANTS];
    private Cage cage = null;

    public AnimalKeeper(String name, int hours){
        super(name, hours);
    }

    public void setCage(Cage cage){
        this.cage = cage;
    }

    public Cage getCage(){
        return this.cage;
    }

    public void setAssistant(Assistant newAssistant){
        for(int i = nrAssistant; i < assistants.length; i++){
            this.assistants[i] = newAssistant;
            this.nrAssistant += i;
        }

    }

    public int salary(){
        return this.salary = baseSalary + nrAssistant * 500 + cage.getTotalAnimal() * 50 + getHours() * hourWages;
    }

    @Override
    public String toString() {
        return "------------------\n" +
                "AnimalKeepers{" +
                "Name= " + this.getName() +
                ", baseSalary= " + baseSalary +
                ", hourWages= " + hourWages +
                ", assistants= " + Array.get(assistants, 0)+","+ Array.get(assistants, 1)+
                ", cage= " + cage.getCageNr() +
                ", salary" + salary() +
                '}';
    }
}
