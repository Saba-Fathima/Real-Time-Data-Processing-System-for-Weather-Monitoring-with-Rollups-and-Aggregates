package com.weathermonitoring.systemmodel;

public class DailySummary {
	private double avgTemp;
	private double maxTemp;
	private double minTemp;
	private String dominantCondition;
	
	 // Getters and setters
	
	public double getAvgTemp() {
		return avgTemp;
	}
	public void setAvgTemp(double avgTemp) {
		this.avgTemp = avgTemp;
	}
	public double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}
	public String getDominantCondition() {
		return dominantCondition;
	}
	public void setDominantCondition(String dominantCondition) {
		this.dominantCondition = dominantCondition;
	}
	
	@Override
	public String toString() {
		return "DailySummary [avgTemp=" + avgTemp + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp
				+ ", dominantCondition=" + dominantCondition + "]";
	}
	
	public DailySummary(double avgTemp, double maxTemp, double minTemp, String dominantCondition) {
		super();
		this.avgTemp = avgTemp;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.dominantCondition = dominantCondition;
	}
	
	public DailySummary() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
