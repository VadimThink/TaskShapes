package edu.epam.quadrangle.data.calculator.vector;

import edu.epam.quadrangle.entity.Vector;

public interface VectorCalculable {
    double calculateAngle(Vector firstVector, Vector secondVector);
    double calculateScalarProduct(Vector firstVector, Vector secondVector);
    double calculateVectorLength(Vector vector);
}
