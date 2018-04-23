package ru.tsconsulting.internship;


import java.util.ArrayList;
import java.util.List;

public class Combinations {

    // print all subsets of the characters in s
    public static void comb1(String s) { comb1("", s); }

    // print all subsets of the remaining elements, with given prefix
    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(             prefix,         s.substring(1));
        }
    }

    private static void comb3(char[] chars) {
        List<List<Character>> charLists = new ArrayList<>();
        List<Character> temp = new ArrayList<>();

        comb3(charLists,temp, chars,0);

        charLists.stream().map(String::valueOf).forEach(System.out::println);

    }

    private static void comb3(List<List<Character>> charLists,List<Character> temp, char[] chars ,int index) {

        if(index<chars.length){


            List<Character> temp2 = new ArrayList<>(temp);
            temp2.add(chars[index]);
            charLists.add(temp2);

            comb3(charLists,temp2,chars,index+1);
            comb3(charLists,temp,chars,index+1);

        }

    }
    private static <T> void comb3(List<List<T>> charLists,List<T> temp, T[] chars ,int index) {

        if(index<chars.length){

            List<T> temp2 = new ArrayList<>(temp);
            temp2.add(chars[index]);

            charLists.add(temp2);

            comb3(charLists,temp2,chars,index+1);
            comb3(charLists,temp,chars,index+1);

        }

    }




    // alternate implementation
    public static void comb2(String s) { comb2("", s); }
    private static void comb2(String prefix, String s) {
        System.out.println(prefix);
        for(char c: s.toCharArray())
            comb2(prefix + c, s.substring(s.indexOf(c)+ 1));
//        for (int i = 0; i < s.length(); i++)
//            comb2(prefix + s.charAt(i), s.substring(i + 1));
    }


    // read in N from command line, and print all subsets among N elements
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        int n = 3;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);


        comb3(elements.toCharArray());
        System.out.println();


        // using first implementation
        comb1(elements);
        System.out.println();

        // using second implementation
        comb2(elements);
        System.out.println();
    }


}

