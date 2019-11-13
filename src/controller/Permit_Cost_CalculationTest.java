package controller;

import static org.junit.Assert.*;
import org.junit.*;

import controller.Permit_Cost_Calculation;
import models.User_Info;
import models.permit;

public class Permit_Cost_CalculationTest {

	@Test
	public void testCal() {
		User_Info user = new User_Info();
		permit userPermit = new permit();
		Permit_Cost_Calculation calculator = new Permit_Cost_Calculation();
		user.setUserInfo("Student");
		user.setUserLot("A");
		userPermit.setStartHour(14);
		userPermit.setEndHour(16);
		
		assertEquals(4.5, calculator.rateCal(user, userPermit), 0);
	}
}
