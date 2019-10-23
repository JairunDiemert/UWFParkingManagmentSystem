import static org.junit.Assert.*;

public class Test {
	
	@Test
	public void testPermit() {
		JunitTesting test = new JunitTesting();
		permit newPermit = new permit();
		newPermit.setLotPermissions('A');
		newPermit.setStartDate("09/01/2019");
		newPermit.setEndDate("06/01/2019");
		newPermit.setUID("ABC123");
		assertEquals('A', newPermit.getLotPermissions());
		assertEquals("09/01/2019", newPermit.getStartDate());
		assertEquals("06/01/2019", newPermit.getEndDate());
		assertEquals("ABC123", newPermit.getUID());

		//more tests
	}
}