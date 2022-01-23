package com.vegasoft.simulation.calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Simulation.class);
    private ForceCalculator forceCalculator;
    private NewtonEquationNumericalSolution numericalSolution;
    private List<PhysicalBody> physicalBodyList;
    private List<PhysicalBody> physicalBodyListResult = new ArrayList<>();
    private boolean firstStep = true;

    public Simulation(ForceCalculator forceCalculator, NewtonEquationNumericalSolution numericalSolution, List<PhysicalBody> physicalBodyList) {
        this.forceCalculator = forceCalculator;
        this.numericalSolution = numericalSolution;
        this.physicalBodyList = physicalBodyList;
    }

    public void run() {
        if (firstStep) {
            firstStep = false;
            calculateForces();
        }
        numericalSolution.calculateStep(physicalBodyList, (b) -> calculateForces());

        synchronized (this) {
//            logger.info("Clone list start");
            physicalBodyListResult = new ArrayList<>();
            physicalBodyList.forEach(pb -> physicalBodyListResult.add(new PhysicalBody(pb)));
//            logger.info("Clone list end");
        }
    }

    public List<PhysicalBody> getPhysicalBodyListResult() {
        synchronized (this) {
            return physicalBodyListResult;
        }
    }

    private void calculateForces() {
        // Reset forces
        physicalBodyList.forEach(pb -> pb.setForce(Vector3D.getZeroVec()));

        // Calculate forces for every body
        for (int i1 = 0; i1 < physicalBodyList.size() - 1; ++i1) {
            PhysicalBody b1 = physicalBodyList.get(i1);
            for (int i2 = i1 + 1; i2 < physicalBodyList.size(); ++i2) {
                PhysicalBody b2 = physicalBodyList.get(i2);
                Vector3D force = forceCalculator.calculateForceFromAtoB(b1, b2);
                b1.addForce(force);
                b2.subtractForce(force);
            }
        }
    }
}
