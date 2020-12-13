package edu.epam.quadrangle.factory;

import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

import java.util.List;

public class QuadrangleFactory{

    public Quadrangle create(List<Point> points, int id) {
        Quadrangle quadrangle = new Quadrangle(points, id);
        return quadrangle;
    }

}
