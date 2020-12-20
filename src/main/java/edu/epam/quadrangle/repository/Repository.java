package edu.epam.quadrangle.repository;

import edu.epam.quadrangle.repository.specification.Specification;
import edu.epam.quadrangle.entity.quadrangle.type.QuadrangleSortType;
import edu.epam.quadrangle.exception.RepositoryDataException;
import edu.epam.quadrangle.exception.UnknownQuadrangleSortTypeException;

import java.util.List;

public interface Repository<T> {
    void add(T quadrangle) throws RepositoryDataException;
    void remove(T quadrangle) throws RepositoryDataException;
    void update(T quadrangle);
    void sortByTag(QuadrangleSortType sortType) throws UnknownQuadrangleSortTypeException;

    List<T> query(Specification<T> specification);
}