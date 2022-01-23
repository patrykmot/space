package com.vegasoft.simulation.graphics;

import com.vegasoft.simulation.calc.Vector3D;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glTranslated;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Quad {
    private Vector3D position;
    private float size;

    public Quad(Vector3D position, double size) {
        this.position = position;
        this.size = (float) size;
    }

    public void renderQuad() {
        // Render a color-cube consisting of 6 quads with different colors
        glTranslated(position.getX(), position.getY(), position.getZ());  // Move right and into the screen

        glBegin(GL_QUADS);                // Begin drawing the color cube with 6 quads
        // Top face (y = 1.0f)
        // Define vertices in counter-clockwise (CCW) order with normal pointing out
        glColor3f(0.0f, 1.0f, 0.0f);     // Green
        glVertex3f(size, size, -size);
        glVertex3f(-size, size, -size);
        glVertex3f(-size, size, size);
        glVertex3f(size, size, size);

        // Bottom face (y = -1.0f)
        glColor3f(1.0f, 0.5f, 0.0f);     // Orange
        glVertex3f(size, -size, size);
        glVertex3f(-size, -size, size);
        glVertex3f(-size, -size, -size);
        glVertex3f(size, -size, -size);

        // Front face  (z = 1.0f)
        glColor3f(1.0f, 0.0f, 0.0f);     // Red
        glVertex3f(size, size, size);
        glVertex3f(-size, size, size);
        glVertex3f(-size, -size, size);
        glVertex3f(size, -size, size);

        // Back face (z = -1.0f)
        glColor3f(1.0f, 1.0f, 0.0f);     // Yellow
        glVertex3f(size, -size, -size);
        glVertex3f(-size, -size, -size);
        glVertex3f(-size, size, -size);
        glVertex3f(size, size, -size);

        // Left face (x = -1.0f)
        glColor3f(0.0f, 0.0f, 1.0f);     // Blue
        glVertex3f(-size, size, size);
        glVertex3f(-size, size, -size);
        glVertex3f(-size, -size, -size);
        glVertex3f(-size, -size, size);

        // Right face (x = 1.0f)
        glColor3f(1.0f, 0.0f, 1.0f);     // Magenta
        glVertex3f(size, size, -size);
        glVertex3f(size, size, size);
        glVertex3f(size, -size, size);
        glVertex3f(size, -size, -size);
        glEnd();  // End of drawing color-cube
        return;
    }
}
