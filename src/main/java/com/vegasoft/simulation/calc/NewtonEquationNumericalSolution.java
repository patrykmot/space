package com.vegasoft.simulation.calc;

import java.util.List;
import java.util.function.Consumer;

public interface NewtonEquationNumericalSolution {
    void calculateStep(List<PhysicalBody> bodies, Consumer<Boolean> forceCalculationHandler);
}
