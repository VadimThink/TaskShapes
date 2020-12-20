package edu.epam.quadrangle.validator;

import java.util.List;
import java.util.regex.Pattern;

public class PointValidator {
    private static final String POINT_REGEXP = "^[-+]?(0|([1-9]\\d*))(\\.\\d+)?$";
    private static final int POINT_COORDINATES_AMOUNT = 2;
    private static final int X_COORDINATE = 0;
    private static final int Y_COORDINATE = 1;

    public boolean isValid(List<String> coordinatesLines) {
        if (coordinatesLines.size() != POINT_COORDINATES_AMOUNT) {
            return false;
        }
        boolean isCorrectFirstCoordinate = Pattern.matches(POINT_REGEXP, coordinatesLines.get(X_COORDINATE));
        boolean isCorrectSecondCoordinate = Pattern.matches(POINT_REGEXP, coordinatesLines.get(Y_COORDINATE));
        return isCorrectFirstCoordinate && isCorrectSecondCoordinate;
    }
}