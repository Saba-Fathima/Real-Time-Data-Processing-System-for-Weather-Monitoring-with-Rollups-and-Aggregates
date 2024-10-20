package com.weathermonitoring.systemutil;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.weathermonitoring.systemmodel.WeatherData;

public class JsonParser {

    public static WeatherData parseWeatherData(String jsonResponse) {
        WeatherData weatherData = new WeatherData();

        try {
            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            // Extract city name
            String city = (String) jsonObject.get("name");
            weatherData.setCity(city);

            // Extract temperature and feels_like (in Kelvin, convert to Celsius)
            JSONObject main = (JSONObject) jsonObject.get("main");
            double tempKelvin = ((Number) main.get("temp")).doubleValue();
            double feelsLikeKelvin = ((Number) main.get("feels_like")).doubleValue();

            // Convert temperature from Kelvin to Celsius
            double tempCelsius = convertKelvinToCelsius(tempKelvin);
            double feelsLikeCelsius = convertKelvinToCelsius(feelsLikeKelvin);
            weatherData.setTemp(tempCelsius);
            weatherData.setFeelsLike(feelsLikeCelsius);

            // Extract the main weather condition
            JSONArray weatherArray = (JSONArray) jsonObject.get("weather");
            if (weatherArray != null && !weatherArray.isEmpty()) {
                JSONObject weather = (JSONObject) weatherArray.get(0);
                String condition = (String) weather.get("main");
                weatherData.setCondition(condition);
            }

            // Extract the timestamp
            long timestamp = ((Number) jsonObject.get("dt")).longValue();
            weatherData.setTimestamp(timestamp);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weatherData;
    }

    private static double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
