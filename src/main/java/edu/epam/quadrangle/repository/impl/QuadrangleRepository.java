package edu.epam.quadrangle.repository.impl;

import edu.epam.quadrangle.comparator.QuadrangleComparatorFactory;
import edu.epam.quadrangle.repository.Repository;
import edu.epam.quadrangle.repository.specification.Specification;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.entity.quadrangle.type.QuadrangleSortType;
import edu.epam.quadrangle.exception.RepositoryDataException;
import edu.epam.quadrangle.exception.UnknownQuadrangleSortTypeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class QuadrangleRepository implements Repository<Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger(QuadrangleRepository.class);
    private final List<Quadrangle> quadrangles;

    public QuadrangleRepository() {
        quadrangles = new ArrayList<>();
    }

    public QuadrangleRepository(List<Quadrangle> source) {
        quadrangles = source;
    }

    @Override
    public void add(Quadrangle quadrangle) throws RepositoryDataException {
        LOGGER.info("trying to add " + quadrangle + " to repository");
        if (quadrangles.contains(quadrangle)) {
            LOGGER.info("Throwing repository data exception");
            throw new RepositoryDataException("Repository already contains quadrangle: " + quadrangle);
        }
        LOGGER.info("added");
        quadrangles.add(quadrangle);
    }

    @Override
    public void remove(Quadrangle quadrangle) throws RepositoryDataException {
        LOGGER.info("trying to remove " + quadrangle + " from repository");
        if (!quadrangles.contains(quadrangle)) {
            LOGGER.info("Throwing repository data exception");
            throw new RepositoryDataException("Repository doesn't contain quadrangle: " + quadrangle);
        }
        LOGGER.info("removed");
        quadrangles.remove(quadrangle);
    }

    @Override
    public void update(Quadrangle quadrangle) {
        LOGGER.info("trying to update " + quadrangle + " in repository");
        int id = quadrangle.getId();
        Iterator<Quadrangle> iterator = quadrangles.iterator();
        Quadrangle thatQuadrangle;
        while (iterator.hasNext()) {
            thatQuadrangle = iterator.next();
            if (thatQuadrangle.getId() == id) {
                quadrangles.remove(thatQuadrangle);
                quadrangles.add(quadrangle);
                LOGGER.info("updated");
                break;
            }
        }
        LOGGER.info("end of updating");
    }

    @Override
    public void sortByTag(QuadrangleSortType sortType) throws UnknownQuadrangleSortTypeException {
        QuadrangleComparatorFactory comparatorFactory = new QuadrangleComparatorFactory();
        LOGGER.info("trying to sort by " + sortType + " tag in repository");
        Comparator<Quadrangle> comparator = comparatorFactory.createComparator(sortType);
        quadrangles.sort(comparator);
        LOGGER.info("successfully sorted");
    }

    @Override
    public List<Quadrangle> query(Specification<Quadrangle> specification) {
        LOGGER.info("trying to query in repository");
        List<Quadrangle> result = new LinkedList<>();
        for (Quadrangle quadrangle : quadrangles) {
            if (specification.specified(quadrangle)) {
                LOGGER.info("added");
                result.add(quadrangle);
            }
        }
        LOGGER.info("end of querying");
        return result;
    }
}
