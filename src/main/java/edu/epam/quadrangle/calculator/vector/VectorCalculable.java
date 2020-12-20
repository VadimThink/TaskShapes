package edu.epam.quadrangle.calculator.vector;

import edu.epam.quadrangle.entity.MathVector;

public interface VectorCalculable {
    double calculateAngle(MathVector firstVector, MathVector secondVector);
    double calculateScalarProduct(MathVector firstVector, MathVector secondVector);
    double calculateVectorLength(MathVector vector);
}
