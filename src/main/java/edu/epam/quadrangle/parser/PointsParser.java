package edu.epam.quadrangle.parser;

import edu.epam.quadrangle.entity.Point;
import edu.epam.quadrangle.validator.PointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PointsParser {
    private static final Logger LOGGER = LogManager.getLogger(PointsParser.class);
    private static final String PARSE_POINT_REGEXP = "\\s+";
    private static final String PARSE_POINTLIST_REGEXP = ", ";
    private static final int X_COORDINATE = 0;
    private static final int Y_COORDINATE = 1;

    public List<Point> parseListOfPoints(String line){
        String[] parsedString = line.split(PARSE_POINTLIST_REGEXP);
        List<Point> pointsList = new ArrayList<>();
        for (int i = 0; i < parsedString.length; i++){
            Optional<Point> point = parsePoint(parsedString[i]);
            point.ifPresent(pointsList::add);
        }
        return pointsList;
    }

    public Optional<Point> parsePoint(String linePoint) {
        PointValidator pointValidator = new PointValidator();
        String[] pointsStringArray = linePoint.split(PARSE_POINT_REGEXP);
        List<String> pointsStringList = Arrays.asList(pointsStringArray);
        Point point = null;
        if (pointValidator.isValid(pointsStringList)) {
            double xCoordinate = Double.parseDouble(pointsStringList.get(X_COORDINATE));
            double yCoordinate = Double.parseDouble(pointsStringList.get(Y_COORDINATE));
            point = new Point(xCoordinate, yCoordinate);
        } else {
            LOGGER.warn(String.format("%s line is not parsed as point", linePoint));
        }
        Optional<Point> pointOptional = Optional.ofNullable(point);
        return pointOptional;
    }
}
