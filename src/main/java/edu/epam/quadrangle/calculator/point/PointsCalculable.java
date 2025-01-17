package edu.epam.quadrangle.calculator.point;

import edu.epam.quadrangle.entity.Point;

public interface PointsCalculable {
    double calculateDistancePoints(Point firstPoint, Point secondPoint);
    boolean isCollinearPoints(Point firstPoint, Point secondPoint, Point thirdPoint);
}