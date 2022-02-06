package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.Vector3D;

import java.util.Random;
import java.util.function.Function;

public class RandomizeLocationFunction implements Function<Vector3D, Vector3D> {
    private Vector3D startLocation;
    private Random r = new Random(1);
    private double maxRandomSize;

    public RandomizeLocationFunction(Vector3D startLocation, double maxRandomSize) {
        this.startLocation = startLocation;
        this.maxRandomSize = maxRandomSize;
    }

    @Override
    public Vector3D apply(Vector3D vec) {
        double t = getNextRandom();
        Vector3D vector3D = vec.copy().add(startLocation);
        return new Vector3D(vector3D.getX() + getNextRandom(), vector3D.getY() + getNextRandom(), vector3D.getZ() + getNextRandom());
    }

    private double getNextRandom() {
        return r.nextDouble() * maxRandomSize * (r.nextBoolean() ? 1 : -1);
    }
}
