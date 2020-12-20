package edu.epam.quadrangle.repository.specification;

public interface Specification<T> {
    boolean specified(T object);
}
