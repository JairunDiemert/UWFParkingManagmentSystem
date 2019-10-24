package view;

import models.User_Info;
import src.Permit_Cost_Calculation;


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
		user.setUserAddress(address);
		user.setUserInfo(status);
		user.setUserAddress(address);

		return user;
	}
		
	public double Calculation(User_Info user, String period, String lot) {
		
		
		
		  
		  double cost;
		  
		  cost = 50;         //cal.rateCal(period);
		  
		  cost *= cal.discountCal(user.getUserInfo());
		  
		  cost *= cal.lotCal(lot);
		
		
		return cost;
		
		
	}
		
		
	

	

}
