package edu.epam.quadrangle.comparator;

import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle firstQuadrangle, Quadrangle secondQuadrangle) {
        int firstQuadrangleId = firstQuadrangle.getId();
        int secondQuadrangleId = secondQuadrangle.getId();
        return firstQuadrangleId - secondQuadrangleId;
    }
}
