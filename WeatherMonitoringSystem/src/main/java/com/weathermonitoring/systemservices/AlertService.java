package com.weathermonitoring.systemservices;

import com.weathermonitoring.systemmodel.WeatherData;

public class AlertService {
	 private double thresholdTemp;

	    public AlertService(double thresholdTemp) {
	        this.thresholdTemp = thresholdTemp;
	    }

	    public AlertService() {
			// TODO Auto-generated constructor stub
	    	 this.thresholdTemp = 35.0; // Default threshold value (can be customized)
		}

		public void checkForAlerts(double temp, String city) {
			 if (temp > thresholdTemp) {
		            System.out.println("ALERT: Temperature exceeded " + thresholdTemp + "°C in " + city);
		        }
	    }

		public boolean checkTemperatureThreshold(WeatherData weatherData) {
			// TODO Auto-generated method stub
			 if (weatherData.getTemp() > thresholdTemp) {
		            System.out.println("ALERT: Temperature exceeded threshold in " + weatherData.getCity());
		            return true;
		        }
		        return false;
		}

		public void setTemperatureThreshold(double threshold) {
			// TODO Auto-generated method stub
		     this.thresholdTemp = threshold;
		        System.out.println("Temperature threshold set to: " + threshold + "°C");
		    }			
		}


