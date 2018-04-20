package ru.tsconsulting.internship;

public class EmployeeParser implements Parser<Employee> {

//    static private Pattern employeePattren = Pattern.compile("\\s*(?<id>\\d+)\\s*|\\s*(?<firstName>\\w+)\\s*|\\s*(?<secondName>\\w+)\\s*|\\s*(?<thirdName>\\w+)\\s*|\\s*(?<departamentName>\\w+)\\s*|\\s*(?<selary>\\S+)\\s*");
//    @Override
//    public String makeString(Employee instanse) {
//        return String.format("%5d|%15s|%15s|%15s|%15s|%10.2f",instanse.getId(),instanse.getFirstName(),instanse.getSecondName(),
//                instanse.getThirdNames(),instanse.getDepartament(),instanse.getSalary());
//    }
//
//    @Override
//    public Employee parseString(String stringForParse) {
//        Matcher matcher = employeePattren.matcher(stringForParse);
//        int id = Integer.parseInt(matcher.group("id"));
//        String firstName = matcher.group("firstName");
//        String secondName = matcher.group("secondName");
//        String thirdNames = matcher.group("thirdName");
//        String departament = matcher.group("departamentName");
//        double salary = Double.parseDouble(matcher.group("selary"));
//        return new Employee(id,firstName,secondName,thirdNames,departament,salary);
//    }

    @Override
    public String makeString(Employee instanse) {
        return String.format("%7d%15s%15s%15s%15s%10.2f",instanse.getId(),instanse.getFirstName(),instanse.getSecondName(),
                instanse.getThirdNames(),instanse.getDepartament(),instanse.getSalary());
    }

    @Override
    public Employee parseString(String stringForParse) {

        String[] texts = stringForParse.split("\\s+");

        int id = Integer.parseInt(texts[1]);
        String firstName = texts[2];
        String secondName = texts[3];
        String thirdNames = texts[4];
        String departament = texts[5];
        double salary = Double.parseDouble(texts[6].replace(",","."));
        return new Employee(id,firstName,secondName,thirdNames,departament,salary);
    }













}
