package com.weathermonitoring.systemservices;

public class TemperatureConverter {
	 public static double kelvinToCelsius(double kelvin) {
	        return kelvin - 273.15;
	    }

	    public static double kelvinToFahrenheit(double kelvin) {
	        return (kelvin - 273.15) * 9/5 + 32;
	    }

}
