package edu.epam.quadrangle.calculator.quadrangle;

import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.entity.quadrangle.type.QuadrangleType;

public interface QuadrangleCalculable {
    double calculatePerimeter(Quadrangle quadrangle);

    double calculateArea(Quadrangle quadrangle);

    boolean isQuadrangle(Quadrangle quadrangle);

    boolean isConvex(Quadrangle quadrangle);

    QuadrangleType findQuadrangleType(Quadrangle quadrangle);
}