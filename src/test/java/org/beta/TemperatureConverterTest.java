package org.beta;

import org.assertj.core.data.Offset;
import org.beta.convertors.TemperatureConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TemperatureConverterTest {

    @Test
    @DisplayName("INSTANTIATE CLASS")
    public void instantiateClass() {
        TemperatureConverter temperatureConverter = new TemperatureConverter();
    }

    @Test
    @DisplayName("CALL STATIC METHOD WITH A DOUBLE PARAMETER TO CONVERT FROM F->C")
    public void callFahrenheitStaticMethodWithParameter() {
        TemperatureConverter.fahrenheitToCelsius(22.4);
    }

    @Test
    @DisplayName("CALL STATIC METHOD WITH A DOUBLE PARAMETER TO CONVERT FROM C->F")
    public void callCelsiusStaticMethodWithParameter() {
        TemperatureConverter.celsiusToFahrenheit(22.4);
    }

    @Test
    @DisplayName("CONVERT CELSIUS TEMPERATURE TO FAHRENHEIT")
    public void convertCelsiusToFahrenheit() {
        double result = TemperatureConverter.celsiusToFahrenheit(100);
        Assertions.assertThat(result).isEqualTo(212);
    }

    @Test
    @DisplayName("CONVERT FAHRENHEIT TEMPERATURE TO CELSIUS")
    public void convertFahrenheitToCelsius() {
        double result = TemperatureConverter.fahrenheitToCelsius(100);
        Assertions.assertThat(result).isCloseTo(37.78, Offset.offset(0.01));
    }
}
