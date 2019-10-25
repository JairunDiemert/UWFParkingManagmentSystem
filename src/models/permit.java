package models;

public class permit {

	private char lotPermissions;
	private String startDate;	//Day/Month/Year
	private String endDate;
	private String UID; //unique ID reference to individual parking permit

	public permit() {
		lotPermissions = 'Z';
		startDate = "NA";
		endDate = "NA";
		UID = "NA";
	}
	
	public permit(char lotPermissions, String startDate, String endDate, String UID) {
		this.lotPermissions = lotPermissions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.UID = UID;
	}
	
	/**
	 * @return the lotPermissions
	 */
	public char getLotPermissions() {
		return lotPermissions;
	}

	/**
	 * @param lotPermissions the lotPermissions to set
	 */
	public void setLotPermissions(char lotPermissions) {
		this.lotPermissions = lotPermissions;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the UID
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * @param UID the UID to set
	 */
	public void setUID(String UID) {
		this.UID = UID;
	}
}