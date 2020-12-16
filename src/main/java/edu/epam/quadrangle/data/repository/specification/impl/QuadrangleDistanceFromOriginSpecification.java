package edu.epam.quadrangle.data.repository.specification.impl;

import edu.epam.quadrangle.data.calculator.vector.VectorCalculable;
import edu.epam.quadrangle.data.repository.specification.Specification;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.Vector;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

public class QuadrangleDistanceFromOriginSpecification implements Specification<Quadrangle> {
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private static final int THIRD_POINT_INDEX = 2;
    private static final int FOURTH_POINT_INDEX = 3;
    private static final Point origin = new Point(0,0 );
    private final double maxDistance;
    private final VectorCalculable vectorCalculator;

    public QuadrangleDistanceFromOriginSpecification(double maxDistance, VectorCalculable vectorCalculator) {
        this.maxDistance = maxDistance;
        this.vectorCalculator = vectorCalculator;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        Vector firstVector = new Vector(quadrangle.getPoint(FIRST_POINT_INDEX), origin);
        Vector secondVector = new Vector(quadrangle.getPoint(SECOND_POINT_INDEX), origin);
        Vector thirdVector = new Vector(quadrangle.getPoint(THIRD_POINT_INDEX), origin);
        Vector fourthVector = new Vector(quadrangle.getPoint(FOURTH_POINT_INDEX), origin);
        double distanceFirstSide = vectorCalculator.calculateVectorLength(firstVector);
        double distanceSecondSide = vectorCalculator.calculateVectorLength(secondVector);
        double distanceThirdSide = vectorCalculator.calculateVectorLength(thirdVector);
        double distanceFourthSide = vectorCalculator.calculateVectorLength(fourthVector);

        return Double.compare(distanceFirstSide, maxDistance) <= 0 &&
                Double.compare(distanceSecondSide, maxDistance) <= 0 &&
                Double.compare(distanceThirdSide, maxDistance) <= 0 &&
                Double.compare(distanceFourthSide, maxDistance) <= 0;
    }
}