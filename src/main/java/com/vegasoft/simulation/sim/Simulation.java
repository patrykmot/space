package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.Particle;
import com.vegasoft.simulation.calc.StationaryPhysicalBody;
import com.vegasoft.simulation.calc.Vector3D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Simulation.class);
    private SimulationParameters sp;
    private List<Particle> particleListResult = new ArrayList<>();
    private boolean firstStep = true;

    public Simulation(SimulationParameters simulationParameters) {
        this.sp = simulationParameters;
    }

    public void run() {
        if (firstStep) {
            firstStep = false;
            calculateForces();
        }
        sp.getNumericalSolution().calculateStep(sp.getParticles(), (b) -> calculateForces());

        synchronized (this) {
            particleListResult = new ArrayList<>();
            sp.getParticles().forEach(pb -> particleListResult.add(new Particle(pb)));
        }
    }

    public List<Particle> getParticleListResult() {
        synchronized (this) {
            return particleListResult;
        }
    }

    private void calculateForces() {
        // Reset particle forces
        sp.getParticles().forEach(particles -> particles.setForce(Vector3D.getZeroVec()));
        calculateParticleForces(sp.getParticles(), sp.getParticleForces());
        sp.getStationaryForces().ifPresent(this::calculateStationaryForces);
    }

    private void calculateStationaryForces(ForceCalculator stationaryForce) {
        for (Particle particle : sp.getParticles()) {
            for (StationaryPhysicalBody stationaryBody : sp.getStationaryBodies()) {
                Vector3D force = stationaryForce.calculateForceWhichAGetsFromB(particle, stationaryBody);
                particle.addForce(force);
            }
        }
    }

    private void calculateParticleForces(List<Particle> particles, ForceCalculator particleForces) {
        for (int i1 = 0; i1 < particles.size() - 1; ++i1) {
            Particle b1 = particles.get(i1);
            for (int i2 = i1 + 1; i2 < particles.size(); ++i2) {
                Particle b2 = particles.get(i2);
                Vector3D force = particleForces.calculateForceWhichAGetsFromB(b1, b2);
                b1.addForce(force);
                b2.subtractForce(force);
            }
        }
    }
}
