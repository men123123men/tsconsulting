package ru.tsconsulting.internship;

public interface Parser<T> {
    String makeString(T instanse);
    T parseString(String stringForParse);
}
