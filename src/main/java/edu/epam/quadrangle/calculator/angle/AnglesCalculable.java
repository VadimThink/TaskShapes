package edu.epam.quadrangle.calculator.angle;

import edu.epam.quadrangle.entity.quadrangle.Quadrangle;

import java.util.List;

public interface AnglesCalculable {
    boolean isAnglesRight(List<Double> angles);
    List<Double> calculateAngles(Quadrangle quadrangle);
}
