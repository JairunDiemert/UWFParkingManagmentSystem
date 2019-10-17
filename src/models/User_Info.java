package models;

public class User_Info {
	
	private String userName;			//user's name
	private String userID;				//register ID
	private String userAddress;			//user address for shipping parking permit
	private String userEmail;			//user email
	private int userNumCar;				//max amount of car of a user can register
	private String licensePlate;		//license plate 
	private String userPhoneNum; 		//user phone number
	
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
	

}
