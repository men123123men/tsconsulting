package ru.tsconsulting.internship;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private int id;
    private String firstName;
    private String secondName;
    private String thirdNames;
    private String departament;
    private double salary;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getThirdNames() {
        return thirdNames;
    }

    public String getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }

    public String getFIO(){
        return String.format("%s %s %s",firstName,secondName,thirdNames);
    }



    public Employee(int id,String firstName, String secondName, String thirdNames, String departament, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdNames = thirdNames;
        this.departament = departament;
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee o) {
        return Integer.compare(id,o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return String.format("%s %s %s работает в отделе %s и получает %.0f\u20BD",firstName,secondName,thirdNames,departament,salary);
    }

}
