package com.weathermonitoring.systemrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.weathermonitoring.systemmodel.DailySummary;
import com.weathermonitoring.systemmodel.WeatherData;

public class WeatherRepository {
    // Oracle Database connection details
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Replace with your Oracle DB URL
    private static final String DB_USER = "SYSTEM"; // Replace with your Oracle DB username
    private static final String DB_PASSWORD = "saba"; // Replace with your Oracle DB password

    public void saveWeatherData(WeatherData data) {
        String insertSQL = "INSERT INTO weather_data (city, temp, feels_like, condition, timestamp) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, data.getCity());
            preparedStatement.setDouble(2, data.getTemp());
            preparedStatement.setDouble(3, data.getFeelsLike());
            preparedStatement.setString(4, data.getCondition());
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(data.getTimestamp() * 1000L));

            preparedStatement.executeUpdate();
            System.out.println("Weather data saved for city: " + data.getCity());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveDailySummary(DailySummary summary) {
        String insertSQL = "INSERT INTO daily_summary (avg_temp, max_temp, min_temp, dominant_condition) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setDouble(1, summary.getAvgTemp());
            preparedStatement.setDouble(2, summary.getMaxTemp());
            preparedStatement.setDouble(3, summary.getMinTemp());
            preparedStatement.setString(4, summary.getDominantCondition());

            preparedStatement.executeUpdate();
            System.out.println("Daily summary saved.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
