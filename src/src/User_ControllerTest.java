package src;
import static org.junit.Assert.assertEquals;
import org.junit.*;

import models.User_Info;
import models.permit;


public class User_ControllerTest {

	@Test
	public void testGetUser() {
		User_Info info = new User_Info();
		info.setUserName("Group 3");
		User_Controller controller = new User_Controller();
		controller.setUser(info);
		assertEquals(info, controller.getUser());
	}

	@Test
	public void testGetPermit() {
		permit newPermit = new permit();
		User_Controller controller = new User_Controller();
		controller.setPermit(newPermit);
		assertEquals(newPermit, controller.getPermit());
	}

	@Test
	public void testPurchaseTicket() {
		permit newPermit = new permit();
		User_Controller controller = new User_Controller();
		controller.setPermit(newPermit);
		assertEquals(newPermit, controller.getPermit());  
	}

	@Test
	public void testExitUserInterface() {
		permit newPermit = new permit();
		User_Controller controller = new User_Controller();
		assertEquals("Good Bye", controller.exitUserInterface(newPermit));
	}
}
