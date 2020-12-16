package edu.epam.quadrangle.director;

import edu.epam.quadrangle.data.parser.PointParser;
import edu.epam.quadrangle.data.reader.FileDataReader;
import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.entity.quadrangle.Quadrangle;
import edu.epam.quadrangle.exception.InputDataException;
import edu.epam.quadrangle.factory.impl.QuadrangleFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleDirector {
    private static final Logger LOGGER = LogManager.getLogger(QuadrangleDirector.class);
    private static final int QUADRANGLE_POINTS_AMOUNT = 4;
    private static final int POINT_COORDINATES_AMOUNT = 2;
    private static final String FILE_INPUT_PATH = "data.txt";
    private final FileDataReader dataReader = new FileDataReader();
    private final PointParser pointParser = new PointParser();
    private final QuadrangleFactory quadrangleFactory = new QuadrangleFactory();


    public List<Quadrangle> createQuadrangles() throws InputDataException {
        LOGGER.info("Preparing to create quadrangles");
        List<String> dataLines = dataReader.readData(FILE_INPUT_PATH);
        List<Point> points = new ArrayList<>(dataLines.size() / POINT_COORDINATES_AMOUNT);
        LOGGER.info("Start of point parsing");
        for (String line : dataLines) {
            Point point = pointParser.parsePoint(line);
            if (point != null) {
                points.add(point);
            }
        }
        LOGGER.info("End of point parsing");
        int quadranglesAmount = points.size() / QUADRANGLE_POINTS_AMOUNT;
        List<Quadrangle> quadrangles = null;
        if (quadranglesAmount > 0) {
            quadrangles = new ArrayList<>(quadranglesAmount);
            LOGGER.info("Start of parsing quadrangles");
            for (int i = 0; i < quadranglesAmount; i++) {
                int startPos = i * QUADRANGLE_POINTS_AMOUNT;
                List<Point> quadranglePoints = points.subList(startPos, startPos + QUADRANGLE_POINTS_AMOUNT);
                Quadrangle quadrangle = quadrangleFactory.create(quadranglePoints);
                if (quadrangle != null) {
                    quadrangles.add(quadrangle);
                }
            }
            if (quadrangles.size() == 0) {
                quadrangles = null;
                LOGGER.warn("Zero quadrangles are passed");
            }
        } else {
            LOGGER.warn("You have no quadrangles");
        }
        LOGGER.info("End of creating quadrangles");
        return quadrangles;
    }
}
