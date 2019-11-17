package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EndDate_CalculationTest {

	@BeforeAll
	public static void setup() {
		EndDate_Calculation sut = new EndDate_Calculation();
		sut.setStartDate(2019, 11, 1, 0);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testFiveHoursFromStartDate() {
		
		EndDate_Calculation sut = new EndDate_Calculation();
		Date currentDate = new Date(2019, 11, 1, 1, 0);
		sut.setStartDate(2019, 11, 1, 1);
		sut.setEndDate("Hour", "5", currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.HOUR_OF_DAY, 5);
		assertEquals(cal.getTime(), sut.getEndDate());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneDayFromStartDate() {
		
		EndDate_Calculation sut = new EndDate_Calculation();
		Date currentDate = new Date(2019, 11, 1, 1, 0);
		sut.setStartDate(2019, 11, 1, 1);
		sut.setEndDate("Day", "1", currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DATE, 1);
		assertEquals(cal.getTime(), sut.getEndDate());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneWeekFromStartDate() {
		
		EndDate_Calculation sut = new EndDate_Calculation();
		Date currentDate = new Date(2019, 11, 1, 1, 0);
		sut.setStartDate(2019, 11, 1, 1);
		sut.setEndDate("Week", "1", currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		assertEquals(cal.getTime(), sut.getEndDate());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneMonthFromStartDate() {

		EndDate_Calculation sut = new EndDate_Calculation();
		Date currentDate = new Date(2019, 11, 1, 1, 0);
		sut.setStartDate(2019, 11, 1, 1);
		sut.setEndDate("Month", "1", currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.MONTH, 1);
		assertEquals(cal.getTime(), sut.getEndDate());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneSemesterFromStartDate() {

		EndDate_Calculation sut = new EndDate_Calculation();
		Date currentDate = new Date(2019, 11, 1, 1, 0);
		sut.setStartDate(2019, 11, 1, 1);
		sut.setEndDate("Semester", "1", currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.MONTH, 3);
		assertEquals(cal.getTime(), sut.getEndDate());
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOneYearFromStartDate() {

		EndDate_Calculation sut = new EndDate_Calculation();
		Date currentDate = new Date(2019, 11, 1, 1, 0);
		sut.setStartDate(2019, 11, 1, 1);
		sut.setEndDate("Year", "1", currentDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.YEAR, 1);
		assertEquals(cal.getTime(), sut.getEndDate());
	}

}