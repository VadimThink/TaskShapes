package edu.epam.quadrangle.validator;

import edu.epam.quadrangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleValidatorTest {
    private static final List<Point> CORRECT_POINTS = new ArrayList<>();
    private static final List<Point> INCORRECT_POINTS = new ArrayList<>();
    private static final List<Point> SINGLE_POINT = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        CORRECT_POINTS.add(new Point(0, 0));
        CORRECT_POINTS.add(new Point(0, 2));
        CORRECT_POINTS.add(new Point(2, 2));
        CORRECT_POINTS.add(new Point(2, 0));
        INCORRECT_POINTS.add(new Point(0, 0));
        INCORRECT_POINTS.add(new Point(0, 0));
        INCORRECT_POINTS.add(new Point(3, 5));
        INCORRECT_POINTS.add(new Point(1, 1));
        SINGLE_POINT.add(new Point(2, 2));
    }

    private final QuadrangleValidator quadrangleValidator = new QuadrangleValidator();

    @Test
    public void testIsValidShouldReturnTrueWhenPointsAreCorrect() {
        boolean isValidQuadrangle;
        isValidQuadrangle = quadrangleValidator.isValid(CORRECT_POINTS);
        Assert.assertTrue(isValidQuadrangle);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenPointsAreNotDifferent() {
        boolean isValidQuadrangle;
        isValidQuadrangle = quadrangleValidator.isValid(INCORRECT_POINTS);
        Assert.assertFalse(isValidQuadrangle);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenPointIsSingle() {
        boolean isValidQuadrangle;
        isValidQuadrangle = quadrangleValidator.isValid(SINGLE_POINT);
        Assert.assertFalse(isValidQuadrangle);
    }
}