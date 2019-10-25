package testing;

import static org.junit.Assert.*;
import org.junit.*;

import src.Permit_Cost_Calculation;

public class Permit_Cost_CalculationTest {

	@Test
	public void testDiscountCal() {
		Permit_Cost_Calculation calculator = new Permit_Cost_Calculation();
		assertEquals(0.30, calculator.discountCal("Veteran"), 0);
		assertEquals(0.30, calculator.discountCal("Employee"), 0);
		assertEquals(1, calculator.discountCal("Student"), 0);
	}

	@Test
	public void testLotCal() {
		Permit_Cost_Calculation calculator = new Permit_Cost_Calculation();
		assertEquals(1.5, calculator.lotCal("A"), 0);
		assertEquals(1.1, calculator.lotCal("B"), 0);
		assertEquals(0.9, calculator.lotCal("C"), 0);
		assertEquals(1.3, calculator.lotCal("D"), 0);
	}

	@Test
	public void testRateCal() {
		//Permit_Cost_Calculation calculator = new Permit_Cost_Calculation();
		//not sure what to pass here
		//assertEquals(0, calculator.rateCal(""), 0);
	}

}
