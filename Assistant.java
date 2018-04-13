package com.company;

/**
 * Created by Ckhan on 19-3-2018.
 */
public class Assistant extends Employee {
    private static int baseSalary = 1000;
    private static int hourWages = 10;
    private String takesCareOf;
    private int salary = 9;


    /**
     * Returns an Lion object that can make sound
     *
     * @param  name  name of the assistant
     * @param  hourWages  work hours
     * @param takesCareOf which animal to take care of
     * @return      instance of an employee of the type assistant
     * @see         Lion
     */
    public Assistant(String name, int hourWages, String takesCareOf) {
        super(name, hourWages);
        this.takesCareOf = takesCareOf;
    }

    /**
     * Returns an String object that has the value
     * of which animal the assistant takes care of
     *
     * @return      String see above
     */
    public String getTakesCareOf() {
        return takesCareOf;
    }

    /**
     * Assigns an animal name to the targeted assistant
     */
    public void setTakesCareOf(String takesCareOf) {
        this.takesCareOf = takesCareOf;
    }

    /**
     * Calculates total salary
     * @return total salary value
     */
    public int salary() {
        return this.salary = baseSalary + getHours() * hourWages;
    }

    @Override
    public String toString() {
        return "Assistant{" +
                "baseSalary = " + baseSalary +
                ", hourWages = " + hourWages +
                ", takesCareOf = " + takesCareOf + '\'' +
                ", salary = " + salary() +
                '}';
    }


}
