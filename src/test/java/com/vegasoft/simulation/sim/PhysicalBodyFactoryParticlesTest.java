package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.PhysicalBody;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PhysicalBodyFactoryParticlesTest {

    @Test
    public void testIt() {
        PhysicalBodyFactoryParticles factoryParticles = new PhysicalBodyFactoryParticles(new ParticleParams(10, 10, 10, 1));
        List<PhysicalBody> bodies = factoryParticles.createBodies();
        Assert.assertEquals(1000, bodies.size());
    }
}
