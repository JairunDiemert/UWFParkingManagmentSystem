package view;

import controller.Permit_Cost_Calculation;
import models.User_Info;
import models.permit;


@SuppressWarnings("unused")
public class TestController {
	
	Permit_Cost_Calculation cal = new Permit_Cost_Calculation();
	
	public User_Info CreateUser(String name, String email, String phoneNum,
			String address, String status) {
		
		User_Info user = new User_Info();

		/*
		 * Verify Format
		 * 
		 * 
		 */
		user.setUserName(name);
		user.setUserPhoneNum(phoneNum);
		user.setUserEmail(email);
		user.setUserInfo(status);
		user.setUserAddress(address);

		return user;
	}
	// just to test GUI
	public User_Info getUserByID(){
		
		User_Info user = new User_Info();
		user.setUserName("John Smith");
		user.setUserPhoneNum("813-456-5467");
		user.setUserAddress("106 Ander pkwy");
		user.setUserEmail("ThisIsAnEmail@email.com");
		user.setUserInfo("Employee");
		
		return user;
	}
	
		
	public double Calculation(User_Info user, String period, String lot, String duration) {
		
  
		  double cost;
		  
		  cost = cal.totalCal(user, period, lot, duration);
		
		
		return cost;
		
		
	}
	/*
	public double rate(String s) {
		
		
		double rateCost = 0.0;
		
		if((s.equalsIgnoreCase("Hour")) == true) {
			
			rateCost = 1.5;
			
		}
		else if((s.equalsIgnoreCase("Day")) == true) {
			
			rateCost = 5;
			
		}else if((s.equalsIgnoreCase("Week")) == true) {
			
			rateCost = 15;
			
		}else if((s.equalsIgnoreCase("Month")) == true) {
			
			rateCost = 30;
			
		}else if((s.equalsIgnoreCase("Semester")) == true) {
			
			rateCost = 55;
			
		}else if((s.equalsIgnoreCase("Year")) == true) {
			
			rateCost = 100;
			
		}else{
			
			//guess rate will be 0
			
		}
		
		
		
		return rateCost;
		
	}
		
		*/
	

	

}
