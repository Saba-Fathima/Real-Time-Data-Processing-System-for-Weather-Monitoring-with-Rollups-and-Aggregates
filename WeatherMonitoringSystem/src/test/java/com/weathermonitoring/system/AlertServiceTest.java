package com.weathermonitoring.system;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.weathermonitoring.systemmodel.WeatherData;
import com.weathermonitoring.systemservices.AlertService;

public class AlertServiceTest {
	private AlertService alertService;

    @BeforeEach
    void setUp() {
        alertService = new AlertService();
    }

    @Test
    void testTemperatureThresholdExceeded() {
        double threshold = 35.0;
        alertService.setTemperatureThreshold(threshold);

        WeatherData data1 = new WeatherData("Mumbai", 36.0, 37.0, "Clear", 1634764800);
        WeatherData data2 = new WeatherData("Mumbai", 34.0, 35.0, "Clouds", 1634768400);

        boolean alertTriggered1 = alertService.checkTemperatureThreshold(data1);
        boolean alertTriggered2 = alertService.checkTemperatureThreshold(data2);

        assertTrue(alertTriggered1);
        assertFalse(alertTriggered2);
    }

    @Test
    void testConsecutiveTemperatureThresholdExceeded() {
        double threshold = 35.0;
        alertService.setTemperatureThreshold(threshold);

        WeatherData data1 = new WeatherData("Mumbai", 36.0, 37.0, "Clear", 1634764800);
        WeatherData data2 = new WeatherData("Mumbai", 36.5, 38.0, "Clear", 1634768400);

        boolean alertTriggered1 = alertService.checkTemperatureThreshold(data1);
        boolean alertTriggered2 = alertService.checkTemperatureThreshold(data2);

        assertTrue(alertTriggered1);
        assertTrue(alertTriggered2);
    }

}
