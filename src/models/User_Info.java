package models;

public class User_Info {
	
	private String userName;			//user's name
	private String userID;				//register ID
	private String userAddress;			//user address for shipping parking permit
	private String userEmail;			//user email
	private int userNumCar;				//max amount of car of a user can register
	private String licensePlate;		//license plate 
	private String userPhoneNum; 		//user phone number
	private String userInfo; 			//student, employee, guess
	private String userLot; 			//user parking lot
	private String userPassword;
	
	public User_Info() {
		
		userName = "NA";
		userID = "NA";
		userAddress = "NA"; 
		userEmail = "NA";
		userNumCar = 0;
		licensePlate = "NA";
		userPhoneNum = "NA";
		userInfo = "NA";
		userLot = "NA"; 
	}
	
	public User_Info(String name, String id, String address, String email, int numOfCar, String license, String phoneNumber, String info, String lot) {
		
		this.userName = name;
		this.userID = id;
		this.userAddress = address; 
		this.userEmail = email;
		this.userNumCar = numOfCar;
		this.licensePlate = license;
		this.userPhoneNum = phoneNumber;
		this.userInfo = info;
		this.userLot = lot; 
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	
	
	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	/**
	 * @return the userNumCar
	 */
	public int getUserNumCar() {
		return userNumCar;
	}
	
	
	/**
	 * @param userNumCar the userNumCar to set
	 */
	public void setUserNumCar(int userNumCar) {
		this.userNumCar = userNumCar;
	}
	
	
	/**
	 * @return the licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}
	
	
	/**
	 * @param licensePlate the licensePlate to set
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	
	/**
	 * @return the userPhoneNum
	 */
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	
	
	/**
	 * @param userPhoneNum the userPhoneNum to set
	 */
	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}


	/**
	 * @return the userInfo
	 */
	public String getUserInfo() {
		return userInfo;
	}


	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}


	/**
	 * @return the userLot
	 */
	public String getUserLot() {
		return userLot;
	}


	/**
	 * @param userLot the userLot to set
	 */
	public void setUserLot(String userLot) {
		this.userLot = userLot;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

}
