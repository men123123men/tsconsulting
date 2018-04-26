package ru.tsconsulting.internship;

public class EmploteeTextFileEnty {
    private final int id;
    private final String firstName;
    private final String secondName;
    private final String thirdName;
    private final String departament;
    private final double salary;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public String getThirdName() {
        return thirdName;
    }

    public String getDepartament() {
        return departament;
    }

    public double getSalary() {
        return salary;
    }

    public EmploteeTextFileEnty(int id, String firstName, String secondName, String thirdName, String departament, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.departament = departament;
        this.salary = salary;
    }
}
