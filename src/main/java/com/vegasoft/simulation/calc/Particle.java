package com.vegasoft.simulation.calc;

public class Particle extends PhysicalBody {
    private Vector3D force = Vector3D.getZeroVec();

    public Particle() {

    }

    public Particle(String name) {
        super(name);
    }

    public Particle(Particle b) {
        super(b);
        this.force = b.force.copy();
    }

    public Vector3D getForce() {
        return force;
    }

    public Particle setForce(Vector3D force) {
        this.force = force;
        return this;
    }


    public void addForce(Vector3D f) {
        force.add(f);
    }

    public void subtractForce(Vector3D f) {
        force.subtract(f);
    }

    @Override
    public String toString() {
        return "PhysicalBody{" +
                "location=" + getLocation() +
                ", velocity=" + getVelocity() +
                ", force=" + force +
                '}';
    }
}
