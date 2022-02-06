package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorLenardJones;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolutionVerlet;
import com.vegasoft.simulation.calc.Particle;
import com.vegasoft.simulation.calc.Vector3D;

import java.util.List;

public class SimParticles extends SimulationFactory {

    @Override
    public Simulation createSimulation() {
        double rm = 4;
        ForceCalculator forceCalculator = new ForceCalculatorLenardJones(0.1, rm);
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.00025);

        RandomizeLocationFunction rf = new RandomizeLocationFunction(Vector3D.getZeroVec(), 0.00001);

        PhysicalBodyFactoryParticles factoryParticles = new PhysicalBodyFactoryParticles(new ParticleParams(7, 7, 7, rm - 0.14, rf));
        List<Particle> particleList = factoryParticles.createBodies();
        Simulation simulation = new Simulation(new SimulationParameters(forceCalculator, numericalSolution, particleList));
        return simulation;
    }

    @Override
    public Double getLocationScaleFactor() {
        return 1.0;
    }
}
