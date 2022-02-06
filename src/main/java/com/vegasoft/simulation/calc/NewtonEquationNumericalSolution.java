package com.vegasoft.simulation.calc;

import java.util.List;
import java.util.function.Consumer;

public interface NewtonEquationNumericalSolution {
    void calculateStep(List<Particle> bodies, Consumer<Boolean> forceCalculationHandler);
}
