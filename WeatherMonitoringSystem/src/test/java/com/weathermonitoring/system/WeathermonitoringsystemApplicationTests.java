package com.weathermonitoring.system;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.weathermonitoring.systemmodel.Weather;
import com.weathermonitoring.systemservices.WeatherService;

@SpringBootTest
@AutoConfigureMockMvc
class WeathermonitoringsystemApplicationTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WeatherService weatherService; // Assuming you have WeatherService

    @BeforeEach
    void setUp() {
        // Resetting mock behavior before each test
        Mockito.reset(weatherService);
    }

    @Test
    void contextLoads() {
    }

    @Test
    void getWeather_ShouldReturnWeatherDetails_WhenCityIsValid() throws Exception {
        // Given
        String city = "Delhi";
        Weather weather = new Weather(); // Use the Weather object instead of WeatherApp
        weather.setCity(city);
        weather.setTemperature(30.0); // Set temperature (update to match method name in Weather class)
        weather.setCondition("Clear Sky"); // Set weather condition

        when(weatherService.getWeatherByCity(city)).thenReturn(weather);

        // When & Then
        mockMvc.perform(get("/weather/{city}", city)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.city").value(city)) // Expect city name in response
                .andExpect(jsonPath("$.temp").value(30.0)) // Expect temperature in response
                .andExpect(jsonPath("$.condition").value("Clear Sky")); // Expect weather condition in response
    }

    @Test
    void getWeather_ShouldReturn404_WhenCityIsInvalid() throws Exception {
        // Given
        String invalidCity = "InvalidCity";

        when(weatherService.getWeatherByCity(invalidCity)).thenReturn(null);

        // When & Then
        mockMvc.perform(get("/weather/{city}", invalidCity)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
