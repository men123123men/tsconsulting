package ru.tsconsulting.internship;

import java.util.Map;
import java.util.stream.Stream;

public class DepartmentMigration {
    Map<String,Double> averageSalaryOfDepartaments;

    public DepartmentMigration(Map<String, Double> averageSalaryOfDepartaments) {
        this.averageSalaryOfDepartaments = averageSalaryOfDepartaments;
    }


    public boolean canLeaveItsOunDepartment(Employee employee){
        return employee.getSalary()<averageSalaryOfDepartaments.get(employee.getDepartament());
    }


    public boolean canLeaveItsOunDepartment(EmployeeGroup employeeGroup){
        return employeeGroup.getAverageSalary()<averageSalaryOfDepartaments.get(employeeGroup.getDepartamentName());
    }



    public Stream<String> getAllPossibleTransitions(Employee employee) {
        return averageSalaryOfDepartaments.entrySet().stream()
                .filter(e->e.getValue()<employee.getSalary())
                .map(e->String.format("%30s с зарплатой %.2f может перейти из %10s(%.2f) в %10s(%.2f)",
                        employee.getFIO(),employee.getSalary(),
                        employee.getDepartament(),averageSalaryOfDepartaments.get(employee.getDepartament()),
                        e.getKey(),e.getValue()));
    }

    public Stream<String> getAllPossibleTransitions(EmployeeGroup employeeGroup) {
        return averageSalaryOfDepartaments.entrySet().stream()
                .filter(e->e.getValue()<employeeGroup.getAverageSalary())
                .map(e->String.format("%30s со средней зарплатой %.2f могут перейти из %10s(%.2f) в %10s(%.2f)\n",
                        employeeGroup,
                        employeeGroup.getAverageSalary(),
                        employeeGroup.getDepartamentName(),averageSalaryOfDepartaments.get(employeeGroup.getDepartamentName()),
                        e.getKey(),e.getValue()));
    }



}
