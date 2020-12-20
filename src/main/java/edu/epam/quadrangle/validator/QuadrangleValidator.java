package edu.epam.quadrangle.validator;

import edu.epam.quadrangle.entity.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuadrangleValidator {
    private static final int AMOUNT_QUADRANGLE_POINTS = 4;

    //validating on same points
    public boolean isValid(List<Point> pointsList) {
        Set<Point> pointsSet = new HashSet<>(pointsList);
        return pointsSet.size() == AMOUNT_QUADRANGLE_POINTS;
    }
}