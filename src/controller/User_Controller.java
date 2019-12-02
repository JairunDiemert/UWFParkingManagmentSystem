package controller;

import models.User_Info;
import models.permit;
import java.util.*;

public class User_Controller {
	
	private User_Info user;
	private permit permit;
	private Date date;

	public User_Info getUser() {
		return user;
	}

	public void setUser(User_Info user) {
		this.user = user;
	}

	public permit getPermit() {
		return permit;
	}

	public void setPermit(permit permit) {
		this.permit = permit;
	}

	public void setDate() {
		this.date = new Date();
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDateString() {
		return this.date.toString();
	}
	public permit purchaseTicket() {
		
		permit newPermit = new permit();
		setPermit(newPermit);
		
		return newPermit;
	};
	
	public String exitUserInterface(permit newPermit) {
		String exitMessage;
		exitMessage = "Good Bye";
		return exitMessage;
	};
	
	public User_Info createNewUser() {

		User_Info newUser = new User_Info();
		setUser(newUser);
		
		return newUser;
	};
	
	public User_Info inputNewUserInfo(String userName, String userEmail, String userPhoneNum, String userAddress, String userInfo) {
		User_Info newUser = getUser();
		
		newUser.setUserName(userName);
		newUser.setUserEmail(userEmail);
		newUser.setUserPhoneNum(userPhoneNum);
		newUser.setUserAddress(userAddress);
		newUser.setUserInfo(userInfo);

		return newUser;
	};
	// two diff formats
	public permit inputNewPermitInfo(char lotPermissions, int multiplier, String choice, String licensePlate) {
		permit newPermit = getPermit();
		User_Info newUser = getUser();
		//Duration_Calculation endDate = new Duration_Calculation();
		
		newPermit.setLotPermissions(lotPermissions);
		setDate();
		newPermit.setStartDate(getDateString());
		//newPermit.setEndDate(endDate.getEndDate(getDate(), multiplier, choice));
		newUser.setLicensePlate(licensePlate);
		
		
		return newPermit;
	}
	// two diff formats
	public permit inputNewPermitInfo(char lotPermissions, String startDate, String endDate, String licensePlate) {		
		permit newPermit = getPermit();			
		User_Info newUser = getUser();			


		newPermit.setLotPermissions(lotPermissions);			
		newPermit.setStartDate(startDate);			
		newPermit.setEndDate(endDate);			
		newUser.setLicensePlate(licensePlate);
		
		
		return newPermit;
	}
	@SuppressWarnings("unused")
	public void pushNewUserInfoToDatabase() {
		User_Info newUser = getUser();
		permit newPermit = getPermit();
		//ADD link to database 
	};
	
	@SuppressWarnings("unused")
	public String viewExistingUserAndPermitInfo(String userNameToSearch) {
		
		String tempUserDataFromDataBase = getUserByUserName(userNameToSearch);
		String delims = "[ ]+";
		String[] tokens = tempUserDataFromDataBase.split(delims);
		//parse variables from string retrieved from data base
		String userName = tokens[0];		
		String userEmail = tokens[1];
		String userPhoneNum = tokens[2];
		String userAddress = tokens[3];
		String userInfo = tokens[4];
		
		User_Info existingUser = inputNewUserInfo(userName, userEmail, userPhoneNum, userAddress, userInfo);
		
		String tempLotPermissions = tokens[5];
		char lotPermissions = tempLotPermissions.charAt(0);
		String startDate = tokens[6]; 
		String endDate = tokens[7];
		String licensePlate = tokens[8];
		
		//permit existingPermit = inputNewPermitInfo(lotPermissions, startDate, endDate, licensePlate);
		permit existingPermit = inputNewPermitInfo(lotPermissions, startDate, endDate, licensePlate);
		
		String formatedUserAndPermitInfo = "" + formatUserInfo() + formatPermitInfo();
		return formatedUserAndPermitInfo;
	};
	
	public String getUserByUserName(String userNameToSearch) {

		String userData = "";
		//userData = ADD link to database to search and pass content.
		return userData;
	};	
	
	public String formatUserInfo() {
		User_Info existingUser = new User_Info();
		existingUser = getUser();
		String UserInfo = "";
		UserInfo = "" + existingUser.getUserName() +
				   " " + existingUser.getUserEmail() +
				   " " + existingUser.getUserPhoneNum() +
				   " " + existingUser.getUserInfo();	
		return UserInfo;
	};
	
	public String formatPermitInfo() {
		permit existingPermit = new permit();
		existingPermit = getPermit();
		User_Info existingUser = new User_Info();
		existingUser = getUser();
		String PermitInfo = "";
		PermitInfo = " " + existingPermit.getLotPermissions() +
				   " " + existingPermit.getStartDate() +
				   " " + existingPermit.getEndDate() +
				   " " + existingUser.getLicensePlate();	
		return PermitInfo;
	};
	
}
