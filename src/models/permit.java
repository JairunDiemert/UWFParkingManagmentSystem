package models;
import java.util.Date;


public class permit {

	private char lotPermissions;
	private String startDate; // Day/Month/Year
	private String endDate; // Day/Month/Year
	private int startHour; //24 hour clock
	private int endHour;   //24 hour clock
	private String liscensePlate; 
	private String UID; //unique ID reference to individual parking permit
	private String duration;
	private String period;

	public permit() {
		lotPermissions = 'Z';
		setStartHour(00);
		setEndHour(00);
		UID = "NA";
		setLiscensePlate("NA");
	}
	
	public permit(char lotPermissions, String startDate, String endDate, int startHour, int endHour, String liscensePlate, String UID) {
		this.lotPermissions = lotPermissions;
		this.startDate = startDate;
		this.endDate = endDate;
		this.setStartHour(startHour);
		this.setEndHour(endHour);
		this.setLiscensePlate(liscensePlate);
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
	 * @param string the startDate to set
	 */
	public void setStartDate(String string) {
		this.startDate = string;
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

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public String getLiscensePlate() {
		return liscensePlate;
	}

	public void setLiscensePlate(String liscensePlate) {
		this.liscensePlate = liscensePlate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
}