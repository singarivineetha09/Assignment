package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.assignment.controller.WeatherController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class WeatherConsoleApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WeatherConsoleApp.class, args);

        WeatherController weatherController = context.getBean(WeatherController.class);
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            printMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the date (yyyy-MM-dd): ");
                    String dateString = scanner.next();
                    try {
                        String weatherResult = weatherController.getWeather(dateString);
                        System.out.println(weatherResult);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter the date (yyyy-MM-dd): ");
                    dateString = scanner.next();
                    try {
                        String windSpeedResult = weatherController.getWindSpeed(dateString);
                        System.out.println(windSpeedResult);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter the date (yyyy-MM-dd): ");
                    dateString = scanner.next();
                    try {
                        String pressureResult = weatherController.getPressure(dateString);
                        System.out.println(pressureResult);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    // Example of checking weather for a random date
                    String randomDate = getRandomDateString();
                    try {
                        String weatherResult = weatherController.getWeather(randomDate);
                        System.out.println("Random date: " + randomDate);
                        System.out.println(weatherResult);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
        context.close();
    }

    private static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Get weather");
        System.out.println("2. Get Wind Speed");
        System.out.println("3. Get Pressure");
        System.out.println("4. Get Weather for a Random Date");
        System.out.println("0. Exit");
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateString);
    }

    private static String getRandomDateString() {
        Random random = new Random();
        int year = random.nextInt(3) + 2020; // Random year between 2020 and 2022
        int month = random.nextInt(12) + 1; // Random month between 1 and 12
        int day = random.nextInt(28) + 1; // Random day between 1 and 28

        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
