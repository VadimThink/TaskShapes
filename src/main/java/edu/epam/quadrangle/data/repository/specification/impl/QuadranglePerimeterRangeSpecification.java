package edu.epam.quadrangle.data.repository.specification.impl;

import edu.epam.quadrangle.data.calculator.quadrangle.QuadrangleCalculable;
import edu.epam.quadrangle.data.repository.specification.Specification;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

public class QuadranglePerimeterRangeSpecification implements Specification<Quadrangle> {
    private final double minPerimeter;
    private final double maxPerimeter;
    private final QuadrangleCalculable quadrangleCalculator;

    public QuadranglePerimeterRangeSpecification(double minPerimeter, double maxPerimeter,
                                                 QuadrangleCalculable quadrangleCalculator) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
        this.quadrangleCalculator = quadrangleCalculator;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        double area = quadrangleCalculator.calculatePerimeter(quadrangle);
        return Double.compare(area, minPerimeter) >= 0 &&
                Double.compare(area, maxPerimeter) <= 0;
    }
}

