package com.vegasoft.simulation.calc;

public class Particle extends PhysicalBody {
    private Vector3D velocity = Vector3D.getZeroVec();
    private Vector3D force = Vector3D.getZeroVec();

    public Particle() {

    }

    public Particle(String name) {
        super(name);
    }

    public Particle(Particle b) {
        super(b);
        this.velocity = b.velocity.copy();
        this.force = b.force.copy();
    }

    public Vector3D getVelocity() {
        return velocity;
    }

    public Particle setVelocity(Vector3D velocity) {
        this.velocity = velocity;
        return this;
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
                ", velocity=" + velocity +
                ", force=" + force +
                '}';
    }
}
