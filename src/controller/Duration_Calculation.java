package controller;

import java.util.*;

public class Duration_Calculation {
	
	private double hour = 1/24;
	private int	day = (int) (24 * hour);
	private int week = day * 7;
	private int month = week * 4;
	private int semester = month * 3;
	private int year = month * 12;
	
    /*
	startDate = "0/JAN/00"; // Day/Month/Year
	endDate = "0/JAN/00"; 
	setStartHour(00);
	setEndHour(00);*/
	
	public int getTotalPermitDurration(int multiplier, String choice) {
		int totalDays = 0;
		
		if (choice.charAt(0) == 'H') {
			totalDays = (int) (hour * multiplier);
		}
		if (choice.charAt(0) == 'D') {
			totalDays = day * multiplier;
		}
		if (choice.charAt(0) == 'W') {
			totalDays = week * multiplier;
		}
		if (choice.charAt(0) == 'M') {
			totalDays = month * multiplier;
		}
		if (choice.charAt(0) == 'S') {
			totalDays = semester * multiplier;
		}
		if (choice.charAt(0) == 'Y') {
			totalDays = year * multiplier;
		}
		
		return totalDays;
	}
	
	@SuppressWarnings("deprecation")
	public String getEndDate(Date startDate, int multiplier, String choice) {
		
		int durration = getTotalPermitDurration(multiplier, choice);
		int numberOfYearsToAdd = durration / year;
		durration = durration - (numberOfYearsToAdd * year);
		int numberOfMonthsToAdd = durration  / month;
		durration = durration - (numberOfMonthsToAdd * month);
		int numberOfDaysToAdd = durration / day;
		
		String date = "";
		
		date = date + (startDate.getDay() + numberOfDaysToAdd) + "/" + (startDate.getMonth() + numberOfMonthsToAdd) + "/" + (startDate.getYear() + numberOfMonthsToAdd);
		
		return date;
	}
	
}