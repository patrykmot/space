package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.BodyColor;
import com.vegasoft.simulation.calc.Vector3D;

import java.util.Optional;
import java.util.function.Function;

public class ParticleParams {
    private final int xCount;
    private final int yCount;
    private final int zCount;
    private final double length;
    private Function<Vector3D, Vector3D> locationFilter;
    private BodyColor particleBodyColor;

    public ParticleParams(int xCount, int yCount, int zCount, double length) {
        this.xCount = xCount;
        this.yCount = yCount;
        this.zCount = zCount;
        this.length = length;
    }

    public ParticleParams(int xCount, int yCount, int zCount, double length, Function<Vector3D, Vector3D> locationFilter) {
        this(xCount, yCount, zCount, length);
        this.locationFilter = locationFilter;
    }

    public ParticleParams(int xCount, int yCount, int zCount, double length, Function<Vector3D, Vector3D> locationFilter, BodyColor particleBodyColor) {
        this(xCount, yCount, zCount, length, locationFilter);
        this.particleBodyColor = particleBodyColor;
    }

    public Optional<Function<Vector3D, Vector3D>> getLocationFilter() {
        return Optional.ofNullable(locationFilter);
    }

    public Optional<BodyColor> getParticleBodyColor() {
        return Optional.ofNullable(particleBodyColor);
    }

    public int getXCount() {
        return xCount;
    }

    public int getYCount() {
        return yCount;
    }

    public int getZCount() {
        return zCount;
    }

    public double getLength() {
        return length;
    }
}
