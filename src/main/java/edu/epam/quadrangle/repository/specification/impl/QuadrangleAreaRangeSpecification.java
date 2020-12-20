package edu.epam.quadrangle.repository.specification.impl;

import edu.epam.quadrangle.calculator.quadrangle.QuadrangleCalculable;
import edu.epam.quadrangle.repository.specification.Specification;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

public class QuadrangleAreaRangeSpecification implements Specification<Quadrangle> {
    private final double minArea;
    private final double maxArea;
    private final QuadrangleCalculable quadrangleCalculator;

    public QuadrangleAreaRangeSpecification(double minArea, double maxArea, QuadrangleCalculable quadrangleCalculator) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.quadrangleCalculator = quadrangleCalculator;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        double area = quadrangleCalculator.calculateArea(quadrangle);

        return Double.compare(area, minArea) >= 0 && Double.compare(area,maxArea) <= 0;
    }
}
