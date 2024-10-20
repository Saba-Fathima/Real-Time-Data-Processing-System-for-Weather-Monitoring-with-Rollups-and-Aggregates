package com.weathermonitoring.systemmodel;

public class Weather {
	 private String city;
	    private double temperature; // in Celsius
	    private String condition;
	    private double humidity;
	    private double windSpeed;
	    private String description;
	    private String date;
	    private String time;

	    // Default constructor
	    public Weather() {
	    }

	    // Parameterized constructor
	    public Weather(String city, double temperature, String condition, double humidity, double windSpeed, String description) {
	        this.city = city;
	        this.temperature = temperature;
	        this.condition = condition;
	        this.humidity = humidity;
	        this.windSpeed = windSpeed;
	        this.description = description;
	    }

	    // Getters and Setters
	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public double getTemperature() {
	        return temperature;
	    }

	    public void setTemperature(double temperature) {
	        this.temperature = temperature;
	    }

	    public String getCondition() {
	        return condition;
	    }

	    public void setCondition(String condition) {
	        this.condition = condition;
	    }

	    public double getHumidity() {
	        return humidity;
	    }

	    public void setHumidity(double humidity) {
	        this.humidity = humidity;
	    }

	    public double getWindSpeed() {
	        return windSpeed;
	    }

	    public void setWindSpeed(double windSpeed) {
	        this.windSpeed = windSpeed;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    // toString method for debugging
	    @Override
	    public String toString() {
	        return "Weather{" +
	                "city='" + city + '\'' +
	                ", temperature=" + temperature +
	                ", condition='" + condition + '\'' +
	                ", humidity=" + humidity +
	                ", windSpeed=" + windSpeed +
	                ", description='" + description + '\'' +
	                 ", date='" + date + '\'' +
            ", time='" + time + '\'' +
	                '}';
	    }

		public void setFeelsLike(double feelsLike) {
			// TODO Auto-generated method stub
			
		}

		public void setTimestamp(long timestamp) {
			// TODO Auto-generated method stub
			
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
}
