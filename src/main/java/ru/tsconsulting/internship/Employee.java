package ru.tsconsulting.internship;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private int id;

    private String FIO;
    private String departament;
    private double salary;

    public int getId() {
        return id;
    }

    public String getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }

    public String getFIO(){
        return FIO;
    }

    public Employee(int id, String FIO, String departament, double salary) {
        this.id = id;
        this.FIO = FIO;
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
        return String.format("%s работает в отделе %s и получает %.0f\u20BD",FIO,departament,salary);
    }

}
