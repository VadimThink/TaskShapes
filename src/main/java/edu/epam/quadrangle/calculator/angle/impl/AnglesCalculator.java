package edu.epam.quadrangle.calculator.angle.impl;

import edu.epam.quadrangle.calculator.angle.AnglesCalculable;
import edu.epam.quadrangle.calculator.vector.VectorCalculable;
import edu.epam.quadrangle.calculator.vector.impl.VectorCalculator;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.MathVector;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class AnglesCalculator implements AnglesCalculable {
    private static final double RIGHT_ANGLE = 90.0;
    private static final int AMOUNT_QUADRANGLE_POINTS = 4;

    @Override
    public boolean isAnglesRight(List<Double> angles) {
        for (Double angle : angles) {
            if (!angle.equals(RIGHT_ANGLE)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Double> calculateAngles(Quadrangle quadrangle) {
        VectorCalculable vectorCalculator = new VectorCalculator();
        Point firstPoint;
        Point secondPoint;
        Point thirdPoint;
        List<Double> angles = new ArrayList<>();
        for (int i = 0; i < AMOUNT_QUADRANGLE_POINTS; i++) {
            firstPoint = quadrangle.getPoint(i == 0 ? AMOUNT_QUADRANGLE_POINTS - 1 : i - 1);
            secondPoint = quadrangle.getPoint(i % AMOUNT_QUADRANGLE_POINTS);
            thirdPoint = quadrangle.getPoint((i + 1) % AMOUNT_QUADRANGLE_POINTS);
            double newAngle = vectorCalculator.calculateAngle(new MathVector(firstPoint, secondPoint),
                    new MathVector(secondPoint, thirdPoint));
            angles.add(newAngle);
        }
        return angles;
    }
}

