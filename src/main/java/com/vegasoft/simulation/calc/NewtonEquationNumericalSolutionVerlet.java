package com.vegasoft.simulation.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NewtonEquationNumericalSolutionVerlet implements NewtonEquationNumericalSolution {
    private double dt;
    private double dt2;

    public NewtonEquationNumericalSolutionVerlet(double dt) {
        assert dt > 0.0;
        this.dt = dt;
        this.dt2 = dt * dt;
    }

    public void calculateStep(List<PhysicalBody> bodies, Consumer<Boolean> forceCalculationHandler) {
        // Verlet algorithm https://www.compadre.org/PICUP/resources/Numerical-Integration/
        // Calculate new location
        List<Vector3D> prevForce = new ArrayList<>(bodies.size());
        for (PhysicalBody pb : bodies) {
            pb.getLocation().add(
                    (pb.getVelocity().copy().mapMultiply(dt)).add(
                            pb.getForce().copy().mapMultiply((0.5 * dt2) / pb.getM())
                    )
            );
            prevForce.add(pb.getForce());
        }

        // Calculate forces for n + 1
        forceCalculationHandler.accept(true);

        // Calculate new velocity
        for (int i = 0; i < bodies.size(); ++i) {
            PhysicalBody pb = bodies.get(i);
            Vector3D force = prevForce.get(i);
            pb.getVelocity().add(pb.getForce().copy().add(force).mapMultiply((dt * 0.5) / pb.getM()));
        }
    }
}
