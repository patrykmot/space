package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorLenardJones;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolutionVerlet;
import com.vegasoft.simulation.calc.PhysicalBody;

import java.util.List;

public class SimParticles implements SimulationFactory {

    @Override
    public Simulation createSimulation() {
        double rm = 4;
        ForceCalculator forceCalculator = new ForceCalculatorLenardJones(0.1, rm);
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.00025);

        RandomizeLocationFunction rf = new RandomizeLocationFunction(0.00001);

        PhysicalBodyFactoryParticles factoryParticles = new PhysicalBodyFactoryParticles(new ParticleParams(5, 5, 5, rm - 0.14, rf));
        List<PhysicalBody> physicalBodyList = factoryParticles.createBodies();
        Simulation simulation = new Simulation(forceCalculator, numericalSolution, physicalBodyList);
        return simulation;
    }

    @Override
    public Double getLocationScaleFactor() {
        return 1.0;
    }
}
