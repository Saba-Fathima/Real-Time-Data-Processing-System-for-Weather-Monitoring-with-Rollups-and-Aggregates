package com.weathermonitoring.systemcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.weathermonitoring.systemmodel.Weather;
import com.weathermonitoring.systemservices.WeatherService;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/coordinates/{lat}/{lon}")
    public Weather getWeatherByCoordinates(@PathVariable double lat, @PathVariable double lon) {
        Weather weather = weatherService.getWeatherByCoordinates(lat, lon);
        if (weather == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Weather data not found for the given coordinates");
        }
        return weather;
    }
}
