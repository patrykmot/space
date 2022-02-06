package com.vegasoft.simulation.calc;

public class PhysicalBody {
    private String name;
    private double m = 1.0;
    private Vector3D location = Vector3D.getZeroVec();

    public PhysicalBody() {
    }

    public PhysicalBody(String name) {
        this.name = name;
    }

    public PhysicalBody(PhysicalBody b) {
        this.m = b.m;
        this.name = b.name;
        this.location = b.location.copy();
    }

    public Vector3D getLocation() {
        return location;
    }

    public PhysicalBody setLocation(Vector3D location) {
        this.location = location;
        return this;
    }

    public double getM() {
        return m;
    }

    public PhysicalBody setM(double m) {
        this.m = m;
        return this;
    }

    public String getName() {
        return name;
    }

    public PhysicalBody setName(String name) {
        this.name = name;
        return this;
    }

    public Vector3D calculateDistanceTo(PhysicalBody physicalBody) {
        Vector3D difR = getLocation().copy().subtract(physicalBody.getLocation());
        return difR;
    }


    @Override
    public String toString() {
        return "Body{" +
                "name='" + name + '\'' +
                ", m=" + m +
                '}';
    }
}
