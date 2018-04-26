package ru.tsconsulting.internship;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class EmployeesFilePath {
    private Path path;
    public EmployeesFilePath(Path pathname) {
        path = pathname;
    }
    public int fillFileByRandomEmployee(int countOfEntys, EmploteeTextFileEntySupplier generator, EmploteeTextFileEntyParser emploteeTextFileEntyParser){
        if(countOfEntys<0)
            throw new IllegalArgumentException("Колличество записей в файле должно быть положительным!");

        EmploteeTextFileEnty currentEmployee;
        String currentEmployeeStr;

        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            for(int i = 0;i<countOfEntys;i++) {
                currentEmployee = generator.get();
                currentEmployeeStr = emploteeTextFileEntyParser.makeString(currentEmployee);
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
    public Set<Employee> loadAllEmployees(EmploteeTextFileEntyParser emploteeTextFileEntyParser){
//        try {
            return new HashSet<>();
//                    Files.lines(path)
//                    .map(emploteeTextFileEntyParser::parseString)
//                    .collect(Collectors.toSet());
//        } catch (IOException e) {
//            System.err.println("При загрузки работников что-то пошло не так");
//            e.printStackTrace();
//            return new HashSet<>();
//        }
    }

    public String getPathAsString(){
        return path.toString();
    }


}
