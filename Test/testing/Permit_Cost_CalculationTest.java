package testing;

import static org.junit.Assert.*;
import org.junit.*;

import models.User_Info;
import models.permit;
import src.Permit_Cost_Calculation;

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
		
		assertEquals("The cost is ", calculator.cal(user, userPermit));
	}
}
