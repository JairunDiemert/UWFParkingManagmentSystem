
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
	
	String exitUserInterface(permit newPermit) {
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
	
	void viewExistingUser() {
		//not sure if needed yet
	};
	
	void getUserByUserName() {
		//not sure if needed yet
	};
	
	void retreiveUserInfoFromDatabase() {
		//not sure if needed yet
	};
	
	void formatUserInfo() {
		//not sure if needed yet
	};
	
	void returnUserInfo() {
		//not sure if needed yet
	};
	
	void selectParkingPermitType() {
		//not sure if needed yet
	};
	
	void slelctParkingPermitPeriod() {
		//not sure if needed yet
	};
	
	void registerVehicleByTag() {
		//not sure if needed yet
	};
	
	void submitNewPermitInfo() {
		//not sure if needed yet
	};
	
}
