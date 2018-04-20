package ru.tsconsulting.internship;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeesFilePath {
    private Path path;
    public EmployeesFilePath(Path pathname) {
        path = pathname;
    }
    public int fillFileByRandomEmployee( int countOfEntys, EmployeeGenerator generator, EmployeeParser employeeParser){
        if(countOfEntys<0)
            throw new IllegalArgumentException("Колличество записей в файле должно быть положительным!");

        Employee currentEmployee;
        String currentEmployeeStr;

        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            for(int i = 0;i<countOfEntys;i++) {
                currentEmployee = generator.get();
                currentEmployeeStr = employeeParser.makeString(currentEmployee);
                writer.write(currentEmployeeStr + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("При заполнение файла тестовыми данными что-то пошло не так\n");
            e.printStackTrace();
            return -1;
        }
        return countOfEntys;
    }

    public void soutContent(){
        try {
            Files.lines(path)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Не удалось считать содержимое файла по какой-то причине");
            e.printStackTrace();
        }
    }
    public Set<Employee> loadAllEmployees(EmployeeParser employeeParser){
        try {
            return Files.lines(path)
                    .map(employeeParser::parseString)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.err.println("При загрузки работников что-то пошло не так");
            e.printStackTrace();
            return Set.of();
        }
    }

    public String getPathAsString(){
        return path.toString();
    }


}
