package ru.tsconsulting.internship;

public class EmploteeTextFileEntyParser implements Parser<EmploteeTextFileEnty> {


    @Override
    public String makeString(EmploteeTextFileEnty instanse) {
        return String.format("%7d%15s%15s%15s%15s%10.2f",instanse.getId(),instanse.getFirstName(),instanse.getSecondName(),
                instanse.getThirdName(),instanse.getDepartament(),instanse.getSalary());
    }

    @Override
    public EmploteeTextFileEnty parseString(String stringForParse) {

        String[] texts = stringForParse.split("\\s+");

        int id = Integer.parseInt(texts[1]);
        String firstName = texts[2];
        String secondName = texts[3];
        String thirdNames = texts[4];
        String departament = texts[5];
        double salary = Double.parseDouble(texts[6].replace(",","."));
        return new EmploteeTextFileEnty(id,firstName,secondName,thirdNames,departament,salary);
    }













}
