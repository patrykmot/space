package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorGravity;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolutionVerlet;
import com.vegasoft.simulation.calc.PhysicalBody;

import java.util.List;

public class SimMarkWeberTelescope implements SimulationFactory {
    private PhysicalBodyFactoryForSpaceTelescopeWeber pbFactory;

    @Override
    public Simulation createSimulation() {
        ForceCalculator forceCalculator = new ForceCalculatorGravity();
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.25);
        pbFactory = new PhysicalBodyFactoryForSpaceTelescopeWeber();
        List<PhysicalBody> physicalBodyList = pbFactory.createBodies();
        Simulation simulation = new Simulation(forceCalculator, numericalSolution, physicalBodyList);
        return simulation;
    }

    @Override
    public Double getLocationScaleFactor() {
        return pbFactory.getLocationScaleFactor();
    }
}
