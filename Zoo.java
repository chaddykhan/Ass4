package com.company;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import javax.naming.NameNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

/**
 * Created by Ckhan on 19-3-2018.
 */
public class Zoo {
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static Scanner sc = new Scanner(System.in);

    private static void printMenu(){
        System.out.println("\n-------------------");
        System.out.println("Make your choice!");
        System.out.println("1 - Add Animal Keeper. " +
                "2 - Assign Assistant To Animal Keeper" +
                "3 - Add Animal. " +
                "4 - Remove Animal. " +
                "5 - Show employees. " +
                "6 - Find Animal by name. " +
                "0 - Exit. ");
    }

    public static void main(String[] args) {
        new Zoo().menuController();
    }

    private void menuController(){
        Scanner sc = new Scanner(System.in);
        int userInput = 1;
        while(userInput != 0) {
            printMenu();
            userInput = sc.nextInt();
            switch (userInput) {
                case 1:
                    addAnimalKeeper();
                    break;
                case 2:
                    addAssToAK();
                    break;
                case 3:
                    addAnimal();
                    break;
                case 4:
                    removeAnimal();
                    break;
                case 5:
                    getEmployeeList();
                    break;
                case 6:
                    getAnimalByName();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.out.println("Suddenly wiled animals appeared");
                    System.out.println("Take out your AnimalDEX to investigate them! \n Press 1 fast!");
                    try{
                        int aDexInput = sc.nextInt();
                        System.out.println("Keypressed");
                        if(aDexInput == 1){
                            wildAnimalsApper();
                        }
                        else{
                            throw new IOException();
                        }
                    }catch (IOException io){
                        System.out.println("PFF! you lost them told you Press 1.... maybe next time, \nGoodLuck!");
                        System.out.println("PowerOff!");
                        exit(1);
                    }
                    break;
                default:
                    System.out.println("Something wrong happend! ");
                    break;
            }
        }
    }

    private  void addAnimalKeeper(){
        AnimalKeeper newAnimalKeeper;
        Cage cage;
        try{
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Hours: ");
            int hours = sc.nextInt();

            newAnimalKeeper = new AnimalKeeper(name, hours);

            System.out.println("Do you want to assign a cage to the new animal keeper? - Y/N");
            String userDes = sc.next();
            int cageNumber = 0;

            if(userDes.toUpperCase().equalsIgnoreCase("Y")){
                System.out.println("CageNumber: ");
                cageNumber = sc.nextInt();
                newAnimalKeeper.setCage(cage = new Cage(cageNumber));
                System.out.println("Animal Keeper added with cage nr = " + cageNumber);
            }

            for (Employee checkEmployee : employees) {
                if(checkEmployee instanceof AnimalKeeper){
                    if(((AnimalKeeper) checkEmployee).getCage().getCageNr() == cageNumber){
                        throw new DuplicateNameException();
                    }
                    if(checkEmployee.getName().equals(newAnimalKeeper.getName())){
                        throw new DuplicateNameException();
                    }
                }
            }
            employees.add(newAnimalKeeper);
        }catch (DuplicateNameException dne){
            dne.getMessage();
        }catch (InputMismatchException ime){
            System.out.println("Wrong input");
        }
    }

    private Assistant addAssistant(){
        Assistant newAssistant = null;

        try{
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Hours: ");
            int hours = sc.nextInt();
            System.out.println("takesCareOf: ");
            String takesCareOf = sc.next();

            newAssistant = new Assistant(name, hours, takesCareOf );
            for (Employee checkEmployee : employees) {
                if(checkEmployee instanceof Assistant){
                    if(checkEmployee.getName().equals(newAssistant.getName())){
                        throw new DuplicateNameException();
                    }
                }
            }
            System.out.println("Assistant added");
        }catch (DuplicateNameException dne){
            dne.getMessage();
        }catch (InputMismatchException ime){
            System.out.println("Wrong input");
        }
        return newAssistant;
    }

    private void addAssToAK(){
        try{
            Assistant assistant;
            System.out.println("Too which Animal keeper?");
            String aniKeepName = sc.next();
            for(Employee eAniKeeper : employees ){
                if(eAniKeeper instanceof AnimalKeeper){
                    if(eAniKeeper.getName().equalsIgnoreCase(aniKeepName)){
                        ((AnimalKeeper) eAniKeeper).setAssistant(addAssistant());
                    }
                }else{
                    System.out.println("None Animal keepers found");
                }
            }
        }
        catch(InputMismatchException ime){
            System.out.println("");
        }
    }

    private void addAnimal(){
        Cage cage;

        try {
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Type: ");
            String type = sc.next();
            System.out.println("birthYear: ");
            int birthYear = sc.nextInt();
            System.out.println("Cage number: ");
            int cageNumber = sc.nextInt();

            if(!employees.isEmpty()) {
                for (Employee e : employees) {
                    if (e instanceof AnimalKeeper) {
                        cage = ((AnimalKeeper) e).getCage();
                        if (cage.getCageNr() == cageNumber) {
                            cage.putAnimal(new Animal(name, type, birthYear));
                            System.out.println("Animal added!");
                        }else{
                            System.out.println("No cage found hire more Animal keepers too expand your cage capacity :)");
                        }
                    }
                }
            }else{
                System.out.println("Hire some Animal keepers dude!");
            }
        }catch (DuplicateNameException dne){
            dne.getMessage();
        }catch (InputMismatchException ime){
            System.out.println("Wrong input");
        }
    }

    private void getAnimalByName(){
        Animal animal = null;
        Cage cage;

        try{
            System.out.println("Animal by name: ");
            String animalName = sc.next();

            try {
                for (Employee e: employees
                     ) {
                    if(e instanceof AnimalKeeper){
                        cage = ((AnimalKeeper) e).getCage();
                        animal = cage.getAnimal(animalName);
                        System.out.println(animal.toString() + "Cage nr: " + cage.getCageNr());
                    }
                }
            }catch (NullPointerException npe){
                System.out.println("Animal not found!");
            }
        }catch (InputMismatchException ime){
            ime.getMessage();
        }
    }

    private static void getEmployeeList() {
        if (!employees.isEmpty()){
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
        else{
            System.out.println("No employees found!");
        }

    }

    private void removeAnimal(){
        try{
            System.out.println("Animal by name: ");
            String animalName = sc.next();

            try {
                System.out.println("Animal deleted!");
            }catch (NullPointerException npe){
                System.out.println("Animal not found!");
            }
        }catch (InputMismatchException ime){
            ime.getMessage();
        }
    }

    //Assignment 5

    public void wildAnimalsApper(){
        ArrayList<Animal> newAppAn = new ArrayList<>();
        newAppAn.add(new Lion("Ustra", "Lion", 2018));
        newAppAn.add(new Dog("Acem", "Dog", 2014));
        newAppAn.add(new Ape("KINGKONG", "Ape", 2017));

        for (Animal animal : newAppAn) {
            if(animal instanceof Dog)
                System.out.println(animal.getName() + ((Dog) animal).makeSound() + animal.getType());
            if(animal instanceof Lion)
                System.out.println(animal.getName() + ((Lion) animal).makeSound() + animal.getType());
            if(animal instanceof Ape)
                System.out.println(animal.getName() + ((Ape) animal).makeSound() + animal.getType());
        }
    }

}

