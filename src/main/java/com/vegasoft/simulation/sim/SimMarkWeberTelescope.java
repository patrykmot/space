package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorGravity;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolutionVerlet;
import com.vegasoft.simulation.calc.Particle;

import java.util.List;

public class SimMarkWeberTelescope extends SimulationFactory {
    private PhysicalBodyFactoryForSpaceTelescopeWeber pbFactory;

    @Override
    public Simulation createSimulation() {
        ForceCalculator forceCalculator = new ForceCalculatorGravity();
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.25);
        pbFactory = new PhysicalBodyFactoryForSpaceTelescopeWeber();
        List<Particle> particleList = pbFactory.createBodies();
        Simulation simulation = new Simulation(new SimulationParameters(forceCalculator, numericalSolution, particleList));
        return simulation;
    }

    @Override
    public Double getLocationScaleFactor() {
        return pbFactory.getLocationScaleFactor();
    }
}
