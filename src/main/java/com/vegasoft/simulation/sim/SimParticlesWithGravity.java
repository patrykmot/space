package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorLenardJones;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolutionVerlet;
import com.vegasoft.simulation.calc.Particle;
import com.vegasoft.simulation.calc.StationaryPhysicalBody;
import com.vegasoft.simulation.calc.StationaryPhysicalBodyInfiniteFlatSurface;
import com.vegasoft.simulation.calc.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class SimParticlesWithGravity extends SimulationFactory {

    @Override
    public Simulation createSimulation() {
        double rm = 4;
        ForceCalculator forceCalculator = new ForceCalculatorLenardJones(0.1, rm);
        ForceCalculator forceCalculator2 = new ForceCalculatorLenardJones(0.01, rm);
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.000000025);

        RandomizeLocationFunction rf = new RandomizeLocationFunction(Vector3D.create(-1, 5, 0), 0.0001);

        PhysicalBodyFactoryParticles factoryParticles = new PhysicalBodyFactoryParticles(new ParticleParams(2, 1, 1, rm - 0.14, rf));
        List<Particle> particleList = factoryParticles.createBodies();
        particleList.forEach(p -> p.setVelocity(new Vector3D(0.0, -0.6, 0.0)));
        List<StationaryPhysicalBody> stationaryBodies = new ArrayList<>();
        stationaryBodies.add(new StationaryPhysicalBodyInfiniteFlatSurface(new Vector3D(0.0, 0.0, 0.0), new Vector3D(0.0, 1.0, 0.0)));
        SimulationParameters simulationParameters = new SimulationParameters(forceCalculator, numericalSolution, particleList, forceCalculator2, stationaryBodies);
        Simulation simulation = new Simulation(simulationParameters);
        return simulation;
    }

    @Override
    public Double getLocationScaleFactor() {
        return 1.0;
    }
}
