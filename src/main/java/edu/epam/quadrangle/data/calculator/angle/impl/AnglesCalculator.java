package edu.epam.quadrangle.data.calculator.angle.impl;

import edu.epam.quadrangle.data.calculator.angle.AnglesCalculable;
import edu.epam.quadrangle.data.calculator.vector.VectorCalculable;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.Vector;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

import java.util.ArrayList;
import java.util.List;

public class AnglesCalculator implements AnglesCalculable {
    private static final double RIGHT_ANGLE = 90.0;
    private static final int AMOUNT_QUADRANGLE_POINTS = 4;
    private final VectorCalculable vectorCalculator;

    public AnglesCalculator(VectorCalculable vectorCalculator) {
        this.vectorCalculator = vectorCalculator;
    }

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
        Point firstPoint;
        Point secondPoint;
        Point thirdPoint;
        List<Double> angles = new ArrayList<>();
        for (int i = 0; i < AMOUNT_QUADRANGLE_POINTS; i++) {
            firstPoint = quadrangle.getPoint(i == 0 ? AMOUNT_QUADRANGLE_POINTS - 1 : i - 1);
            secondPoint = quadrangle.getPoint(i % AMOUNT_QUADRANGLE_POINTS);
            thirdPoint = quadrangle.getPoint((i + 1) % AMOUNT_QUADRANGLE_POINTS);
            double newAngle = vectorCalculator.calculateAngle(new Vector(firstPoint, secondPoint),
                    new Vector(secondPoint, thirdPoint));
            angles.add(newAngle);
        }
        return angles;
    }
}

