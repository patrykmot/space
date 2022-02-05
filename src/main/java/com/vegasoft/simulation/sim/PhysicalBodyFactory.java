package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.PhysicalBody;

import java.util.List;

public interface PhysicalBodyFactory {
    List<PhysicalBody> createBodies();

    double getLocationScaleFactor();
}
