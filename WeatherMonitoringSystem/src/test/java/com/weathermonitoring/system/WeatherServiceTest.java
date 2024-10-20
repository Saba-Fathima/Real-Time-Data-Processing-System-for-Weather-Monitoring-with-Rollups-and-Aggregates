package com.weathermonitoring.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.weathermonitoring.systemmodel.WeatherData;
import com.weathermonitoring.systemservices.WeatherService;
import com.weathermonitoring.systemutil.JsonParser;

public class WeatherServiceTest {
    private WeatherService weatherService;
    private JsonParser jsonParser; // Assuming you have a JsonParser class

    @BeforeEach
    void setUp() {
        jsonParser = mock(JsonParser.class);
        weatherService = new WeatherService("9f5e0b1bdb6bdb602ed0222f0d200e88"); // Use a real or mock API key
    }

    @Test
    void testFetchWeatherData() {
        // Create an instance of WeatherData with expected values
        WeatherData expectedData = new WeatherData();
        expectedData.setCity("Mumbai");
        expectedData.setTemp(30.0);
        expectedData.setFeelsLike(32.0);
        expectedData.setCondition("Clear");
        expectedData.setTimestamp(1634764800);

        // Mock the behavior of the JsonParser if needed
        when(JsonParser.parseWeatherData(anyString())).thenReturn(expectedData);

        // Call the method under test
        WeatherData actualData = weatherService.fetchWeatherData("Mumbai");

        // Verify the result
        assertNotNull(actualData);
        assertEquals("Mumbai", actualData.getCity());
        assertEquals(30.0, actualData.getTemp());
        assertEquals(32.0, actualData.getFeelsLike());
        assertEquals("Clear", actualData.getCondition());
        assertEquals(1634764800, actualData.getTimestamp());

        verify(jsonParser, times(1));
		// Verify that the parseWeatherData method was called once
        JsonParser.parseWeatherData(anyString());
    }
}
