/*need to get the "how long the user want the permit will be", which parking lots*/
package controller;

import models.User_Info;
import models.permit;

@SuppressWarnings("unused")
public class Permit_Cost_Calculation {

	private static final double VETERAN_DISCOUNT = .30;
	//private static final double GUESS_DISCOUNT = 0;
	private static final double EMPLOYEES_DISCOUNT = .30;
	private static final double STUDENT_DISCOUNT = 1;
	
	//prices for the permit rate
	private static final double HOUR_RATE = 1.5;
	private static final double DAY_RATE = 5;
	private static final double WEEK_RATE = 15;
	private static final double MONTH_RATE = 30;
	private static final double SEMESTER_RATE = 55;			//Fall, Spring, Summer semester
	private static final double YEAR_RATE = 100;			//3 semester in a year
	
	//parking factor
	private static final double LOT_A = 1.5;
	private static final double LOT_B = 1.1;
	private static final double LOT_C = 0.9;
	private static final double LOT_D = 1.3;
	
	
	//time factor
	/*
	private static final double DAY = 1;
	private static final double WEEK = 7;
	private static final double MONTH = 30;
	private static final double SEMESTER = 120;
	private static final double YEAR = 360;
	*/
	
	//pass entire user for testing
	/*
	public double cal(User_Info user, permit p) {
		
		double cost = 0 ;
		//same date
		if( (p.getEndDate().equalsIgnoreCase(p.getStartDate())) == true) {
			
			String str = String.valueOf(p.getEndHour() - p.getStartHour()) + " Hour"; 
			cost = rateCal();
		}
											
			
		cost *= discountCal(user.getUserInfo());
			
		cost *= lotCal(user.getUserLot());
			
		return cost;
		//System.out.println("The cost is "+ cost);
		
	}*/
	
	public double totalCal(User_Info user, String p, String l, String d) {
		
		
										
		double cost = rateCal(p,d);
			
		cost *= discountCal(user.getUserInfo());
			
		cost *= lotCal(l);
			
		return cost;
		//System.out.println("The cost is "+ cost);
		
	}
	
	private double discountCal(String s){
		
		double discountFactor = 0.0;
		
		if(s.compareTo( "Employee" ) == 0) {
			
			discountFactor = EMPLOYEES_DISCOUNT;
			
		}
		else if(s.compareTo( "Veteran" ) == 0) {
			
			discountFactor = VETERAN_DISCOUNT;
			
			
		}else if(s.compareTo( "Student" ) == 0) {
			
			discountFactor = STUDENT_DISCOUNT;
			
		}else {
			
			//guess and waiver discount 0.0
		}
		
		return discountFactor;
	}
	
	
	private double lotCal(String s) {
		
		double lotCostFactor = 0.0;
		
		if((Character.compare(s.charAt(0), 'A')) == 0) {
			
			lotCostFactor = LOT_A;
			
		}
		else if((Character.compare(s.charAt(0), 'B')) == 0) {
			
			lotCostFactor = LOT_B;
			
		}else if((Character.compare(s.charAt(0), 'C')) == 0) {
			
			lotCostFactor = LOT_C;
			
		}else if((Character.compare(s.charAt(0), 'D')) == 0) {
			
			lotCostFactor = LOT_D;
			
		}else  {
			
			//guess
			lotCostFactor = 0.0;
			
		}
	
		return lotCostFactor;
		
		
	}
	
	
	private double rateCal(String p, String d) {
		
		
		double rateCost = 0.0;
		
		if((p.equalsIgnoreCase("Hour")) == true) {
			
			rateCost = Double.parseDouble(d) * HOUR_RATE;
			
		}
		else if((p.equalsIgnoreCase("Day")) == true) {
			
			rateCost = Double.parseDouble(d) * DAY_RATE;
			
		}else if((p.equalsIgnoreCase("Week")) == true) {
			
			rateCost = Double.parseDouble(d) * WEEK_RATE;
			
		}else if((p.equalsIgnoreCase("Month")) == true) {
			
			rateCost = Double.parseDouble(d) * MONTH_RATE;
			
		}else if((p.equalsIgnoreCase("Semester")) == true) {
			
			rateCost = Double.parseDouble(d) * SEMESTER_RATE;
			
		}else if((p.equalsIgnoreCase("Year")) == true) {
			
			rateCost = Double.parseDouble(d) * YEAR_RATE;
			
		}else{
			
			//guess rate will be 0
			
		}
		
		return rateCost;
		
		
	}
	
	
}
