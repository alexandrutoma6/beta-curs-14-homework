package org.beta;

import org.assertj.core.api.Assertions;
import org.beta.convertors.TemperatureConvertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TeperatureConvertorTest {

    @Test
    @DisplayName("INSTANTIATE CLASS")
    public void instantiateClass(){
        TemperatureConvertor temperatureConvertor = new TemperatureConvertor();
    }
    
    @Test
    @DisplayName("CALL STATIC METHOD WITH A DOUBLE PARAMETER TO CONVERT FROM F->C")
    public void callFarenheitStaticMethodWithParameter(){
        TemperatureConvertor.fahrenheitToCelsius(22.4);
    }

    @Test
    @DisplayName("CALL STATIC METHOD WITH A DOUBLE PARAMETER TO CONVERT FROM C->F")
    public void callCelsiusStaticMethodWithParameter(){
        TemperatureConvertor.celsiusToFarenheit(22.4);
    }

    @Test
    @DisplayName("CONVERT CELSIUS TEMPERATURE TO FARENHEIT")
    public void convertCelsiusToFarenheit(){
        double result = TemperatureConvertor.celsiusToFarenheit(100);
        Assertions.assertThat(result).isEqualTo(212);
    }

    @Test
    @DisplayName("CONVERT FARENHEIT TEMPERATURE TO CELSIUS")
    public void convertFarenheitToCelsius(){
        double result = TemperatureConvertor.farenheitToCelsius(100);
        Assertions.assertThat(result).isEqualTo(37.777777778);
    }
}
