package com.weathermonitoring.systemservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weathermonitoring.systemmodel.DailySummary;
import com.weathermonitoring.systemmodel.WeatherData;

public class DailySummaryService {

    public DailySummary computeDailySummary(List<WeatherData> weatherDataList) {
        if (weatherDataList == null || weatherDataList.isEmpty()) {
            throw new IllegalArgumentException("Weather data list cannot be empty.");
        }

        double sumTemp = 0.0;
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        Map<String, Integer> conditionCount = new HashMap<>();

        for (WeatherData data : weatherDataList) {
            double temp = data.getTemp();
            sumTemp += temp;
            maxTemp = Math.max(maxTemp, temp);
            minTemp = Math.min(minTemp, temp);

            // Count weather conditions to determine the most frequent one
            String condition = data.getCondition();
            conditionCount.put(condition, conditionCount.getOrDefault(condition, 0) + 1);
        }

        double avgTemp = sumTemp / weatherDataList.size();
        String dominantCondition = determineDominantCondition(conditionCount);

        DailySummary summary = new DailySummary();
        summary.setAvgTemp(avgTemp);
        summary.setMaxTemp(maxTemp);
        summary.setMinTemp(minTemp);
        summary.setDominantCondition(dominantCondition);

        return summary;
    }

    private String determineDominantCondition(Map<String, Integer> conditionCount) {
        String dominantCondition = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : conditionCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                dominantCondition = entry.getKey();
            }
        }
        return dominantCondition;
    }

	public void addWeatherData(String city, double tempCelsius, String condition) {
		// TODO Auto-generated method stub
		
	}
	

}
