package edu.epam.quadrangle.data.calculator.vector.impl;

import edu.epam.quadrangle.data.calculator.vector.VectorCalculable;
import edu.epam.quadrangle.entity.Vector;

public class VectorCalculator implements VectorCalculable {
    @Override
    public double calculateAngle(Vector firstVector, Vector secondVector) {
        double scalarProduct = calculateScalarProduct(firstVector, secondVector);
        double firstVectorLength = calculateVectorLength(firstVector);
        double secondVectorLength = calculateVectorLength(secondVector);
        double cosAngle = scalarProduct / (firstVectorLength * secondVectorLength);
        double radians = Math.acos(cosAngle);
        return Math.toDegrees(radians);
    }

    @Override
    public double calculateScalarProduct(Vector firstVector, Vector secondVector) {
        double firstVectorPointOne = firstVector.getFirstPoint();
        double secondVectorPointOne = secondVector.getFirstPoint();
        double firstPointsProduct = firstVectorPointOne * secondVectorPointOne;
        double firstVectorPointTwo = firstVector.getSecondPoint();
        double secondVectorPointTwo = secondVector.getSecondPoint();
        double secondPointsProduct = firstVectorPointTwo * secondVectorPointTwo;
        return firstPointsProduct + secondPointsProduct;
    }

    @Override
    public double calculateVectorLength(Vector vector) {
        double firstPoint = vector.getFirstPoint();
        double secondPoint = vector.getSecondPoint();
        return Math.sqrt(firstPoint * firstPoint + secondPoint * secondPoint);
    }
}
