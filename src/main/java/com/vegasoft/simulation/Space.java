package com.vegasoft.simulation;

import com.vegasoft.simulation.graphics.PhysicalBodyGraphics;
import com.vegasoft.simulation.graphics.SpaceGraphics;
import com.vegasoft.simulation.sim.PhysicalBodyFactoryForSpaceTelescopeWeber;
import com.vegasoft.simulation.sim.Simulation;
import com.vegasoft.simulation.sim.SimulationFactory;
import com.vegasoft.simulation.sim.SimulationFactoryCreator;
import com.vegasoft.simulation.util.FrequencyExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Space {
    private static final Logger logger = LoggerFactory.getLogger(Space.class);


    public static void main(String[] args) {
        logger.info("Starting simulation");
        SimulationFactory factory = SimulationFactoryCreator.createFactory(args);
        Simulation simulation = factory.createSimulation();
        FrequencyExecutor executor = new FrequencyExecutor(simulation, 0);
        PhysicalBodyGraphics physicalBodyGraphics = new PhysicalBodyGraphics(simulation::getPhysicalBodyListResult, PhysicalBodyFactoryForSpaceTelescopeWeber.MASS_SUN);
        new SpaceGraphics(physicalBodyGraphics, factory.getLocationScaleFactor()).run();
        executor.stop();
    }
}
