package models;

import java.util.*;

public class Fine {

private double fineAmount;
private String violationType;
private String reasonForFine; //comment field for ticket
private String location;
private Date date;

public Fine() {
	fineAmount = -1;
	violationType = "1A";
	reasonForFine = "Comments";
	location = "Lot --";
	Date date = new Date();
}

public Fine(double fineAmount, String violationType, String reasonForFine, String location, Date date) {
	this.fineAmount = fineAmount;
	this.violationType = violationType;
	this.reasonForFine = reasonForFine;
	this.location = location;
	this.date = new Date();
}

public double getFineAmount() {
	return fineAmount;
}

public void setFineAmount(double fineAmount) {
	this.fineAmount = fineAmount;
}

public String GetViolationType() {
	return violationType;
}

public void setViolationType(String violationType) {
	this.violationType = violationType;
}

public String getReasonForFine() {
	return reasonForFine;
}

public void setReasonForFine(String reasonForFine) {
	this.reasonForFine = reasonForFine;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}


}