package edu.epam.quadrangle.data.comparator;

import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.entity.quadrangle.type.QuadrangleSortType;
import edu.epam.quadrangle.exception.UnknownQuadrangleSortType;

import java.util.Comparator;

public class QuadrangleComparatorFactory {
    private static final String UNKNOWN_SORT_TYPE = "Unknown quadrangle sort type.";

    public Comparator<Quadrangle> createComparator(QuadrangleSortType type) throws UnknownQuadrangleSortType {
        switch (type) {
            case ID:
                return new QuadrangleIdComparator();
            case FIRST_POINT_X:
                return new QuadrangleFirstPointXComparator();
            case FIRST_POINT_Y:
                return new QuadrangleFirstPointYComparator();
            default:
                throw new UnknownQuadrangleSortType(UNKNOWN_SORT_TYPE);
        }
    }
}
