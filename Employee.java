package com.company;

import java.lang.reflect.Array;

/**
 * Created by Ckhan on 19-3-2018.
 */
public abstract class Employee {
    private String name;
    private int hours;


    public Employee(String name, int hours){
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name ='" + this.getName() + '\'' +
                ", hours = " + this.getHours() +
                '}';
    }

    public abstract int salary();
}
