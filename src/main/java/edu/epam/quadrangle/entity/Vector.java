package edu.epam.quadrangle.entity;

public class Vector {
    private final double firstPoint;
    private final double secondPoint;

    public Vector(Point firstPoint, Point secondPoint) {
        double firstX = firstPoint.getX();
        double secondX = secondPoint.getX();
        this.firstPoint =  secondX - firstX;
        double firstY = firstPoint.getY();
        double secondY = secondPoint.getY();
        this.secondPoint = secondY - firstY;
    }

    public double getFirstPoint() {
        return firstPoint;
    }

    public double getSecondPoint() {
        return secondPoint;
    }
}