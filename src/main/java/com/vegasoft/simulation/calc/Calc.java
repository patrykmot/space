package com.vegasoft.simulation.calc;

import org.apache.commons.math3.util.FastMath;

public class Calc {
    public final static double PI = Math.PI;
    public final static double PI_180 = PI / 180;

    public static double degreeToRadians(double degree) {
        // https://www.rapidtables.com/convert/number/degrees-to-radians.html
        // degree =
        return PI_180 * degree;
    }

    /**
     * @param thetaAngle from 0 to 2 pi -> for x,y plane
     * @param phiAngle   from 0 to pi -> x axis angle
     * @param r          size of sphere
     * @return cartesian coordinates calculation
     */
    public static Vector3D sphereToCartesianCoordinates(double thetaAngle, double phiAngle, double r) {
        // https://mathworld.wolfram.com/SphericalCoordinates.html
        return new Vector3D(
                // x	=	r cos theta sin phi
                r * FastMath.cos(thetaAngle) * FastMath.sin(phiAngle),
                // y	=	r sin theta sin phi
                r * FastMath.sin(thetaAngle) * FastMath.sin(phiAngle),
                // z	=	r cos phi.
                r * FastMath.cos(phiAngle)
        );
    }
}
