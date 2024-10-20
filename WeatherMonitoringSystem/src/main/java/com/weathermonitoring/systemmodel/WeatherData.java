package com.weathermonitoring.systemmodel;

public class WeatherData {
	   private String city;
	    private double temp;
	    private double feelsLike;
	    private String condition;
	    private long timestamp;
	    private String date;
	    private String time;
	    private double windSpeed;

	    
	    // Getters and setters
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public double getFeelsLike() {
			return feelsLike;
		}
		public void setFeelsLike(double feelsLike) {
			this.feelsLike = feelsLike;
		}
		public long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		
		
		
		@Override
		public String toString() {
			return "WeatherData [city=" + city + ", temp=" + temp + ", feelsLike=" + feelsLike + ", condition="
					+ condition + ", timestamp=" + timestamp + ", date=" + date + ", time=" + time + ", windSpeed="
					+ windSpeed + "]";
		}
		
		
		public WeatherData(String city, double temp, double feelsLike, String condition, long timestamp, String date,
				String time, double windSpeed) {
			super();
			this.city = city;
			this.temp = temp;
			this.feelsLike = feelsLike;
			this.condition = condition;
			this.timestamp = timestamp;
			this.date = date;
			this.time = time;
			this.windSpeed = windSpeed;
		}
		
		public WeatherData() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Number get(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public double getWindSpeed() {
			return windSpeed;
		}
		public void setWindSpeed(double windSpeed) {
			this.windSpeed = windSpeed;
		}		
}
