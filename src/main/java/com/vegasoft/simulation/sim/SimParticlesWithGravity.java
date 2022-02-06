package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceAirDrag;
import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorCollection;
import com.vegasoft.simulation.calc.ForceCalculatorLenardJones;
import com.vegasoft.simulation.calc.ForceG;
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
        double rm = 2;
        ForceCalculator forceParticles = new ForceCalculatorLenardJones(0.1, rm);
        ForceCalculator forceStationary = ForceCalculatorCollection.of(new ForceCalculatorLenardJones(0.01, rm), new ForceG(), new ForceAirDrag());
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.00025);

        RandomizeLocationFunction rf = new RandomizeLocationFunction(Vector3D.create(-3, 30, -20), 0.1);
        PhysicalBodyFactoryParticles factoryParticles = new PhysicalBodyFactoryParticles(new ParticleParams(4, 10, 4, rm - 0.14, rf));
        List<Particle> particleList = factoryParticles.createBodies();

        List<StationaryPhysicalBody> stationaryBodies = new ArrayList<>();

        double size = 14;
        // y
        stationaryBodies.add(new StationaryPhysicalBodyInfiniteFlatSurface(new Vector3D(0.0, 0.0, 0.0), new Vector3D(0.0, 1.0, 0.0)));

        // x
        stationaryBodies.add(new StationaryPhysicalBodyInfiniteFlatSurface(new Vector3D(size, 0.0, 0.0), new Vector3D(-1.0, 0.0, 0.0)));
        stationaryBodies.add(new StationaryPhysicalBodyInfiniteFlatSurface(new Vector3D(-size, 0.0, 0.0), new Vector3D(1.0, 0.0, 0.0)));

        // z
        stationaryBodies.add(new StationaryPhysicalBodyInfiniteFlatSurface(new Vector3D(0, 0.0, size), new Vector3D(0.0, 1.0, -1)));
        stationaryBodies.add(new StationaryPhysicalBodyInfiniteFlatSurface(new Vector3D(0, 0.0, -size), new Vector3D(0.0, 1.0, 1)));


        SimulationParameters simulationParameters = new SimulationParameters(forceParticles, numericalSolution, particleList, forceStationary, stationaryBodies);
        Simulation simulation = new Simulation(simulationParameters);
        return simulation;
    }

    @Override
    public Double getLocationScaleFactor() {
        return 1.0;
    }
}
