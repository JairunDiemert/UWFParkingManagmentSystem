package src;

import models.User_Info;
import models.permit;

public class User_Controller {
	
	User_Info user;
	permit permit;

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

	permit purchaseTicket() {
		
		permit newPermit = new permit();
		setPermit(newPermit);
		
		return newPermit;
	};
	
	public String exitUserInterface(permit newPermit) {
		String exitMessage;
		exitMessage = "Good Bye";
		return exitMessage;
	};
	
	User_Info createNewUser() {

		User_Info newUser = new User_Info();
		setUser(newUser);
		
		return newUser;
	};
	
	User_Info inputNewUserInfo(String userName, String userEmail, String userPhoneNum, String userInfo) {
		User_Info newUser = getUser();
		
		newUser.setUserName(userName);
		newUser.setUserEmail(userEmail);
		newUser.setUserPhoneNum(userPhoneNum);
		newUser.setUserInfo(userInfo);

		return newUser;
	};
	
	permit inputNewPermitInfo(char lotPermissions, String startDate, String endDate, String licensePlate) {
		permit newPermit = getPermit();
		User_Info newUser = getUser();
		
		newPermit.setLotPermissions(lotPermissions);
		newPermit.setStartDate(startDate);
		newPermit.setEndDate(endDate);
		newUser.setLicensePlate(licensePlate);
		
		
		return newPermit;
	}
	
	void pushNewUserInfoToDatabase() {
		User_Info newUser = getUser();
		permit newPermit = getPermit();
		//ADD link to database 
	};
	
	String viewExistingUserAndPermitInfo(String userNameToSearch) {
		
		String tempUserDataFromDataBase = getUserByUserName(userNameToSearch);
		String delims = "[ ]+";
		String[] tokens = tempUserDataFromDataBase.split(delims);
		//parse variables from string retrieved from data base
		String userName = tokens[0];		
		String userEmail = tokens[1];
		String userPhoneNum = tokens[2];
		String userInfo = tokens[3];
		
		User_Info existingUser = inputNewUserInfo(userName, userEmail, userPhoneNum, userInfo);
		
		String tempLotPermissions = tokens[4];
		char lotPermissions = tempLotPermissions.charAt(0);
		String startDate = tokens[5]; 
		String endDate = tokens[6];
		String licensePlate = tokens[7];
		
		permit existingPermit = inputNewPermitInfo(lotPermissions, startDate, endDate, licensePlate);
		
		String formatedUserAndPermitInfo = "" + formatUserInfo() + formatPermitInfo();
		return formatedUserAndPermitInfo;
	};
	
	String getUserByUserName(String userNameToSearch) {

		String userData = "";
		//userData = ADD link to database to search and pass content.
		return userData;
	};	
	
	String formatUserInfo() {
		User_Info existingUser = new User_Info();
		existingUser = getUser();
		String UserInfo = "";
		UserInfo = "" + existingUser.getUserName() +
				   " " + existingUser.getUserEmail() +
				   " " + existingUser.getUserPhoneNum() +
				   " " + existingUser.getUserInfo();	
		return UserInfo;
	};
	
	String formatPermitInfo() {
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
