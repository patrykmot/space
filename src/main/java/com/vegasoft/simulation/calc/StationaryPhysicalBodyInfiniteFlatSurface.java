package com.vegasoft.simulation.calc;

public class StationaryPhysicalBodyInfiniteFlatSurface extends StationaryPhysicalBody {
    private Vector3D direction;

    public StationaryPhysicalBodyInfiniteFlatSurface(Vector3D location, Vector3D direction) {
        setLocation(location);
        this.direction = direction.copy().normalize();
    }

    @Override
    public Vector3D calculateDistanceTo(PhysicalBody physicalBody) {
        double distance = physicalBody.getLocation().copy().subtract(getLocation()).multiply(direction);
        return direction.copy().mapMultiply(distance * -1);
    }
}
