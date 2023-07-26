package com.assignment.dto;

import java.time.LocalDateTime;

public class WeatherData {

	private LocalDateTime date;
	private double temperature;
	private double windSpeed;
	private double pressure;

	public WeatherData() {
		super();
	}

	public WeatherData(LocalDateTime date, double temperature, double windSpeed, double pressure) {
		super();
		this.date = date;
		this.temperature = temperature;
		this.windSpeed = windSpeed;
		this.pressure = pressure;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		return "WeatherData [date=" + date + ", temperature=" + temperature + ", windSpeed=" + windSpeed + ", pressure="
				+ pressure + "]";
	}

}
