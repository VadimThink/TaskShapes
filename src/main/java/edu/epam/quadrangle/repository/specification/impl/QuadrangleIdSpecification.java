package edu.epam.quadrangle.repository.specification.impl;

import edu.epam.quadrangle.repository.specification.Specification;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

public class QuadrangleIdSpecification implements Specification<Quadrangle> {
    private final int id;

    public QuadrangleIdSpecification(Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(Quadrangle quadrangle) {
        return quadrangle.getId() == id;
    }
}