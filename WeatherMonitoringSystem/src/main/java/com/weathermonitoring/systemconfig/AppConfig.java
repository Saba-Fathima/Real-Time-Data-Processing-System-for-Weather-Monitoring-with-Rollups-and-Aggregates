package com.weathermonitoring.systemconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	  private String apiKey;
	    private String[] cities = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};
	    private int interval;

	    public AppConfig() {
	        Properties props = new Properties();
	        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
	            if (input == null) {
	                System.out.println("Sorry, unable to find application.properties");
	                return;
	            }
	            props.load(input);
	            this.apiKey = props.getProperty("api.key");
	            this.interval = Integer.parseInt(props.getProperty("api.interval"));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }

	    public String getApiKey() {
	        return apiKey;
	    }

	    public String[] getCities() {
	        return cities;
	    }

	    public int getInterval() {
	        return interval;
	    }
}
