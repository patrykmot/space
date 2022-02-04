package com.vegasoft.simulation.calc;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

public class Vector3D extends ArrayRealVector {

    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    private static final Vector3D ZERO_VEC = new Vector3D(0.0, 0.0, 0.0);

    public Vector3D(double x, double y, double z) {
        super(3);
        setX(x);
        setY(y);
        setZ(z);
    }

    public Vector3D(ArrayRealVector vector) {
        super(vector);
    }

    public Vector3D(RealVector vector) {
        super(vector);
    }

    public static Vector3D convert(ArrayRealVector vector) {
        return new Vector3D(vector);
    }

    public static Vector3D getZeroVec() {
        return new Vector3D(ZERO_VEC.copy());
    }

    public static Vector3D convert(RealVector mapMultiply) {
        return new Vector3D(mapMultiply);
    }

    public static Vector3D create(double x, double y, double z) {
        return new Vector3D(x, y, z);
    }

    public static Vector3D create(RealVector vector) {
        return new Vector3D(vector);
    }


    public double getX() {
        return getEntry(X);
    }

    public double getY() {
        return getEntry(Y);
    }

    public double getZ() {
        return getEntry(Z);
    }

    public void setX(double x) {
        setEntry(X, x);
    }

    public void setY(double y) {
        setEntry(Y, y);
    }

    public void setZ(double z) {
        setEntry(Z, z);
    }

    public double getLength() {
        return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }

    public Vector3D normalize() {
        Vector3D vec = new Vector3D(this);
        double length = getLength();
        assert length > 0.0;
        vec.setX(getX() / length);
        vec.setY(getY() / length);
        vec.setZ(getZ() / length);
        return vec;
    }
}
