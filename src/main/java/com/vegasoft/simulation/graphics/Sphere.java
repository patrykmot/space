package com.vegasoft.simulation.graphics;

import com.vegasoft.simulation.calc.Calc;
import com.vegasoft.simulation.calc.Vector3D;

import java.util.ArrayList;
import java.util.List;

public class Sphere {

    public static List<Vector3D> calculatePoints(int points, double size) {
        List<Vector3D> pointsList = new ArrayList<>();
        points = Math.max(points, 6);
        size = Math.max(size, 0.0001);

        final double thetaMax = Calc.PI * 2.0;
        double dTheta = thetaMax / (points - 1);
        final double maxPhi = Calc.PI;
        double dPhi = maxPhi / (points - 1);

        for (double phi = 0; phi <= maxPhi; phi += dPhi) {
            for (double theta = 0; theta <= thetaMax; theta += dTheta) {
                Vector3D spherePoint = Calc.sphereToCartesianCoordinates(theta, phi, size);
                pointsList.add(spherePoint);
            }
        }

        return pointsList;
    }
}
