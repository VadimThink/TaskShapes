package edu.epam.quadrangle.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class PointValidatorTest {
    private static final List<String> CORRECT_LINE = new ArrayList<>(Arrays.asList("3", "5"));
    private static final List<String> CORRECT_FLOATING_POINT_COORDINATES_LINE = new ArrayList<>(Arrays.asList("3.5", "5.113"));
    private static final List<String> INCORRECT_FLOATING_POINT_COORDINATES_LINE = new ArrayList<>(Arrays.asList("3.qwet", "0005,113"));
    private static final List<String> INCORRECT_ONE_COORDINATE_LINE = new ArrayList<>(Arrays.asList("abc", "5"));
    private static final List<String> INCORRECT_POINT_LINE = new ArrayList<>(Arrays.asList("abc", "7328rwgdfg5-"));
    private static final List<String> ONE_COORDINATE_LINE = new ArrayList<>(Collections.singletonList("4.5"));
    private final PointValidator pointValidator = new PointValidator();

    @Test
    public void testIsValidShouldReturnTrueWhenLineIsCorrect() {
        boolean isCorrectPoint;
        isCorrectPoint = pointValidator.isValid(CORRECT_LINE);
        Assert.assertTrue(isCorrectPoint);
    }


    @Test
    public void testIsValidShouldReturnTrueWhenFloatingPointCoordinatesAreCorrect() {
        boolean isCorrectPoint;
        isCorrectPoint = pointValidator.isValid(CORRECT_FLOATING_POINT_COORDINATES_LINE);
        Assert.assertTrue(isCorrectPoint);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenFloatingPointCoordinatesAreIncorrect() {
        boolean isCorrectPoint;
        isCorrectPoint = pointValidator.isValid(INCORRECT_FLOATING_POINT_COORDINATES_LINE);
        Assert.assertFalse(isCorrectPoint);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenOneCoordinateIsIncorrect() {
        boolean isCorrectPoint;
        isCorrectPoint = pointValidator.isValid(INCORRECT_ONE_COORDINATE_LINE);
        Assert.assertFalse(isCorrectPoint);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenLineIsIncorrect() {
        boolean isCorrectPoint;
        isCorrectPoint = pointValidator.isValid(INCORRECT_POINT_LINE);
        Assert.assertFalse(isCorrectPoint);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenCoordinateIsOne() {
        boolean isCorrectPoint;
        isCorrectPoint = pointValidator.isValid(ONE_COORDINATE_LINE);
        Assert.assertFalse(isCorrectPoint);
    }
}