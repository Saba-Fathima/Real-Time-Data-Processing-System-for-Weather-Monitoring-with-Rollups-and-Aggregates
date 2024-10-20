package com.weathermonitoring.system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.weathermonitoring.systemservices.TemperatureConverter;

public class TemperatureConverterTest {
	@Test
    void testConvertKelvinToCelsius() {
        double kelvin = 300.0;
        double expectedCelsius = 26.85; // (300 - 273.15)
        
        double actualCelsius = TemperatureConverter.kelvinToCelsius(kelvin);
        
        assertEquals(expectedCelsius, actualCelsius, 0.01);
    }

    @Test
    void testConvertKelvinToFahrenheit() {
        double kelvin = 300.0;
        double expectedFahrenheit = 80.33; // ((300 - 273.15) * 9/5) + 32
        
        double actualFahrenheit = TemperatureConverter.kelvinToFahrenheit(kelvin);
        
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.01);
    }

}
