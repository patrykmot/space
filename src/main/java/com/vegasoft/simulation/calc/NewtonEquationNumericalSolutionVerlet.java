package com.vegasoft.simulation.calc;

import org.apache.commons.math3.linear.ArrayRealVector;

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
        List<ArrayRealVector> prevForce = new ArrayList<>(bodies.size());
        for (PhysicalBody pb : bodies) {
            Vector3D newLocation = Vector3D.convert(pb.getLocation().add(
                    (pb.getVelocity().mapMultiply(dt)).add(
//                            pb.getForce().mapSubtract(pb.getM()).mapMultiply(dt2*0.5)
                            pb.getForce().mapMultiply((0.5 * dt2) / pb.getM())
                    )
            ));
            pb.setLocation(newLocation);
            prevForce.add(pb.getForce().copy());
        }

        // Calculate forces for n + 1
        forceCalculationHandler.accept(true);

        // Calculate new velocity
        for (int i = 0; i < bodies.size(); ++i) {
            PhysicalBody pb = bodies.get(i);
            ArrayRealVector force = prevForce.get(i);
            Vector3D newVelocity = Vector3D.convert(pb.getVelocity().add(pb.getForce().add(force).mapMultiply((dt * 0.5) / pb.getM())));
            pb.setVelocity(newVelocity);
        }
    }
}
