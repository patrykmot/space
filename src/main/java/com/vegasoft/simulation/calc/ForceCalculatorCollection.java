package com.vegasoft.simulation.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForceCalculatorCollection implements ForceCalculator {
    private List<ForceCalculator> calculators = new ArrayList<>();

    public ForceCalculatorCollection(ForceCalculator... forceCalcArray) {
        calculators.addAll(Arrays.asList(forceCalcArray));
    }

    public static ForceCalculator of(ForceCalculator... forceCalcArray) {
        return new ForceCalculatorCollection(forceCalcArray);
    }

    @Override
    public Vector3D calculateForceWhichAGetsFromB(PhysicalBody a, PhysicalBody b) {
        Vector3D force = new Vector3D();
        for (ForceCalculator fc : calculators) {
            force.add(fc.calculateForceWhichAGetsFromB(a, b));
        }
        return force;
    }
}
