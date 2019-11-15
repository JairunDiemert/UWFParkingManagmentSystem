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
	
	private void setEndDate(String period, String duration, Date startDate) {
		if((period.equalsIgnoreCase("Hour")) == true) {
			addHours(startDate, Integer.parseInt(duration));
		}
		else if(period.equalsIgnoreCase("Day") == true) {
			
		}
		else if(period.equalsIgnoreCase("Week") == true) {
			
		}
		else if(period.equalsIgnoreCase("Month") == true) {
			
		}
		else if(period.equalsIgnoreCase("Semester") == true) {
			
		}
		else if(period.equalsIgnoreCase("Year") == true) {
			
		}
		
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public Date startDate() {
		return this.startDate;
	}

	private Date addHours(Date startDate, int hours) {
	    calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return calendar.getTime();
	}
	
	private Date addDays(Date startDate, int days) {
	    calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    //calendar.add(Calendar., days); //need to look up rest of method calls in API
	    return calendar.getTime();
	}
	
	
	
}