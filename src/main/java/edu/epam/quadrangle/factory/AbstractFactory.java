package edu.epam.quadrangle.factory;

import edu.epam.quadrangle.entity.Point;

import java.util.List;

public interface AbstractFactory<T> {
    T create(List<Point> points);
}
