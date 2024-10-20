package com.weathermonitoring.systemweather;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.weathermonitoring.systemmodel.WeatherData;
import com.weathermonitoring.systemservices.AlertService;
import com.weathermonitoring.systemservices.DailySummaryService;
import com.weathermonitoring.systemservices.TemperatureConverter;
import com.weathermonitoring.systemservices.WeatherService;

public class WeatherApp {

    public static void main(String[] args) {
        // Initialize the WeatherService with your actual API key
        String apiKey = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key
        double[][] cityCoordinates = {
            {28.6139, 77.2090}, // Delhi
            {19.0760, 72.8777}, // Mumbai
            {13.0827, 80.2707}, // Chennai
            {12.9716, 77.5946}, // Bangalore
            {22.5726, 88.3639}, // Kolkata
            {17.3850, 78.4867}  // Hyderabad
        };
        String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

        // Create instances of services
        WeatherService weatherService = new WeatherService(apiKey);
        DailySummaryService summaryService = new DailySummaryService();
        AlertService alertService = new AlertService(35.0); // Example threshold for alerts

        // Timer to schedule weather data updates every 5 minutes
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < cities.length; i++) {
                    String city = cities[i];
                    double lat = cityCoordinates[i][0];
                    double lon = cityCoordinates[i][1];

                    // Fetch weather data for the city using coordinates
                    WeatherData weatherData = weatherService.fetchWeatherData(lat, lon);

                 // Inside your for loop where you're fetching the weather data

                    if (weatherData != null) {
                        // Extract temperature and weather condition
                        JSONObject main = (JSONObject) ((Map<?, ?>) weatherData).get("main");
                        double tempKelvin = ((Number) main.get("temp")).doubleValue();
                        double feelsLikeKelvin = ((Number) main.get("feels_like")).doubleValue(); // New line
                        double tempCelsius = TemperatureConverter.kelvinToCelsius(tempKelvin);
                        double feelsLikeCelsius = TemperatureConverter.kelvinToCelsius(feelsLikeKelvin); // New line

                        JSONArray weatherArray = (JSONArray) ((Map<?, ?>) weatherData).get("weather");
                        String condition = "";
                        if (weatherArray != null && !weatherArray.isEmpty()) {
                            JSONObject weatherObject = (JSONObject) weatherArray.get(0);
                            condition = (String) weatherObject.get("main");
                        }

                        // Extracting the time of data update
                        long dt = ((Number) weatherData.get("dt")).longValue(); // New line

                        // Add the weather data to the summary and check for alerts
                        summaryService.addWeatherData(city, tempCelsius, condition);
                        alertService.checkForAlerts(tempCelsius, city);

                        // Print out the weather information for the city
                        System.out.println("City: " + city);
                        System.out.println("Temperature (Celsius): " + tempCelsius);
                        System.out.println("Feels Like (Celsius): " + feelsLikeCelsius); // New line
                        System.out.println("Weather Condition: " + condition);
                        System.out.println("Data Updated At: " + dt); // New line
                        System.out.println("-------------------------------");
                    } else {
                        System.out.println("No weather data available for city: " + city);
                    }

                }
            }
        }, 0, 300000); // Every 5 minutes (300,000 milliseconds)
    }
}
