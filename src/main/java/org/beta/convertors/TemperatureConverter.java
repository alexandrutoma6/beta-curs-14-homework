package org.beta.convertors;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) * 5 / 9;
    }


    public static double celsiusToFahrenheit(double temperatureCelsius) {
        return (temperatureCelsius * 9 / 5) + 32;
    }
}
