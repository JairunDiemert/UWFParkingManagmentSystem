package controller;

import static org.junit.Assert.*;
import org.junit.*;

import controller.Permit_Cost_Calculation;
import models.User_Info;
import models.permit;

//@SuppressWarnings("unused")
public class Permit_Cost_CalculationTest {

	@Test
	public void testCal() {
		User_Info user = new User_Info();
		permit userPermit = new permit();
		Permit_Cost_Calculation calculator = new Permit_Cost_Calculation();
		user.setUserInfo("Student");
		user.setUserLot("A");
		userPermit.setPeriod("Hour");
		userPermit.setDuration("2");
		
		assertEquals(4.5, calculator.totalCal(user, userPermit.getPeriod(), user.getUserLot(), userPermit.getDuration()), 0);
	}
}
