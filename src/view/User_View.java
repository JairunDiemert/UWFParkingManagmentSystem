package view;

import java.text.DecimalFormat;

import database.Read_DB;
import database.Update_DB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;

import models.User_Info; 

@SuppressWarnings("unused")
public class User_View extends Application{
	
	TestController control = new TestController();
	User_Info user;
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
		Text titleText = new Text("Welcome to Campus Parking Services");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Button purchasePermitButton = new Button("Purchase Parking Permit");
		Button exitButton = new Button("Exit");
		
		purchasePermitButton.setOnAction(e -> selectUserPane(stage));
		exitButton.setOnAction(e-> stage.close());
		
		VBox vbox = new VBox();
		
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(500, 500);
	    vbox.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    vbox.getChildren().add(titleText);
	    vbox.getChildren().add(purchasePermitButton);
	    vbox.getChildren().add(exitButton);
	    
	    Scene scene = new Scene(vbox);
	    stage.setScene(scene);
	    stage.setTitle("User View Window");
	    stage.show();
	}
	
	public void selectUserPane(Stage stage) {
		
		Button newUserButton = new Button("New User");
		Button existingUserButton = new Button("Existing User");
		Button backButton = new Button("Back");
		
		newUserButton.setOnAction(e -> enterUserInfo(stage));
		existingUserButton.setOnAction(e-> enterExistingUser(stage));
		
		backButton.setOnAction(e -> {
			try {
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		VBox vbox = new VBox();
		
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(500, 500);
	    vbox.setPadding(new Insets(10 ,10 , 10, 10));
	    vbox.setSpacing(20);
	    
	    vbox.getChildren().add(existingUserButton);
	    vbox.getChildren().add(newUserButton);
	    vbox.getChildren().add(backButton);
	   
	    
	    Scene scene = new Scene(vbox);
	    stage.setScene(scene);
	    stage.show();	
		
	}
	public void enterExistingUser(Stage stage) {
		
		Text enterUserName = new Text("Enter Your User Id");
		TextField nameField = new TextField();
		
		Button submitButton = new Button("Submit");
		Button backButton = new Button("Back");
		
		
		submitButton.setOnAction(e-> existingUserRequest(stage, nameField.getText()));
		
		backButton.setOnAction(e-> selectUserPane(stage));
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    gridPane.add(enterUserName, 0, 0);
	    gridPane.add(nameField, 1, 0);
	    gridPane.add(submitButton, 1, 1);
	    gridPane.add(backButton, 0, 1);
	    
	    
	    Scene scene  = new Scene(gridPane);
		stage.setScene(scene);
	}
	
	public void enterUserInfo(Stage stage){
			
		Text nameText = new Text("Name: ");
		Text emailText = new Text("Email: ");
		Text phoneText = new Text("Phone Number: ");
		Text addressText = new Text("Adddress: ");
		Text statusText = new Text("Status: ");
		
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField phoneField = new TextField();
		TextField addressField = new TextField();
		
		ChoiceBox<String> statusChoice = new ChoiceBox<>();
		
		statusChoice.getItems().addAll("Student", "Employee", "Veteran", "Guest");
		statusChoice.setValue("Student");
		
		Button submitButton = new Button("Submit");
		Button backButton = new Button("Back");
		
		backButton.setOnAction(e-> selectUserPane(stage));
		submitButton.setOnAction(e -> newUserRequest(stage, nameField.getText(), emailField.getText(), 
				phoneField.getText(), addressField.getText(),statusChoice.getSelectionModel().getSelectedItem()));
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    gridPane.add(nameText, 0, 0);
	    gridPane.add(emailText, 0, 1);
	    gridPane.add(phoneText, 0, 2);
	    gridPane.add(addressText, 0, 3);
	    gridPane.add(statusText, 0, 4);
	    
	    gridPane.add(backButton, 0, 5);

	    gridPane.add(nameField, 1, 0);
	    gridPane.add(emailField, 1, 1);
	    gridPane.add(phoneField, 1, 2);
	    gridPane.add(addressField, 1, 3);
	    gridPane.add(statusChoice, 1, 4);
	    
	    gridPane.add(submitButton, 1, 5);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();		
		
	}
	
	public void addPermitPane(Stage stage, double cost, String period, String lot, String duration) {
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		Text parkingLotText = new Text("Parking Lot: ");
		Text periodText = new Text("Period: ");
		Text licensePlateText = new Text("License Plate: ");
		
		Text costText = new Text("$ " + df.format(cost));
		Text amountText = new Text("Amount: ");
		
		TextField licensePlateField = new TextField();
		
		ChoiceBox<String> parkingLotChoice = new ChoiceBox<>();
		ChoiceBox<String> periodChoice = new ChoiceBox<>();
		ChoiceBox<String> durationChoice = new ChoiceBox<>();
		
		parkingLotChoice.getItems().addAll("A", "B", "C", "D");
		parkingLotChoice.setValue(lot);
		
		periodChoice.getItems().addAll("Hour", "Day", "Week", "Month", "Semester", "Year");
		periodChoice.setValue(period);
		
		durationChoice.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
		durationChoice.setValue(duration);
		
		parkingLotChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem()));
		periodChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem()));
		durationChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem()));
		
		Button submitButton = new Button("Submit");
		Button backButton = new Button("Back");
		
		backButton.setOnAction(e-> selectUserPane(stage));
		
		submitButton.setOnAction(e-> userInfoPane(stage, licensePlateField.getText(), periodChoice.getSelectionModel().getSelectedItem(),
				durationChoice.getSelectionModel().getSelectedItem(), parkingLotChoice.getSelectionModel().getSelectedItem(), cost));
		
		/*
		 * submitButton.setOnAction(e->{ try { start(stage); } catch (Exception e1) { //
		 * TODO Auto-generated catch block e1.printStackTrace(); } });
		 */
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    gridPane.setVgap(5); 
	    gridPane.setHgap(1);
	    
	    gridPane.add(parkingLotText, 0, 0);
	    gridPane.add(periodText, 0, 1);
	    gridPane.add(licensePlateText, 0, 2);
	    gridPane.add(amountText, 0, 3);
	    gridPane.add(backButton, 0, 4);

	    gridPane.add(parkingLotChoice, 1, 0);
	    gridPane.add(periodChoice, 2, 1);
	    gridPane.add(durationChoice, 1, 1);
	    gridPane.add(licensePlateField, 1, 2);
	    gridPane.add(costText, 1, 3);
	    gridPane.add(submitButton, 1, 4);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();	
	}
	
		public void toCostCal(Stage stage, String period, String lot, String duration) {
			  
			double cost = control.Calculation(user, period, lot, duration);
			  
			addPermitPane(stage, cost, period, lot, duration);
		  
		}
	  
		public void newUserRequest(Stage stage, String name, String email, String phoneNum, String address, String status) {
			
			user = control.CreateUser(name, email, phoneNum, address, status);
			double cost = control.Calculation(user, "Semester", "A", "1");
			
			addPermitPane(stage, cost, "Semester", "A", "1");			
		}
		
		
		/*resultSet[0] =  rs.getString("name");
		resultSet[1] = rs.getString("address");
		resultSet[2] = rs.getString("email");
		
		resultSet[3] = rs.getString("phone_number");
		resultSet[4] = rs.getString("status");
		resultSet[5] = rs.getString("license_plate");
		
		resultSet[6] = rs.getString("parking_lot");
		resultSet[7] = rs.getString("period");
		resultSet[8] = rs.getString("duration");
		
		resultSet[9] = String.valueOf(rs.getDouble("cost"));
		resultSet[10] = String.valueOf(rs.getInt("USER_ID"));*/
		
		public void existingUserRequest(Stage stage, String id) {
			// temp until database
			
			user = control.getUserByID();
			
			Read_DB readDB = new Read_DB();
			
			@SuppressWarnings("static-access")
			String arr[] = readDB.findUser(Integer.parseInt(id)); 	
			
			
			DecimalFormat df = new DecimalFormat("#.00");
			
			Text nameText = new Text("Name: ");
			Text IDText = new Text("ID: ");
			Text addressText = new Text("Address: ");
			Text emailText = new Text("Email: ");
			Text phoneText = new Text("Phone Number: ");
			Text statusText = new Text("Status: ");
			Text licenseText = new Text("license plate: ");
			Text parkingLotText = new Text("Parking Lot: ");
			Text lengthText = new Text("Duration: ");
			Text costText = new Text("Total Cost: ");
			
			Text userNameText = new Text(arr[0]);
			Text userIDText = new Text(arr[10]);
			Text userAddressText = new Text(arr[1]);
			Text userEmailText = new Text(arr[2]);
			Text userPhoneText = new Text(arr[3]);
			Text userStatusText = new Text(arr[4]);
			Text userLicenseText = new Text(arr[5]);
			Text userParkingLotText = new Text(arr[6]);
			Text userLengthText = new Text(arr[7] + " " +arr[8] + "(s)");
			Text userCostText = new Text("$ " + df.format(Double.valueOf(arr[9])));
			
			
			Button finishButton = new Button("Finish");
			Button backButton = new Button("Back");
			
			
			
			
			finishButton.setOnAction(e-> {
				try {
					start(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			GridPane gridPane = new GridPane();
			
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setMinSize(500, 500);
		    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
		    gridPane.setVgap(5); 
		    gridPane.setHgap(1);
		    
		    gridPane.add(nameText, 0, 0);
		    gridPane.add(IDText, 0, 1);
		    gridPane.add(addressText, 0, 2);
		    gridPane.add(emailText, 0, 3);
		    gridPane.add(phoneText, 0, 4);
		    gridPane.add(statusText, 0, 5);
		    gridPane.add(licenseText, 0, 6);
		    gridPane.add(parkingLotText, 0, 7);
		    gridPane.add(lengthText, 0, 8);
		    gridPane.add(costText, 0, 9);
		    gridPane.add(backButton, 0, 10);
		    
		    gridPane.add(userNameText, 1, 0);
		    gridPane.add(userIDText, 1, 1);
		    gridPane.add(userAddressText, 1, 2);
		    gridPane.add(userEmailText, 1, 3);
		    gridPane.add(userPhoneText, 1, 4);
		    gridPane.add(userStatusText, 1, 5);
		    gridPane.add(userLicenseText, 1, 6);
		    gridPane.add(userParkingLotText, 1, 7);
		    gridPane.add(userLengthText, 1, 8);
		    gridPane.add(userCostText, 1, 9);
		    gridPane.add(finishButton, 1, 10);

			
		    Scene scene = new Scene(gridPane);
		    stage.setScene(scene);
		    stage.show();
			
			
		}
		
		
		
		
		public void userInfoPane(Stage stage, String plate, String period, String duration, String lot, double cost) {
			DecimalFormat df = new DecimalFormat("#.00");
			
			Text nameText = new Text("Name: ");
			//Text IDText = new Text("ID: ");
			Text addressText = new Text("Address: ");
			Text emailText = new Text("Email: ");
			Text phoneText = new Text("Phone Number: ");
			Text statusText = new Text("Status: ");
			Text licenseText = new Text("license plate: ");
			Text parkingLotText = new Text("Parking Lot: ");
			Text lengthText = new Text("Duration: ");
			Text costText = new Text("Total Cost: ");
			
			Text userNameText = new Text(user.getUserName());
			//Text userIDText = new Text("N/A");
			Text userAddressText = new Text(user.getUserAddress());
			Text userEmailText = new Text(user.getUserEmail());
			Text userPhoneText = new Text(user.getUserPhoneNum());
			Text userStatusText = new Text(user.getUserInfo());
			Text userLicenseText = new Text(plate);
			Text userParkingLotText = new Text(lot);
			Text userLengthText = new Text(duration + " " + period + "(s)");
			Text userCostText = new Text("$ " + df.format(cost));
			
			Button confirmButton = new Button("Confirm");
			Button backButton = new Button("Back");
			
			
			
			
			backButton.setOnAction(e-> addPermitPane(stage, cost, period, lot, duration));
			confirmButton.setOnAction(e-> confirmPane( stage, user,plate, period,  duration,  lot,  cost)); 
			
			
			GridPane gridPane = new GridPane();
			
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setMinSize(500, 500);
		    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
		    gridPane.setVgap(5); 
		    gridPane.setHgap(1);
		    
		    gridPane.add(nameText, 0, 0);
		    //gridPane.add(IDText, 0, 1);
		    gridPane.add(addressText, 0, 2);
		    gridPane.add(emailText, 0, 3);
		    gridPane.add(phoneText, 0, 4);
		    gridPane.add(statusText, 0, 5);
		    gridPane.add(licenseText, 0, 6);
		    gridPane.add(parkingLotText, 0, 7);
		    gridPane.add(lengthText, 0, 8);
		    gridPane.add(costText, 0, 9);
		    gridPane.add(backButton, 0, 10);
		    
		    gridPane.add(userNameText, 1, 0);
		    //gridPane.add(userIDText, 1, 1);
		    gridPane.add(userAddressText, 1, 2);
		    gridPane.add(userEmailText, 1, 3);
		    gridPane.add(userPhoneText, 1, 4);
		    gridPane.add(userStatusText, 1, 5);
		    gridPane.add(userLicenseText, 1, 6);
		    gridPane.add(userParkingLotText, 1, 7);
		    gridPane.add(userLengthText, 1, 8);
		    gridPane.add(userCostText, 1, 9);
		    gridPane.add(confirmButton, 1, 10);

			
		    Scene scene = new Scene(gridPane);
		    stage.setScene(scene);
		    stage.show();
						
		}
	  
		public void confirmPane(Stage stage, User_Info user, String plate, String period, String duration, String lot, double cost) {
			
			
			Update_DB insertUserToDB = new Update_DB();
			int id = insertUserToDB.addNewUserInfo(user, plate, period,  duration,  lot,  cost );
			
			Text comfirmIDText = new Text("Thank you for your purchase, this is your id:  "); 
			Text userComfirmIDText = new Text(String.valueOf(id));
			
			Button finishButton = new Button("Finish");
			
			finishButton.setOnAction(e-> {
				try {
					start( stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			GridPane gridPane = new GridPane();
			
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setMinSize(500, 500);
		    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
		    gridPane.setVgap(5); 
		    gridPane.setHgap(1);
		    
		    gridPane.add(comfirmIDText, 0, 0);
		    
		    gridPane.add(userComfirmIDText, 1, 0);
		    gridPane.add(finishButton, 1, 1);
		    
		    Scene scene = new Scene(gridPane);
		    stage.setScene(scene);
		    stage.show();
			
		}
//	  public void createPermitRequest(String period, String lot, String plate){
//		  
//		  
//	  }
	 
	
	
}
