package edu.epam.quadrangle.calculator.vector.impl;

import edu.epam.quadrangle.calculator.vector.VectorCalculable;
import edu.epam.quadrangle.entity.MathVector;
import edu.epam.quadrangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VectorCalculatorTest {
    private static final Point FIRST_POINT = new Point(0,0);
    private static final Point SECOND_POINT = new Point(0,2);
    private static final Point THIRD_POINT = new Point(2,2);
    private static final Point FOURTH_POINT = new Point(2,0);
    private static final MathVector FIRST_VECTOR = new MathVector(FIRST_POINT, SECOND_POINT);
    private static final MathVector SECOND_VECTOR = new MathVector(SECOND_POINT, THIRD_POINT);
    private static final MathVector THIRD_VECTOR = new MathVector(THIRD_POINT, FOURTH_POINT);
    private static final double FIRST_VECTOR_LENGTH = 2.0;
    private static final double FIRST_THIRD_VECTOR_PRODUCT = -4.0;
    private static final double RIGHT_ANGLE = 90.0;
    private static final double STRAIGHT_ANGLE = 180.0;
    private static final double DELTA = 0.0001;
    private final VectorCalculable vectorCalculator = new VectorCalculator();

    @Test
    public void testCalculateAngleShouldReturnRightAngleWhenVectorsArePerpendicular() {
        double angle;
        angle = vectorCalculator.calculateAngle(FIRST_VECTOR, SECOND_VECTOR);
        Assert.assertEquals(RIGHT_ANGLE, angle, DELTA);
    }

    @Test
    public void testCalculateAngleShouldReturnStraightAngleWhenVectorsAreParallel() {
        double angle;
        angle = vectorCalculator.calculateAngle(FIRST_VECTOR, THIRD_VECTOR);
        Assert.assertEquals(STRAIGHT_ANGLE, angle, DELTA);
    }


    @Test
    public void testCalculateAngleShouldReturnZeroWhenVectorsAreEquals() {
        double angle;
        angle = vectorCalculator.calculateAngle(FIRST_VECTOR, FIRST_VECTOR);
        Assert.assertEquals(0, angle, DELTA);
    }

    @Test
    public void testCalculateVectorLengthShouldCalculateWhenVectorIsAny() {
        double length;
        length = vectorCalculator.calculateVectorLength(FIRST_VECTOR);
        Assert.assertEquals(FIRST_VECTOR_LENGTH, length, DELTA);
    }

    @Test
    public void testCalculateScalarProductWhenVectorsAreEquals() {
        double scalarProduct;
        scalarProduct = vectorCalculator.calculateScalarProduct(FIRST_VECTOR, THIRD_VECTOR);
        Assert.assertEquals(FIRST_THIRD_VECTOR_PRODUCT, scalarProduct, DELTA);
    }
}