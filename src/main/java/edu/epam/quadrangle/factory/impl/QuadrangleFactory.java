package edu.epam.quadrangle.factory.impl;

import edu.epam.quadrangle.validator.QuadrangleValidator;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.factory.AbstractFactory;
import edu.epam.quadrangle.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class QuadrangleFactory implements AbstractFactory<Optional<Quadrangle>> {
    private static final Logger LOGGER = LogManager.getLogger(QuadrangleFactory.class);

    public Optional<Quadrangle> create(List<Point> points) {
        IdGenerator idGenerator = new IdGenerator();
        QuadrangleValidator quadrangleValidator = new QuadrangleValidator();
        Quadrangle quadrangle = null;
        if (quadrangleValidator.isValid(points)) {
            int id = idGenerator.getId();
            quadrangle = new Quadrangle(points, id);
        } else {
            LOGGER.warn(points + " points are not valid for quadrangle. Not created.");
        }
        Optional<Quadrangle> quadrangleOptional = Optional.of(quadrangle);
        return quadrangleOptional;
    }

}
