package org.beta.convertors;

import org.beta.exceptions.NullParameterException;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(Double temperatureFahrenheit) {
        if(temperatureFahrenheit == null){
            throw new NullParameterException("The parameter is null");
        }
        return (temperatureFahrenheit - 32) * 5 / 9;
    }


    public static double celsiusToFahrenheit(Double temperatureCelsius) {
        if(temperatureCelsius == null){
            throw new NullParameterException("The parameter is null");
        }
        return (temperatureCelsius * 9 / 5) + 32;
    }
}
