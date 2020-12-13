package edu.epam.quadrangle.data.parser;

import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.factory.QuadrangleFactory;
import edu.epam.quadrangle.util.IdGenerator;
import edu.epam.quadrangle.data.validator.QuadrangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleParser {
    private static final Logger LOGGER = LogManager.getLogger(QuadrangleParser.class);
    private static final IdGenerator idGenerator = new IdGenerator();
    private final QuadrangleValidator quadrangleValidator;
    private final QuadrangleFactory quadrangleFactory = new QuadrangleFactory();

    public QuadrangleParser(QuadrangleValidator quadrangleValidator) {
        this.quadrangleValidator = quadrangleValidator;
    }

    public Quadrangle parseQuadrangle(List<Point> pointList) {
        Quadrangle quadrangle = null;
        if (quadrangleValidator.isValid(pointList)) {
            int id = idGenerator.getId();
            quadrangle = quadrangleFactory.create(pointList, id);
        } else {
            LOGGER.warn(pointList + " points are not valid for quadrangle. Not parsed.");
        }
        return quadrangle;
    }
}