package controller;

import java.util.Date;
import java.util.Calendar;

public class EndDate_Calculation {
	
	private Date startDate;
	private Date endDate;
	private Calendar calendar;
	
	@SuppressWarnings("deprecation")
	public void setStartDate(int year, int month, int date, int hour) {
		this.startDate = new Date(year, month, date, hour, 0);
		
	}
	
	public void setEndDate(String period, String duration, Date startDate) {
		if((period.equalsIgnoreCase("Hour")) == true) {
			this.endDate = addHours(startDate, Integer.parseInt(duration));
		}
		else if(period.equalsIgnoreCase("Day") == true) {
			this.endDate = addDays(startDate, Integer.parseInt(duration));
		}
		else if(period.equalsIgnoreCase("Week") == true) {
			this.endDate =  addWeeks(startDate, Integer.parseInt(duration));
		}
		else if(period.equalsIgnoreCase("Month") == true) {
			this.endDate =  addMonths(startDate, Integer.parseInt(duration));
		}
		else if(period.equalsIgnoreCase("Semester") == true) {
			this.endDate =  addSemesters(startDate, Integer.parseInt(duration));
		}
		else if(period.equalsIgnoreCase("Year") == true) {
			this.endDate =  addYears(startDate, Integer.parseInt(duration));
		}
		
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public Date getStartDate() {
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
	    calendar.add(Calendar.DAY_OF_MONTH, days); 
	    return calendar.getTime();
	}
	
	private Date addWeeks(Date startDate, int weeks) {
	    calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    calendar.add(Calendar.WEEK_OF_MONTH, weeks); 
	    return calendar.getTime();
	}
	
	private Date addMonths(Date startDate, int months) {
	    calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    calendar.add(Calendar.MONTH, months); 
	    return calendar.getTime();
	}
	
	private Date addSemesters(Date startDate, int semesters) {
		semesters *= 3; //approximating 3 months for a semester
	    calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    calendar.add(Calendar.MONTH, semesters); 
	    return calendar.getTime();
	}
	
	private Date addYears(Date startDate, int years) {
	    calendar = Calendar.getInstance();
	    calendar.setTime(startDate);
	    calendar.add(Calendar.YEAR, years);
	    return calendar.getTime();
	}
	
	
}