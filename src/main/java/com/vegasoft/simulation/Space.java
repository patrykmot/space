package com.vegasoft.simulation;

import com.vegasoft.simulation.calc.ForceCalculator;
import com.vegasoft.simulation.calc.ForceCalculatorGravity;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolution;
import com.vegasoft.simulation.calc.NewtonEquationNumericalSolutionVerlet;
import com.vegasoft.simulation.calc.PhysicalBody;
import com.vegasoft.simulation.calc.PhysicalBodyFactoryForSpaceTelescopeWeber;
import com.vegasoft.simulation.calc.Simulation;
import com.vegasoft.simulation.graphics.PhysicalBodyGraphics;
import com.vegasoft.simulation.graphics.SpaceGraphics;
import com.vegasoft.simulation.util.FrequencyExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private static final Logger logger = LoggerFactory.getLogger(Space.class);


    public static void main(String[] args) {
        logger.info("Starting simulation");
        ForceCalculator forceCalculator = new ForceCalculatorGravity();
        NewtonEquationNumericalSolution numericalSolution = new NewtonEquationNumericalSolutionVerlet(0.25);
        List<PhysicalBody> physicalBodyList = new ArrayList<>();

//        PhysicalBody pb1 = new PhysicalBody().setLocation(Vector3D.create(5.3,0.3,0.3)).setM(1000).setVelocity(Vector3D.create(-0.00,0.00,0.002));
//        PhysicalBody pb2 = new PhysicalBody().setLocation(Vector3D.create(-3,0,0)).setM(1000000);
//
//        physicalBodyList.add(pb1);
//        physicalBodyList.add(pb2);

        PhysicalBodyFactoryForSpaceTelescopeWeber pbFactory = new PhysicalBodyFactoryForSpaceTelescopeWeber();
        physicalBodyList = pbFactory.createBodies();


        Simulation simulation = new Simulation(forceCalculator, numericalSolution, physicalBodyList);
        FrequencyExecutor executor = new FrequencyExecutor(simulation, 0);
        PhysicalBodyGraphics physicalBodyGraphics = new PhysicalBodyGraphics(simulation::getPhysicalBodyListResult, PhysicalBodyFactoryForSpaceTelescopeWeber.MASS_SUN);
        new SpaceGraphics(physicalBodyGraphics, pbFactory.getLocationScaleFactor()).run();
        executor.stop();
    }
}
