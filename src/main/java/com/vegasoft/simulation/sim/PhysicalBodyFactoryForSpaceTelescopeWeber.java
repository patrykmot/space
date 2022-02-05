package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.PhysicalBody;
import com.vegasoft.simulation.calc.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class PhysicalBodyFactoryForSpaceTelescopeWeber implements PhysicalBodyFactory {

    public static final double MASS_EARTH = 5.96e24;
    public static final double MASS_SUN = 1.99e30;
    private static final double ORBIT_EARTH_AROUND_SUN_DISTANCE = 1.497e11 /*m*/;
    private static final double ORBIT_EARTH_AROUND_SUN_SPEED = 107000 /*km/h*/ / 3.6; // m/s


    public List<PhysicalBody> createBodies() {
        List<PhysicalBody> pb = new ArrayList<>();

        PhysicalBody earth = new PhysicalBody("Earth");
        earth.setM(MASS_EARTH); // kg
        earth.setLocation(Vector3D.create(ORBIT_EARTH_AROUND_SUN_DISTANCE, 0.0, 0.0))
                .setVelocity(Vector3D.create(0.0, 0.0, ORBIT_EARTH_AROUND_SUN_SPEED));

        PhysicalBody sun = new PhysicalBody("Sun");
        sun.setM(MASS_SUN); // kg

        pb.add(earth);
        pb.add(sun);

        // Put telescope at l2 point
        Vector3D l2 = calculateL2(sun, earth);
        PhysicalBody telescope = new PhysicalBody("Mark Weber Space Telescope");
        telescope.setM(2000); // kg
//        telescope.setLocation(Vector3D.convert(l2.mapMultiply(1.1))); // funny
        telescope.setLocation(l2);
        telescope.setVelocity(Vector3D.create(0.0, 0.0, ORBIT_EARTH_AROUND_SUN_SPEED));
        pb.add(telescope);

        return pb;
    }

    public double getLocationScaleFactor() {
        return 1e10;
    }

    private Vector3D calculateL2(PhysicalBody b1, PhysicalBody b2) {
        // Lagrange L2 point https://www.mat.univie.ac.at/~westra/lagrangepoints.pdf
        Vector3D l2 = b2.getLocation().copy().mapMultiply(1 + Math.pow(b2.getM() / (3 * b1.getM()), 1 / 3.0));
        return l2;
    }

}
