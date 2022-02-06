package com.vegasoft.simulation.calc;

public class Vector3D {

    private static final Vector3D ZERO_VEC = new Vector3D(0.0, 0.0, 0.0);
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    public Vector3D() {

    }

    public static Vector3D getZeroVec() {
        return ZERO_VEC.copy();
    }

    public Vector3D copy() {
        return new Vector3D(x, y, z);
    }


    public static Vector3D create(double x, double y, double z) {
        return new Vector3D(x, y, z);
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getLength() {
        return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }

    public Vector3D normalize() {
        Vector3D vec = copy();
        double length = getLength();
        assert length > 0.0;
        vec.setX(getX() / length);
        vec.setY(getY() / length);
        vec.setZ(getZ() / length);
        return vec;
    }

    public Vector3D subtract(Vector3D vec) {
        x -= vec.x;
        y -= vec.y;
        z -= vec.z;
        return this;
    }

    public Vector3D mapMultiply(double value) {
        x *= value;
        y *= value;
        z *= value;
        return this;
    }

    public Vector3D add(Vector3D vec) {
        x += vec.x;
        y += vec.y;
        z += vec.z;
        return this;
    }

    public Vector3D mapDivide(Double value) {
        x /= value;
        y /= value;
        z /= value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3D vector3D = (Vector3D) o;

        if (Double.compare(vector3D.x, x) != 0) return false;
        if (Double.compare(vector3D.y, y) != 0) return false;
        return Double.compare(vector3D.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double multiply(Vector3D vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }
}
