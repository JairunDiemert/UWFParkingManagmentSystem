package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EndDate_CalculationTest {

	@BeforeAll
	public static void init(){
		EndDate_Calculation sut = new EndDate_Calculation();
		sut.setStartDate(2019, 11, 1, 0);
	}
	
	@Test
	public void testFiveHoursFromStartDate() {
		EndDate_Calculation sut = new EndDate_Calculation();
		sut.setStartDate(2019, 11, 1, 0);
		sut.getEndDate();
	}
	
	@Test
	public void testOneDayFromStartDate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOneWeekFromStartDate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOneMonthFromStartDate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOneSemesterFromStartDate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testOneYearFromStartDate() {
		fail("Not yet implemented");
	}

}
