# Real-Time-Data-Processing-System-for-Weather-Monitoring-with-Rollups-and-Aggregates

//WeatherMonitoring
Weather Monitoring System

Overview

The Weather Monitoring System is a real-time application designed to fetch and display weather information for multiple cities using the OpenWeatherMap API. The system displays crucial weather data like temperature, feels-like temperature, wind speed, date, time, and conditions, providing users with updated information about various cities.

This application is built using a 3-tier architecture with the following components:

Frontend: HTML, CSS, and JavaScript for the user interface.
Backend: Java and Spring Boot for API handling and data processing.
Service Layer: Handles communication with the OpenWeatherMap API and processes the received data.
Features
Real-time Weather Updates: The system provides current weather data for cities, including Delhi, Mumbai, Chennai, Bangalore, Kolkata, and Hyderabad.
Data Display:
Temperature: The current temperature in Celsius.
Feels Like: The perceived temperature considering humidity and wind factors.
Weather Condition: A brief textual description (e.g., clear sky, rain).
Wind Speed: The speed of the wind in meters per second (m/s).
Date and Time: The timestamp when the data was fetched, formatted into a readable format.
User Interaction:
The application features a refresh button for users to update weather information manually, ensuring they receive the latest data.

Technologies Used

Frontend: HTML, CSS, JavaScript
Backend: Java, Spring Boot
API Integration: OpenWeatherMap API for real-time weather data
JSON Parsing: org.json.simple for handling API responses in JSON format

Project Structure

Frontend:

The frontend is built with HTML, CSS, and JavaScript to fetch and display weather data.
The application dynamically updates weather information for each city and includes a refresh button.

Backend:

Built using Java with Spring Boot, the backend handles requests from the frontend and processes them by interacting with the OpenWeatherMap API.
The backend retrieves weather data based on city coordinates or names and passes processed information back to the frontend.

Service Layer:

The service layer (WeatherService) fetches and processes weather data from the OpenWeatherMap API.
It extracts temperature, feels-like temperature, weather conditions, wind speed, and timestamps, converting them into a readable format.
Getting Started

Prerequisites:

Java 11 or higher
Maven
A valid API key from OpenWeatherMap

Installation

Clone the repository
Backend Setup:

Navigate to the backend directory and open it with your preferred IDE (e.g., IntelliJ, Eclipse,Spring).
Add your OpenWeatherMap API key in the WeatherService class (@Value("your-api-key")).
Build the project using Maven
Frontend Setup:Navigate to the frontend directory,Open index.html in your browser or start a simple HTTP server

Usage:

When the application is running, it will display weather information for the predefined cities.
Click the refresh button to manually update weather data and see the latest information.

Code Overview:

Frontend (JavaScript)
Makes API calls to the backend to fetch weather data.
Dynamically updates the DOM with the weather information for each city.
Implements a refresh button to fetch the latest weather data.
Backend (Java)
API Layer: Manages HTTP requests from the frontend, processes them, and sends requests to the OpenWeatherMap API.
Service Layer (WeatherService): Interacts with the API and extracts relevant data using JSON parsing.
Model Layer (WeatherData, Weather classes): Encapsulates weather data (temperature, wind speed, conditions, date, and time).

Error Handling

The application includes error handling for:
API Failures: If the API call fails, a message is displayed on the frontend indicating that the data could not be fetched.
Invalid Data: The service layer gracefully handles missing or malformed data to prevent application crashes.
