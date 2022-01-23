package com.vegasoft.simulation.graphics;

import com.vegasoft.simulation.calc.PhysicalBody;
import com.vegasoft.simulation.calc.PhysicalBodySource;
import com.vegasoft.simulation.calc.Vector3D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScaled;
import static org.lwjgl.opengl.GL11.glTranslated;

public class PhysicalBodyGraphics implements Graphics {
    private static final Logger logger = LoggerFactory.getLogger(PhysicalBodyGraphics.class);
    private PhysicalBodySource physicalBodySource;
    private double maxMass;
    private double minScale = 0.1;

    public PhysicalBodyGraphics(PhysicalBodySource physicalBodySource, double maxMass) {
        this.physicalBodySource = physicalBodySource;
        this.maxMass = maxMass;
    }

    public void draw(GraphicAssistance graphicAssistance, Double locationScaleFactor) {
        physicalBodySource.getPhysicalBodies().forEach(pb -> {
            Vector3D location = pb.getLocation();
            if (locationScaleFactor != null) {
                location = Vector3D.convert(location.mapDivide(locationScaleFactor));
            }
            glPushMatrix();
            glTranslated(location.getX(), location.getY(), location.getZ());
            setScale(pb);
            graphicAssistance.drawCubePlease();
            glPopMatrix();
        });
    }

    private void setScale(PhysicalBody pb) {
        double coeff = ((pb.getM() / maxMass + 1));
        double scale = Math.max(Math.log(coeff), minScale);
        scale = Math.min(scale, 1.0);
        if (scale < 1.0) {
            glScaled(scale, scale, scale);
        }
    }
}
