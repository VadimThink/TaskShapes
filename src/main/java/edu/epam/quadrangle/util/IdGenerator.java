package edu.epam.quadrangle.util;

public class IdGenerator {
    private int id = 0;

    public int getId() {
        return id++;
    }
}