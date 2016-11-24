package com.vidhur2k.Pulsar.calculations;

/**
 * Created by vidhur2k on 9/21/16.
 */
public class WaveEquationCalculations {

    public static double calcFreq(double velocity, double wavelength)
    {
        return velocity / wavelength;
    }

    public static double calcWavelength(double velocity, double freq)
    {
        return velocity / freq;
    }

    public static double calcVelocity(double freq, double wavelength)
    {
        return freq * wavelength;
    }
}
