package ru.tsconsulting.internship;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tester {
    public static void main(String[] args) {
        int[] arr = IntStream.rangeClosed(1,3).toArray();

        genCombinations (arr, 0);

        List<Integer> list = IntStream.rangeClosed(1,3).boxed().collect(Collectors.toList());
        Set<List<Integer>> result = new HashSet<>();




    }
    public static void genCombinations (int[] arr , int curPos){

        if (arr.length == curPos)
            soutArray(arr);

        else{
            arr [curPos] = 0;   System.out.printf("Выставили %d на позиции %d%n",arr[curPos],curPos+1);
            genCombinations (arr , curPos+1);


            arr [curPos] = 1;    System.out.printf("Выставили %d на позиции %d%n",arr[curPos],curPos+1);
            genCombinations (arr  , curPos+1);
        }
    }











    public static void soutArray(int[] array){
        Arrays.stream(array).forEach(System.out::print);
        System.out.println("\n---");
    }





}
