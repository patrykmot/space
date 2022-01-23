package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimulationTest {

    @Test
    public void testIt() {
        ForceCalculator forceCalculator = new ForceCalculatorGravity();
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.025);
        List<PhysicalBody> physicalBodyList = new ArrayList<>();

        PhysicalBody pb1 = new PhysicalBody().setLocation(Vector3D.create(10., 0, 0)).setM(1000);
        PhysicalBody pb2 = new PhysicalBody().setLocation(Vector3D.create(0., 0, 0)).setM(1000000);
        PhysicalBody pb3 = new PhysicalBody().setLocation(Vector3D.create(-10., 0, -2)).setM(10);

        physicalBodyList.add(pb1);
        physicalBodyList.add(pb2);
        physicalBodyList.add(pb3);

        Simulation sim = new Simulation(forceCalculator, numericalSolution, physicalBodyList);

        for (int i = 0; i < 500; ++i) {
            sim.run();
        }
        print(physicalBodyList);
        Assert.assertTrue(pb2.getVelocity().getLength() < pb1.getVelocity().getLength());
        Assert.assertTrue(pb2.getVelocity().getLength() < pb1.getVelocity().getLength());
    }

    private void print(List<PhysicalBody> physicalBodyList) {
        physicalBodyList.forEach(pb -> System.out.println("" + pb));

    }
}
