package edu.epam.quadrangle.calculator.angle.impl;

import edu.epam.quadrangle.calculator.angle.AnglesCalculable;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AnglesCalculatorTest {
    private static final double RIGHT_ANGLE = 90;
    private static final double NOT_RIGHT_ANGLE = 85;
    private static final Point FIRST_POINT = new Point(0,0);
    private static final Point SECOND_POINT = new Point(0,2);
    private static final Point THIRD_POINT = new Point(2,2);
    private static final Point FOURTH_POINT = new Point(2,0);
    private static final Quadrangle SQUARE = new Quadrangle(Arrays.asList
            (FIRST_POINT, SECOND_POINT, THIRD_POINT, FOURTH_POINT),0);

    @Test
    public void testCalculateAnglesShouldReturnRightAnglesWhenQuadrangleIsSquare() {
        AnglesCalculable anglesCalculator = new AnglesCalculator();
        List<Double> angles;
        angles = anglesCalculator.calculateAngles(SQUARE);
        Assert.assertEquals(Arrays.asList(RIGHT_ANGLE, RIGHT_ANGLE, RIGHT_ANGLE, RIGHT_ANGLE), angles);
    }

    @Test
    public void testIsAnglesRightShouldReturnTrueWhenAllAnglesRight() {
        List<Double> angles = new ArrayList<>();
        angles.add(RIGHT_ANGLE);
        angles.add(RIGHT_ANGLE);
        AnglesCalculable anglesCalculator = new AnglesCalculator();
        boolean isRightAngles;
        isRightAngles = anglesCalculator.isAnglesRight(angles);
        Assert.assertTrue(isRightAngles);
    }

    @Test
    public void testIsAnglesRightShouldReturnFalseWhenNotAllAnglesRight() {
        List<Double> angles = new ArrayList<>();
        angles.add(RIGHT_ANGLE);
        angles.add(NOT_RIGHT_ANGLE);
        AnglesCalculable anglesCalculator = new AnglesCalculator();
        boolean isRightAngles;
        isRightAngles = anglesCalculator.isAnglesRight(angles);
        Assert.assertFalse(isRightAngles);
    }
}