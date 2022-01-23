package com.vegasoft.simulation.calc;

public class PhysicalBody {
    private String name;
    private double m = 1.0;
    private Vector3D location = Vector3D.getZeroVec();
    private Vector3D velocity = Vector3D.getZeroVec();
    private Vector3D force = Vector3D.getZeroVec();

    public PhysicalBody() {
    }

    public PhysicalBody(String name) {
        this.name = name;
    }

    public PhysicalBody(PhysicalBody b) {
        this.m = b.m;
        this.location = Vector3D.convert(b.location.copy());
        this.velocity = Vector3D.convert(b.velocity.copy());
        this.force = Vector3D.convert(b.force.copy());
        this.name = b.name;
    }

    public double getM() {
        return m;
    }

    public PhysicalBody setM(double m) {
        this.m = m;
        return this;
    }

    public Vector3D getLocation() {
        return location;
    }

    public PhysicalBody setLocation(Vector3D location) {
        this.location = location;
        return this;
    }

    public Vector3D getVelocity() {
        return velocity;
    }

    public PhysicalBody setVelocity(Vector3D velocity) {
        this.velocity = velocity;
        return this;
    }

    public Vector3D getForce() {
        return force;
    }

    public PhysicalBody setForce(Vector3D force) {
        this.force = force;
        return this;
    }

    public String getName() {
        return name;
    }

    public PhysicalBody setName(String name) {
        this.name = name;
        return this;
    }

    public void addForce(Vector3D f) {
        force = Vector3D.convert(force.add(f));
    }

    public void subtractForce(Vector3D f) {
        force = Vector3D.convert(force.subtract(f));
    }

    @Override
    public String toString() {
        return "PhysicalBody{" +
                "name='" + name + '\'' +
                ", m=" + m +
                ", location=" + location +
                ", velocity=" + velocity +
                ", force=" + force +
                '}';
    }
}
