/*need to get the "how long the user want the permit will be", which parking lots*/
package src;

import models.User_Info;

public class Permit_Cost_Calculation {

	private static final double VETERAN_DISCOUNT = .30;
	private static final double STUDENT_DISCOUNT = 1;
	private static final double GUESS_DISCOUNT = 1;
	private static final double EMPLOYEES_DISCOUNT = .30;
	private static final double WAIVER = 0;
	
	public void cal() {
		
		User_Info newUser = new User_Info();
		
			String info = newUser.getUserInfo();
			double cost = 100;								//assuming the permit costed $100 now
			
			if(info.compareTo( "Employee" ) == 0) {
				
				cost *= (1-EMPLOYEES_DISCOUNT);
				
			}
			else if(info.compareTo( "Veteran" ) == 0) {
				
				cost *= (1-VETERAN_DISCOUNT);
				
			}
			else {
				
				//not thing change
			}
			
			//set price to the student info
		
	}
	
	
}
