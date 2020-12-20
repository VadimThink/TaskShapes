package edu.epam.quadrangle.calculator.point.impl;

import edu.epam.quadrangle.calculator.point.PointsCalculable;
import edu.epam.quadrangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointsCalculatorTest {
    private static final Point POINT = new Point(2,2);
    private static final Point FIRST_COLLINEAR_POINT = new Point(0,0);
    private static final Point SECOND_COLLINEAR_POINT = new Point(0,2);
    private static final Point THIRD_COLLINEAR_POINT = new Point(0,6);
    private static final double FIRST_SECOND_POINT_DISTANCE = 2;
    private static final double DELTA = 0.0001;
    PointsCalculable pointsCalculator = new PointsCalculator();

    @Test
    public void testCalculateDistancePointsShouldReturnZeroWhenPointsAreEquals() {
        double distance;
        distance = pointsCalculator.calculateDistancePoints(POINT, POINT);
        Assert.assertEquals(0.0, distance, DELTA);
    }

    @Test
    public void testCalculateDistancePointsShouldReturnPositiveDistanceWhenPointsAreNotEquals() {
        double distance;
        distance = pointsCalculator.calculateDistancePoints(FIRST_COLLINEAR_POINT, SECOND_COLLINEAR_POINT);
        Assert.assertEquals(FIRST_SECOND_POINT_DISTANCE, distance, DELTA);
    }

    @Test
    public void testIsCollinearPointsShouldReturnTrueWhenPointsAreCollinear() {
        boolean isCollinear;
        isCollinear = pointsCalculator.isCollinearPoints(FIRST_COLLINEAR_POINT, SECOND_COLLINEAR_POINT,
                THIRD_COLLINEAR_POINT);
        Assert.assertTrue(isCollinear);
    }

    @Test
    public void testIsCollinearPointsShouldReturnFalseWhenPointsAreNotCollinear() {
        boolean isCollinear;
        isCollinear = pointsCalculator.isCollinearPoints(FIRST_COLLINEAR_POINT, SECOND_COLLINEAR_POINT,
                POINT);
        Assert.assertFalse(isCollinear);
    }
}