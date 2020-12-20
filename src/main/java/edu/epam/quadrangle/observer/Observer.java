package edu.epam.quadrangle.observer;

public interface Observer<T> {
    void update(T observable);
}