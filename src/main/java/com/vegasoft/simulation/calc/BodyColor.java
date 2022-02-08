package com.vegasoft.simulation.calc;

public class BodyColor {
    public final static BodyColor TURQUOISE = new BodyColor(44, 154, 176);
    public final static BodyColor TURQUOISE_YELLOW = new BodyColor(181, 181, 140);
    public final static BodyColor BLUE = new BodyColor(44, 94, 181);

    private float r, g, b;


    public BodyColor(int r, int g, int b) {
        this.r = r / 255f;
        this.g = g / 255f;
        this.b = b / 255f;
    }

    public BodyColor(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
}
