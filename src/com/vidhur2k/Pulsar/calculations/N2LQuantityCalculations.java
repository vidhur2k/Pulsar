package com.vidhur2k.Pulsar.calculations;

/**
 * Created by vidhur2k on 9/21/16.
 */
public class N2LQuantityCalculations {


    /**
     * Returns the Force applied.
     * @param mass
     * @param acceleration
     * @return
     */
    public static double calcForce(double mass, double acceleration)
    {
        return mass * acceleration;
    }

    /**
     * Returns the mass of the Object.
     * @param force
     * @param acceleration
     * @return
     */
    public static double calcMass(double force, double acceleration)
    {
        return force / acceleration;
    }

    /**
     * Returns the acceleration of the Object.
     * @param force
     * @param mass
     * @return
     */
    public static double calcAcceleration(double force, double mass)
    {
        return force / mass;
    }


}
