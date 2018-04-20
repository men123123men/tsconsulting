package ru.tsconsulting.internship;

import java.util.*;

public class EmployeeGroup {
    private int currentIndex;
    private Map<Integer,Employee> employeeMap = new HashMap<>();
    private String departamentName;

    public EmployeeGroup(Collection<Employee> employeeForAdding){
        employeeForAdding.stream().findFirst().ifPresent(employee -> this.setDepartamentName(employee.getDepartament()));
        employeeForAdding.stream().forEach(this::addEmployee);
    }

    public void addEmployee(Employee employeeForAdding){
       employeeMap.put(++currentIndex,employeeForAdding);
    }


    public void removeEmployee(Employee employeeForRemoving){
        Optional<Integer> index = getIndexOfEmployeeInGroup(employeeForRemoving);
        index.ifPresent(this::removeEmployee);
    }

    public Optional<Integer> getIndexOfEmployeeInGroup(Employee employeeForResearch){
        return employeeMap.entrySet().stream()
                .filter(entry->entry.getValue().equals(employeeForResearch))
                .map(Map.Entry::getKey).findFirst();
    }

    public void removeEmployee(int indexOfEmployeeInGroup){
        employeeMap.remove(indexOfEmployeeInGroup);
    }

    public int getSize(){
        return employeeMap.size();
    }

    public void setDepartamentName(String newDepartamentName){
        departamentName = newDepartamentName;
    }

    public double getAverageSalary(){
        return employeeMap.values().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }


    public Collection<EmployeeGroup> makeAllCombinations(){
        employeeMap.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).toArray();




        return new ArrayList<>();
    }




}
