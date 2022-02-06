package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.Particle;
import com.vegasoft.simulation.calc.StationaryPhysicalBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SimulationParameters {
    private final NewtonEquationNumericalSolution numericalSolution;
    private final ForceCalculator particleForces;
    private final List<Particle> particles;
    private Optional<ForceCalculator> stationaryForces = Optional.empty();
    private List<StationaryPhysicalBody> stationaryBodies = Collections.emptyList();

    public SimulationParameters(ForceCalculator particleForces, NewtonEquationNumericalSolution numericalSolution, List<Particle> particles) {
        this.particleForces = particleForces;
        this.numericalSolution = numericalSolution;
        this.particles = particles;
    }

    public SimulationParameters(NewtonEquationNumericalSolution numericalSolution, ForceCalculator particleForces, List<Particle> particles, ForceCalculator stationaryForces, List<StationaryPhysicalBody> stationaryBodies) {
        this.numericalSolution = numericalSolution;
        this.particleForces = particleForces;
        this.particles = particles;
        this.stationaryForces = Optional.of(stationaryForces);
        this.stationaryBodies = stationaryBodies;
    }

    public Optional<ForceCalculator> getStationaryForces() {
        return stationaryForces;
    }

    public List<StationaryPhysicalBody> getStationaryBodies() {
        return stationaryBodies;
    }

    public ForceCalculator getParticleForces() {
        return particleForces;
    }

    public NewtonEquationNumericalSolution getNumericalSolution() {
        return numericalSolution;
    }

    public List<Particle> getParticles() {
        return particles;
    }
}
