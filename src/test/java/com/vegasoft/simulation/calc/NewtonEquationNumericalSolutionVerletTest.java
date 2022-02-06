package com.vegasoft.simulation.calc;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NewtonEquationNumericalSolutionVerletTest {

    public static final double DT = 0.000001;
    private Vector3D gForce = new Vector3D(0.0, 0.0, -9.81);

    @Test
    public void testIt() {

        NewtonEquationNumericalSolutionVerlet solution = new NewtonEquationNumericalSolutionVerlet(DT);

        Particle b = new Particle();

        List<Particle> bodies = new ArrayList<>();
        bodies.add(b);

        b.setLocation(new Vector3D(0.0, 0.0, 10.0));
        double m = 100000;
        b.setM(m);
        b.setForce(gForce);
        b.setVelocity(Vector3D.getZeroVec());

        double maxTime = 10;
        for (double t = 0; t < maxTime; t += DT) {
            solution.calculateStep(bodies, (bool) -> {
                b.setForce(gForce);
            });
        }

        // Solution = z =  ((- gforce * t ^ 2)/2  + 10)/m
        double expected = ((-gForce.getLength() * maxTime * maxTime) / 2) / m + 10;
        Assert.assertEquals(expected, b.getLocation().getZ(), 0.0001);
    }
}
