package controller;

import java.util.Date;
import java.util.Calendar;

public class EndDate_Calculation {
	
	private Date startDate;
	private Date endDate;
	private Calendar calendar;
	
	@SuppressWarnings("deprecation")
	public void setStartDate(int year, int month, int date, int hour) {
		startDate = new Date(year, month, date, hour, 0);
	}
	
	private Date getEndDate(String period, String duration) {
		if((period.equalsIgnoreCase("Hour")) == true) {
		
		}
		else if(period == "Day") {
			
		}
		else if(period == "Week") {
			
		}
		else if(period == "Month") {
			
		}
		else if(period == "Semester") {
			
		}
		else if(period == "Year") {
			
		}
		
		return startDate;
	}
	
	
	private Date getEndDate(Date startDate, String period, String duration) {
		
		
		return endDate;
	}
	
}