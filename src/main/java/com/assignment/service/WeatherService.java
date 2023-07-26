package com.assignment.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WeatherService {

    private final String apiKey = "b6907d289e10d714a6e88b30761fae22";
    private final String baseUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us";

    public String getWeather(Date date) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseUrl + "&appid=" + apiKey);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(result.toString());
            JsonNode list = root.get("list");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (JsonNode entry : list) {
                Date entryDate = sdf.parse(entry.get("dt_txt").asText());
                if (entryDate.equals(date)) {
                    double temperature = entry.get("main").get("temp").asDouble() - 273.15; // Convert to Celsius
                    return "Temperature for " + date + " is " + String.format("%.2f", temperature) + " °C";
                }
            }

            return "No data available for the specified date.";
        }
    }

    public String getWindSpeed(Date date) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseUrl + "&appid=" + apiKey);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(result.toString());
            JsonNode list = root.get("list");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (JsonNode entry : list) {
                Date entryDate = sdf.parse(entry.get("dt_txt").asText());
                if (entryDate.equals(date)) {
                    double windSpeed = entry.get("wind").get("speed").asDouble();
                    return "Wind Speed for " + date + " is " + String.format("%.2f", windSpeed) + " m/s";
                }
            }

            return "No data available for the specified date.";
        }
    }

    public String getPressure(Date date) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseUrl + "&appid=" + apiKey);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(result.toString());
            JsonNode list = root.get("list");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (JsonNode entry : list) {
                Date entryDate = sdf.parse(entry.get("dt_txt").asText());
                if (entryDate.equals(date)) {
                    double pressure = entry.get("main").get("pressure").asDouble();
                    return "Pressure for " + date + " is " + String.format("%.2f", pressure) + " hPa";
                }
            }

            return "No data available for the specified date.";
        }
    }
}

