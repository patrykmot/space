package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.Particle;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ParticleFactoryParticlesTest {

    @Test
    public void testIt() {
        PhysicalBodyFactoryParticles factoryParticles = new PhysicalBodyFactoryParticles(new ParticleParams(10, 10, 10, 1));
        List<Particle> bodies = factoryParticles.createBodies();
        Assert.assertEquals(1000, bodies.size());
    }
}
