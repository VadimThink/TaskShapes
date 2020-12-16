package edu.epam.quadrangle.factory.impl;

import edu.epam.quadrangle.data.validator.QuadrangleValidator;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.factory.AbstractFactory;
import edu.epam.quadrangle.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleFactory implements AbstractFactory<Quadrangle> {
    private static final Logger LOGGER = LogManager.getLogger(QuadrangleFactory.class);
    private static final IdGenerator idGenerator = new IdGenerator();
    private final QuadrangleValidator quadrangleValidator = new QuadrangleValidator();

    public Quadrangle create(List<Point> points) {
        Quadrangle quadrangle = null;
        if (quadrangleValidator.isValid(points)) {
            int id = idGenerator.getId();
            quadrangle = new Quadrangle(points, id);
        } else {
            LOGGER.warn(points + " points are not valid for quadrangle. Not created.");
        }
        return quadrangle;
    }

}
