package com.vegasoft.simulation.sim;

import com.vegasoft.simulation.calc.Particle;
import com.vegasoft.simulation.calc.Vector3D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PhysicalBodyFactoryParticles implements PhysicalBodyFactory {

    private ParticleParams pp;
    private static final AtomicInteger nameCount = new AtomicInteger(0);

    public PhysicalBodyFactoryParticles(ParticleParams particleParams) {
        this.pp = particleParams;
    }

    @Override
    public List<Particle> createBodies() {
        List<Particle> pbList = new ArrayList<>();

        for (int x = 0; x < pp.getXCount(); ++x) {
            for (int y = 0; y < pp.getYCount(); ++y) {
                for (int z = 0; z < pp.getZCount(); ++z) {
                    Particle pb = new Particle();
                    pb.setName(createName());
                    pb.setLocation(new Vector3D(x * pp.getLength(), y * pp.getLength(), z * pp.getLength()));
                    if (pp.getLocationFilter() != null) {
                        pb.setLocation(pp.getLocationFilter().apply(pb.getLocation()));
                    }
                    pbList.add(pb);
                }
            }
        }
        return pbList;
    }

    private String createName() {
        return "Particle " + nameCount.incrementAndGet();
    }

    @Override
    public double getLocationScaleFactor() {
        return 1;
    }
}
