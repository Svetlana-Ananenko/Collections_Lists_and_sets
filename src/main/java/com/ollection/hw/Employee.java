package com.ollection.hw;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.hash;

public class Employee {
    private final String lastName;
    private final String firstName;


    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String setLastName(String lastName) {
        return this.lastName;
    }

    public String setFirstName(String firstName) {
        return this.firstName;
    }
       @Override
   public String toString() {
       System.out.print("Имя: " + this.firstName + ". Фамилия: " + this.lastName);
       return " ";
   }   @Override
   public int hashCode() {
       return hash( firstName, lastName);
   }   @Override
   public boolean equals(Object other) {
       if (other == this) {
           return true;
       }
       if (other == null || this.getClass() != other.getClass()) {
           return false;
       }
       Employee firstEmployees = (Employee) other;
       boolean employeesComparison = ((firstName.equals(firstEmployees.firstName))&&(lastName.equals(firstEmployees.lastName)));
       return employeesComparison;
   }





}
