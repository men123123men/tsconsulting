package ru.tsconsulting.internship;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws Exception {

        EmploteeTextFileEntyParser emploteeTextFileEntyParser = new EmploteeTextFileEntyParser();

        EmployeesFilePath myEmployeesFilePath = getEmployeesFilePath(emploteeTextFileEntyParser, args[0],50);

        Set<Employee> employeeSet = myEmployeesFilePath.loadAllEmployees(emploteeTextFileEntyParser);

        //firstSolution(employeeSet);

        secondSolution(employeeSet);


    }

    private static EmployeesFilePath getEmployeesFilePath(EmploteeTextFileEntyParser emploteeTextFileEntyParser, String employeesFilePathStr, int countOfEmployeesInDefaultFile) {
        Path employeesFilePath = getPathFromStr(employeesFilePathStr);

        EmployeesFilePath myEmployeesFilePath = new EmployeesFilePath(employeesFilePath);

        if(Objects.isNull(employeesFilePathStr))
            myEmployeesFilePath.fillFileByRandomEmployee(countOfEmployeesInDefaultFile, EmploteeTextFileEntySupplier.getGenerator(), emploteeTextFileEntyParser);

        System.out.println(myEmployeesFilePath.getPathAsString());

        myEmployeesFilePath.soutContent();
        return myEmployeesFilePath;
    }

    private static Path getPathFromStr(String employeesFilePathStr) {
        Path result = null;
        if(Objects.nonNull(employeesFilePathStr))
            try {
                return Paths.get(employeesFilePathStr);
            } catch (Exception e) {
                System.err.println("Пришел не правильный путь к файлу, поэтому будем брать дефолтный");
            }

        try {
            URL employeesURL = Main.class.getResource("employees.txt");
            return Paths.get(employeesURL.toURI());
        } catch (Exception e) {
            System.err.println("С дефолтным тоже какая-то беда приключилась");
        }
        throw new RuntimeException("Все очень плохо с файлом на диске");
    }

    private static void firstSolution(Set<Employee> employeeSet){

        Map<String,Double> averageSalaryOfDepartaments =  employeeSet.stream()
                .collect(Collectors.groupingBy(Employee::getDepartament,Collectors.averagingDouble(Employee::getSalary)));

        averageSalaryOfDepartaments.entrySet().stream()
                .map(e->String.format("%-10s %.2f \u20BD",e.getKey(),e.getValue()))
                .forEach(System.out::println);

        DepartmentMigration departmentMigration = new DepartmentMigration(averageSalaryOfDepartaments);

        employeeSet.stream()
                .filter(departmentMigration::canLeaveItsOunDepartment)
                .flatMap(departmentMigration::getAllPossibleTransitions)
                .forEach(System.out::println);

    }

    private static void secondSolution(Set<Employee> employeeSet) {
        Map<String, EmployeeGroup> employeeGroups =  employeeSet.stream()
                .collect(Collectors.groupingBy(Employee::getDepartament,Collectors.collectingAndThen(Collectors.toSet(),EmployeeGroup::new)));

        Map<String,Double> averageSalaryOfDepartaments = employeeGroups.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,entry->entry.getValue().getAverageSalary()));

        DepartmentMigration departmentMigration = new DepartmentMigration(averageSalaryOfDepartaments);

        employeeGroups.forEach((departamentName, enployeeGroup)-> System.out.printf("%-10s %7.2f \u20BD кол-во работников: %4d%n",departamentName,enployeeGroup.getAverageSalary(),enployeeGroup.getSize()));

        employeeGroups.entrySet().stream().map(Map.Entry::getValue).flatMap(EmployeeGroup::makeAllCombinations)
                .filter(departmentMigration::canLeaveItsOunDepartment)
                .flatMap(departmentMigration::getAllPossibleTransitions)
                .forEach(System.out::println);

    }
    private static EmployeesFilePath createAndFillEmployeesFile(EmploteeTextFileEntyParser parser, int employeeCount){
        URL employeesURL = Main.class.getResource("employees.txt");
        Path employeesPath = null;
        try {
            employeesPath = Paths.get(employeesURL.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        EmployeesFilePath employeesFilePath = new EmployeesFilePath(employeesPath);

        employeesFilePath.fillFileByRandomEmployee(employeeCount, EmploteeTextFileEntySupplier.getGenerator(),parser);

        return employeesFilePath;
    }
}
