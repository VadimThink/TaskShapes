package edu.epam.quadrangle.calculator.quadrangle.impl;

import edu.epam.quadrangle.calculator.quadrangle.QuadrangleCalculable;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.entity.quadrangle.type.QuadrangleType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class QuadrangleCalculatorTest {
    private static final double RIGHT_ANGLE = 90.0;
    private static final Point FIRST_SQUARE_POINT = new Point(0,0);
    private static final Point SECOND_SQUARE_POINT = new Point(0,2);
    private static final Point THIRD_SQUARE_POINT = new Point(2,2);
    private static final Point FOURTH_SQUARE_POINT = new Point(2,0);
    private static final Quadrangle SQUARE = new Quadrangle(Arrays.asList
            (FIRST_SQUARE_POINT, SECOND_SQUARE_POINT, THIRD_SQUARE_POINT, FOURTH_SQUARE_POINT), 0);
    private static final Point THIRD_RECTANGLE_POINT = new Point(4, 2);
    private static final Point FOURTH_RECTANGLE_POINT = new Point(4, 0);
    private static final Quadrangle RECTANGLE = new Quadrangle(Arrays.asList
            (FIRST_SQUARE_POINT, SECOND_SQUARE_POINT, THIRD_RECTANGLE_POINT, FOURTH_RECTANGLE_POINT), 0);
    private static final Point INCORRECT_POINT = new Point(1, 1);
    private static final Quadrangle INCORRECT_QUADRANGLE = new Quadrangle(Arrays.asList
            (FIRST_SQUARE_POINT, SECOND_SQUARE_POINT, THIRD_SQUARE_POINT, INCORRECT_POINT), 0);
    private static final double SQUARE_AREA = 4;
    private static final double SQUARE_PERIMETER = 8;
    private static final double DELTA = 0.0001;

    @Test
    public void testCalculatePerimeterShouldCalculateWhenQuadrangleIsArea() {
        double perimeter;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        perimeter = quadrangleCalculator.calculatePerimeter(SQUARE);
        Assert.assertEquals(SQUARE_PERIMETER, perimeter, DELTA);
    }

    @Test
    public void testCalculateAreaShouldCalculateWhenQuadrangleIsArea() {
        double area;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        area = quadrangleCalculator.calculateArea(SQUARE);
        Assert.assertEquals(SQUARE_AREA, area, DELTA);
    }

    @Test
    public void testIsQuadrangleShouldReturnTrueWhenQuadrangleIsCorrect() {
        boolean isQuadrangle;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        isQuadrangle = quadrangleCalculator.isQuadrangle(SQUARE);
        Assert.assertTrue(isQuadrangle);
    }

    @Test
    public void testIsQuadrangleShouldReturnFalseWhenQuadrangleIsIncorrect() {
        boolean isQuadrangle;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        isQuadrangle = quadrangleCalculator.isQuadrangle(INCORRECT_QUADRANGLE);
        Assert.assertFalse(isQuadrangle);
    }

    @Test
    public void testIsConvexShouldReturnTrueWhenQuadrangleIsConvex() {
        boolean isConvex;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        isConvex = quadrangleCalculator.isConvex(SQUARE);
        Assert.assertTrue(isConvex);
    }

    @Test
    public void testIsConvexShouldReturnFalseWhenQuadrangleIsNotConvex() {
        boolean isConvex;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        isConvex = quadrangleCalculator.isConvex(INCORRECT_QUADRANGLE);
        Assert.assertFalse(isConvex);
    }

    @Test
    public void testFindQuadrangleTypeShouldReturnSquareWhenQuadrangleIsSquare() {
        QuadrangleType type;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        type = quadrangleCalculator.findQuadrangleType(SQUARE);
        Assert.assertEquals(QuadrangleType.SQUARE, type);
    }

    @Test
    public void testFindQuadrangleTypeShouldReturnRectangleWhenQuadrangleIsRectangle() throws NoSuchElementException {
        QuadrangleType type;
        QuadrangleCalculable quadrangleCalculator = new QuadrangleCalculator();
        type = quadrangleCalculator.findQuadrangleType(RECTANGLE);
        Assert.assertEquals(QuadrangleType.RECTANGLE, type);
    }
}