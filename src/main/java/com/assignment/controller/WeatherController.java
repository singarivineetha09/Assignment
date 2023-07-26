package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.service.WeatherService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/getWeather")
    public String getWeather(@RequestParam("date") String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateString);
            return weatherService.getWeather(date);
        } catch (ParseException e) {
            return "Invalid date format. Please use yyyy-MM-dd HH:mm:ss.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/getWindSpeed")
    public String getWindSpeed(@RequestParam("date") String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateString);
            return weatherService.getWindSpeed(date);
        } catch (ParseException e) {
            return "Invalid date format. Please use yyyy-MM-dd HH:mm:ss.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/getPressure")
    public String getPressure(@RequestParam("date") String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dateString);
            return weatherService.getPressure(date);
        } catch (ParseException e) {
            return "Invalid date format. Please use yyyy-MM-dd HH:mm:ss.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}


