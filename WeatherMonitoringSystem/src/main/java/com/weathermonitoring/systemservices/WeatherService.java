package com.weathermonitoring.systemservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.weathermonitoring.systemmodel.Weather;
import com.weathermonitoring.systemmodel.WeatherData;

@Service
public class WeatherService {
	 private final String apiKey;

	    // Constructor with @Value to inject API key
	    public WeatherService(@Value("9f5e0b1bdb6bdb602ed0222f0d200e88") String apiKey) {
	        this.apiKey = apiKey;
	    }

	    // Fetch weather data using latitude and longitude
	    public WeatherData fetchWeatherData(double lat, double lon) {
	        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey + "&units=metric";
	        
	        WeatherData weatherData = null;

	        try {
	            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
	            connection.setRequestMethod("GET");

	            // Check the response code
	            if (connection.getResponseCode() == 200) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                StringBuilder responseBuilder = new StringBuilder();
	                String inputLine;

	                while ((inputLine = in.readLine()) != null) {
	                    responseBuilder.append(inputLine);
	                }
	                in.close();

	                // Parse the JSON response
	                JSONParser parser = new JSONParser();
	                JSONObject jsonResponse = (JSONObject) parser.parse(responseBuilder.toString());

	                // Extract information from the JSON response
	                String cityName = (String) jsonResponse.get("name");
	                JSONObject main = (JSONObject) jsonResponse.get("main");
	                double temp = (double) main.get("temp");
	                double feelsLike = (double) main.get("feels_like");
	                JSONObject wind = (JSONObject) jsonResponse.get("wind");
	                double windSpeed = (double) wind.get("speed");

	                // Extract the timestamp and format it
	                long timestamp = (long) jsonResponse.get("dt");
	                String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp * 1000));
	                String formattedTime = new SimpleDateFormat("HH:mm:ss").format(new Date(timestamp * 1000));

	                // Create a WeatherData object and return it
	                weatherData = new WeatherData();
	                weatherData.setCity(cityName);
	                weatherData.setTemp(temp);
	                weatherData.setFeelsLike(feelsLike);
	                weatherData.setWindSpeed(windSpeed);
	                weatherData.setDate(formattedDate);
	                weatherData.setTime(formattedTime);

	                // Extract weather condition
	                JSONArray weatherArray = (JSONArray) jsonResponse.get("weather");
	                if (weatherArray != null && !weatherArray.isEmpty()) {
	                    weatherData.setCondition((String) ((JSONObject) weatherArray.get(0)).get("description"));
	                }

	            } else {
	                System.out.println("Error: Unable to fetch data for coordinates: " + lat + ", " + lon);
	            }

	        } catch (IOException | org.json.simple.parser.ParseException e) {
	            e.printStackTrace();
	        }

	        return weatherData; // Return the WeatherData object
	    }

	    // Method to get Weather by city
	    public Weather getWeatherByCoordinates(double lat, double lon) {
	        WeatherData weatherData = fetchWeatherData(lat, lon);
	        
	        if (weatherData == null) {
	            return null; // Handle as needed, possibly throw an exception
	        }

	        // Convert WeatherData to a Weather object
	        Weather weather = new Weather();
	        weather.setCity(weatherData.getCity());
	        weather.setTemperature(weatherData.getTemp());
	        weather.setFeelsLike(weatherData.getFeelsLike());
	        weather.setCondition(weatherData.getCondition());
	        weather.setWindSpeed(weatherData.getWindSpeed());
	        weather.setDate(weatherData.getDate());
	        weather.setTime(weatherData.getTime());
	        
	        return weather;
	    }

	    public Object getWeatherByCity(String city) {
	        // TODO Auto-generated method stub
	        return null;
	    }

	    public WeatherData fetchWeatherData(String string) {
	        // TODO Auto-generated method stub
	        return null;
	    }

}
