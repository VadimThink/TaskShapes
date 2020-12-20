package edu.epam.quadrangle.parser;

import edu.epam.quadrangle.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class PointsParserTest {

    @Test
    public void testParseListOfPoints() {
        String line = "1.0 2.0, 2.0 2.0, 2.0 3.0, 1.0 3.0";
        PointsParser parser = new PointsParser();
        List<Point> actual = parser.parseListOfPoints(line);
        List<Point> expected = new ArrayList<>();
        expected.add(new Point(1.0, 2.0));
        expected.add(new Point(2.0, 2.0));
        expected.add(new Point(2.0, 3.0));
        expected.add(new Point(1.0, 3.0));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParsePointIfLineCorrect() {
        String line = "2 4";
        PointsParser parser = new PointsParser();
        Optional<Point> actual = parser.parsePoint(line);
        Optional<Point> expected = Optional.of(new Point(2, 4));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testParsePointIfLineIncorrect(){
        String line = "2 --4";
        PointsParser parser = new PointsParser();
        Optional<Point> actual = parser.parsePoint(line);
        boolean isNull = actual.isEmpty();
        assertTrue(isNull);
    }
}