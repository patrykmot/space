package com.vegasoft.simulation.sim;

import org.junit.Assert;
import org.junit.Test;

public class SimulationFactoryTest {

    @Test
    public void testIt() {
        Assert.assertNotNull(SimulationFactory.findFactory("SimMarkWeberTelescope"));
        Assert.assertNotNull(SimulationFactory.findFactory("SimParticlesWithGravity"));
        Assert.assertNotNull(SimulationFactory.findFactory("SimParticles"));
    }

}
