package ru.tsconsulting.internship;

import java.util.Random;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNullElse;

public class EmployeeGenerator implements Supplier<Employee> {
    private static EmployeeGenerator instance;
    private EmployeeGenerator(){ }
    private int counter;

    private Random rand = new Random();
    private String[] firstNames = {"Николаев","Сидоров","Петров","Иванов","Козлов"};
    private String[] secondNames = {"Альберт","Алексей","Владимир","Глеб","Давид","Ефим","Захар",
            "Игорь", "Кирилл", "Николай","Владислав","Арсений", "Мирон","Евгений"};
    private String[] thirdNames = {"Петрович","Никитович","Андреевич","Анатольевич","Борисович",
            "Степанович","Тимофеевич","Федотович","Харитонович","Юрьевич","Ярославович","Якубович"};
    private String[] departaments = {"IT","PR","HR","Маркетинг","Закупок"};

    @Override
    public Employee get() {

        int firstNumber = rand.nextInt(firstNames.length);
        int secondNumber = rand.nextInt(secondNames.length);
        int thirdNumber = rand.nextInt(thirdNames.length);
        int departamentNumber = rand.nextInt(departaments.length);
        double selery = (rand.nextDouble()+1)*40_000;

        return new Employee(++counter,firstNames[firstNumber],secondNames[secondNumber],
                thirdNames[thirdNumber],departaments[departamentNumber],selery);
    }
    public static EmployeeGenerator getGenerator(){
        return requireNonNullElse(instance,new EmployeeGenerator());
    }
}
