package ru.tsconsulting.internship;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeGroup {
    private int currentIndex;
    private Map<Integer,Employee> employeeMap = new HashMap<>();
    private String departamentName;


    public EmployeeGroup(Collection<Employee> employeeForAdding){
        employeeForAdding.stream().findFirst().ifPresent(employee -> this.setDepartamentName(employee.getDepartament()));
        employeeForAdding.stream().forEach(this::addEmployee);
    }

    public Employee[] getAsArray(){
        return employeeMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .toArray(Employee[]::new);
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

    public String getDepartamentName() {
        return departamentName;
    }

    public double getAverageSalary(){
        return employeeMap.values().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }


    public Stream<EmployeeGroup> makeAllCombinations(){
//        Employee[] arrayOfEmployee = getAsArray();
//        Collection<EmployeeGroup> result = new ArrayList<>(); //1<<arrayOfEmployee.length
//
//        recursionFunctoin(result,arrayOfEmployee,new Employee[arrayOfEmployee.length-4],0,0);
//
//        return result;
        List<EmployeeGroup> result = new ArrayList<>();
        recurse(result,new ArrayList<>(),getAsArray(),0);
        return result.stream();
    }

    private static void recurse(List<EmployeeGroup> charLists, List<Employee> temp, Employee[] employees , int index) {

        if(index<employees.length){

            List<Employee> temp2 = new ArrayList<>(temp);
            temp2.add(employees[index]);

            charLists.add(new EmployeeGroup(temp2));

            recurse(charLists,temp2,employees,index+1);
            recurse(charLists,temp,employees,index+1);

        }

    }















    private void recursionFunctoin(Collection<EmployeeGroup> result,Employee[] input,Employee[] temp,int inputIndex,int tempIndex){
        //System.out.printf("Вызов функции recursionFunctoin с (%d, %d)%n",inputIndex,tempIndex);

        if(tempIndex==temp.length) {
            System.out.println(Arrays.toString(temp));
            result.add(new EmployeeGroup(Arrays.asList(input)));
            return;
        }
        for(int i =inputIndex; i<input.length;i++){
            temp[tempIndex] = input[i];
            recursionFunctoin(result,input,temp,i+1,tempIndex+1);
        }
    }

    @Override
    public String toString() {
        return employeeMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(Employee::getFIO).collect(Collectors.joining(",\n"));
    }
}
