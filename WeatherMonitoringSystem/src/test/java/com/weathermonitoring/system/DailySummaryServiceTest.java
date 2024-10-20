package com.weathermonitoring.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.weathermonitoring.systemmodel.DailySummary;
import com.weathermonitoring.systemmodel.WeatherData;
import com.weathermonitoring.systemservices.DailySummaryService;

public class DailySummaryServiceTest {
	private DailySummaryService dailySummaryService;

    @BeforeEach
    void setUp() {
        dailySummaryService = new DailySummaryService();
    }

    @Test
    void testComputeDailySummary() {
        List<WeatherData> weatherDataList = new ArrayList<>();
        WeatherData data1 = new WeatherData("Mumbai", 30.0, 32.0, "Clear", 1634764800);
        WeatherData data2 = new WeatherData("Mumbai", 32.0, 34.0, "Clear", 1634768400);
        WeatherData data3 = new WeatherData("Mumbai", 28.0, 30.0, "Clouds", 1634772000);

        weatherDataList.add(data1);
        weatherDataList.add(data2);
        weatherDataList.add(data3);

        DailySummary summary = dailySummaryService.computeDailySummary(weatherDataList);

        assertNotNull(summary);
        assertEquals(30.0, summary.getAvgTemp(), 0.01);
        assertEquals(32.0, summary.getMaxTemp(), 0.01);
        assertEquals(28.0, summary.getMinTemp(), 0.01);
        assertEquals("Clear", summary.getDominantCondition());
    }

}
