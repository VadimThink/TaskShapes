package edu.epam.quadrangle.data.observer;

public interface Observer<T> {
    void update(T observable);
}