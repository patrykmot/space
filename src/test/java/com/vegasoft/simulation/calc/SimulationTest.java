package com.vegasoft.simulation.calc;

import com.vegasoft.simulation.sim.Simulation;
import com.vegasoft.simulation.sim.SimulationParameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimulationTest {

    @Test
    public void testIt() {
        ForceCalculator forceCalculator = new ForceCalculatorGravity();
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.025);
        List<Particle> particleList = new ArrayList<>();

        Particle pb1 = new Particle();
        pb1.setLocation(Vector3D.create(10., 0, 0)).setM(1000);
        Particle pb2 = new Particle();
        pb2.setLocation(Vector3D.create(0., 0, 0)).setM(1000000);
        Particle pb3 = new Particle();
        pb3.setLocation(Vector3D.create(-10., 0, -2)).setM(10);

        particleList.add(pb1);
        particleList.add(pb2);
        particleList.add(pb3);

        Simulation sim = new Simulation(new SimulationParameters(forceCalculator, numericalSolution, particleList));

        for (int i = 0; i < 500; ++i) {
            sim.run();
        }
        print(particleList);
        Assert.assertTrue(pb2.getVelocity().getLength() < pb1.getVelocity().getLength());
        Assert.assertTrue(pb2.getVelocity().getLength() < pb1.getVelocity().getLength());
    }

    private void print(List<Particle> particleList) {
        particleList.forEach(pb -> System.out.println("" + pb));

    }
}
