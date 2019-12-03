package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import controller.BarCode_Creator;
import controller.EndDate_Calculation;
import controller.Permit_Cost_Calculation;
import database.Read_DB;
import database.Update_DB;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField; 
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.HPos;

import models.User_Info; 

@SuppressWarnings("unused")
public class User_View extends Application{
	
	TestController control = new TestController();
	Permit_Cost_Calculation cal = new Permit_Cost_Calculation();
	User_Info user;
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Text titleText = new Text("Welcome to Campus Parking Services");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		Text emptyText = new Text("     ");
		
		Button loginButton = new Button("Log In");
		Button registerButton = new Button("Register");
		Button guestButton = new Button("Guest");
		Button lotButton = new Button("Lots Status");
		Button exitButton = new Button("Exit");
		
		loginButton.setMaxWidth(150);
		registerButton.setMaxWidth(150);
		guestButton.setMaxWidth(150);
		lotButton.setMaxWidth(150);
		exitButton.setMaxWidth(150);
		
		//purchasePermitButton.setOnAction(e -> selectUserPane(stage));
		loginButton.setOnAction(e-> loginPanel(stage));
		registerButton.setOnAction(e->enterUserInfo(stage));
		guestButton.setOnAction(e-> guestPanel(stage));
		lotButton.setOnAction(e -> {
			try {
				LotStatusPane(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		exitButton.setOnAction(e-> stage.close());
		
		VBox vbox = new VBox();
		
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(500, 500);
		
	    vbox.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    vbox.getChildren().add(titleText);
	    vbox.getChildren().add(emptyText);
	    vbox.getChildren().add(loginButton);
	    vbox.getChildren().add(registerButton);
	    vbox.getChildren().add(guestButton);
	    vbox.getChildren().add(lotButton);
	    vbox.getChildren().add(exitButton);
	    
	    Scene scene = new Scene(vbox);
	    stage.setScene(scene);
	    stage.setTitle("User View Window");
	    stage.show();
	}
	
	public void loginPanel(Stage stage) {
		
		Text titleText = new Text("Please login with your email and password.");
		titleText.setStyle("-fx-font: normal bold 18px 'serif' ");
		
		//spacing
		Text emptyText = new Text("    ");
		Text empty1Text = new Text("    ");
		Text empty2Text = new Text("    ");
		
		Text emailText = new Text("Please enter your email: ");
		TextField emailField = new TextField();
		
		Text passwordText = new Text("Please enter your password: ");
		TextField passwordField = new TextField();
		
		Button loginButton = new Button("Login");
		Button backButton = new Button("Back");
		
		loginButton.setMaxWidth(100);
		backButton.setMaxWidth(100);
		
			
		loginButton.setOnAction(e-> determentPane(stage, emailField.getText(),passwordField.getText()));
	
		
		backButton.setOnAction(e-> {
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
	    gridPane.setHgap(5);
	    
	    gridPane.add(titleText,0,0,2,1);
	    gridPane.add(emptyText, 0,1);	  
	    gridPane.add(empty2Text, 0,2);
	    gridPane.add(emailText, 0, 3);
	    gridPane.add(emailField, 1, 3);
	    
	    gridPane.add(passwordText, 0, 4);
	    gridPane.add(passwordField, 1, 4);
	    
	    gridPane.add(empty1Text, 0, 5);
	    gridPane.add(loginButton, 1, 6);
	    GridPane.setHalignment(loginButton, HPos.RIGHT);
	    gridPane.add(backButton, 0, 6);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();
		
	}
	
	public void guestPanel(Stage stage) {
		
		
		Text titleText = new Text("Guest                      ");
		
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		Text emptyText = new Text("     ");
		
		Button purchaseButton = new Button("Purchase Permit");
		Button permitInfoButton = new Button("Review Permit Info");
		Button barcodeButton = new Button("Print Barcode");
		Button backButton = new Button("Back");
		Button exitButton = new Button("Exit");
		
		purchaseButton.setMaxWidth(150);
		permitInfoButton.setMaxWidth(150);
		barcodeButton.setMaxWidth(150);
		backButton.setMaxWidth(250);
		exitButton.setMaxWidth(250);
		
		double cost = cal.guestCal("Semester", "A", "1");
		
		
		purchaseButton.setOnAction(e-> guestPurchasePanel(stage,cost, "Semester", "A", "1" , "", ""));
		permitInfoButton.setOnAction(e-> guestPanel(stage));
		barcodeButton.setOnAction(e-> guestPanel(stage));
		backButton.setOnAction(e-> {
			try {
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		exitButton.setOnAction(e-> stage.close());
		
		VBox vbox = new VBox();
		//VBox v = new VBox(new Group(backButton), exitButton);
		GridPane gridPane = new GridPane();
		
		gridPane.add(backButton, 0, 0);
		gridPane.add(exitButton, 4, 0);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(0 ,0,0, 0));
	    gridPane.setHgap(18);
	    
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(500, 500);
		
	    vbox.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    vbox.getChildren().add(titleText);
	    vbox.getChildren().add(purchaseButton);
	    vbox.getChildren().add(permitInfoButton);
	    vbox.getChildren().add(barcodeButton);
	    vbox.getChildren().add(gridPane);
	    
	    Scene scene = new Scene(vbox);
	    stage.setScene(scene);
	    stage.show();
		
		
	}
	
	public void guestPurchasePanel(Stage stage, double cost, String period, String lot,String duration, String email, String plate) {
		
		Text titleText = new Text("Guest Purchase: ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		Text emailText = new Text("Email: ");
		TextField emailField = new TextField(email);
		
		Text emptyText = new Text("     ");
		Text empty1Text = new Text("     ");
		
		
	
		DecimalFormat df = new DecimalFormat("#.00");
		
		Text parkingLotText = new Text("Parking Lot: ");
		Text periodText = new Text("Period: ");
		Text licensePlateText = new Text("License Plate: ");
		Text startDateText = new Text("Start Date");
		
		Text costText = new Text("$ " + df.format(cost));
		Text amountText = new Text("Amount: ");
		
		TextField licensePlateField = new TextField(plate);
		
		ChoiceBox<String> parkingLotChoice = new ChoiceBox<>();
		ChoiceBox<String> periodChoice = new ChoiceBox<>();
		ChoiceBox<String> durationChoice = new ChoiceBox<>();
		
		DatePicker datePicker = new DatePicker();
        datePicker.setEditable(false);
        datePicker.setValue(LocalDate.now());
        
		parkingLotChoice.getItems().addAll("A", "B", "C", "D");
		parkingLotChoice.setValue(lot);
		
		periodChoice.getItems().addAll("Hour", "Day", "Week", "Month", "Semester", "Year");
		periodChoice.setValue(period);
		
		durationChoice.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
		durationChoice.setValue(duration);
		
		parkingLotChoice.setOnAction(e-> guestCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem(),
				emailField.getText(),licensePlateField.getText()));
		periodChoice.setOnAction(e-> guestCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem(),
				emailField.getText(),licensePlateField.getText()));
		durationChoice.setOnAction(e-> guestCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem(),
				emailField.getText(),licensePlateField.getText()));
		
		
		
		Button submitButton = new Button("Submit");
		Button backButton = new Button("Back");
		
		submitButton.setMaxWidth(100);
		backButton.setMaxWidth(100);
		
		backButton.setOnAction(e-> guestPanel(stage));
		submitButton.setOnAction(e-> guestInfoPane(stage, emailField.getText(), licensePlateField.getText(), periodChoice.getSelectionModel().getSelectedItem(),
				durationChoice.getSelectionModel().getSelectedItem(), parkingLotChoice.getSelectionModel().getSelectedItem(), cost,
				datePicker.getValue()));
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    
	    gridPane.add( titleText, 0, 0,2,1);
	    gridPane.add(emptyText, 0, 1);
	    gridPane.add(emailText, 0, 2);
	    gridPane.add(parkingLotText, 0, 3);
	    gridPane.add(periodText, 0, 4);
	    gridPane.add(startDateText, 0, 5);
	    gridPane.add(licensePlateText, 0, 6);
	    gridPane.add(amountText, 0, 7);
	    gridPane.add(empty1Text, 0, 8);
	    gridPane.add(backButton, 0, 9);


	    gridPane.add(emailField, 1, 2);
	    gridPane.add(parkingLotChoice, 1, 3);
	    gridPane.add(periodChoice, 1, 4);
	    gridPane.add(durationChoice, 1, 4);
	    GridPane.setHalignment(periodChoice, HPos.CENTER);
	    gridPane.add(datePicker, 1, 5);
	    gridPane.add(licensePlateField, 1, 6);
	    gridPane.add(costText, 1, 7);
	    gridPane.add(submitButton, 1, 9);
	    GridPane.setHalignment(submitButton, HPos.RIGHT);
	
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();	
		
	}
	@SuppressWarnings("deprecation")
	private void guestInfoPane(Stage stage, String email, String plate, String period, String duration,
			String lot, double cost, LocalDate value) {
		
		java.util.Date date = java.sql.Date.valueOf(value);
		EndDate_Calculation dateCalc = new EndDate_Calculation();
		dateCalc.setStartDate(date.getYear(), date.getMonth(), date.getDate(), 0);
		dateCalc.setEndDate(period, duration, dateCalc.getStartDate());
	

		Text titleText = new Text("Guest Purchase: ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		DecimalFormat df = new DecimalFormat("#.00");
		Text emailText = new Text("Email: ");
		Text licenseText = new Text("license plate: ");
		Text parkingLotText = new Text("Parking Lot: ");
		Text lengthText = new Text("Duration: ");
		Text startDateText = new Text("Start Date: ");
		Text endDateText = new Text("End Date: ");
		
		Text costText = new Text("Total Cost: ");
		
		Text userEmailText = new Text(email);
		Text userLicenseText = new Text(plate);
		Text userParkingLotText = new Text(lot);
		Text userLengthText = new Text(duration + " " + period + "(s)");
		Text userStartDateText = new Text(dateCalc.getStartDate().toString());
		Text userEndDateText = new Text(dateCalc.getEndDate().toString());
		Text userCostText = new Text("$ " + df.format(cost));
		
		Button confirmButton = new Button("Confirm");
		Button backButton = new Button("Back");
		
		confirmButton.setMaxWidth(100);
		backButton.setMaxWidth(100);

		backButton.setOnAction(e-> guestPurchasePanel(stage, cost, period, lot, duration,email,plate));
		confirmButton.setOnAction(e-> confirmGuestPane( stage, email ,plate, period,  duration,  lot,  cost)); 
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    gridPane.setVgap(5); 
	    gridPane.setHgap(1);
	    
	    gridPane.add(titleText, 0, 0,2,1);
	    gridPane.add(emailText, 0, 3);
	    gridPane.add(licenseText, 0, 4);
	    gridPane.add(parkingLotText, 0, 5);
	    gridPane.add(lengthText, 0, 6);
	    gridPane.add(startDateText, 0, 7);
	    gridPane.add(endDateText, 0, 8);
	    gridPane.add(costText, 0, 9);
	    gridPane.add(backButton, 0, 12);
	    

	    gridPane.add(userEmailText, 1, 3);
	    gridPane.add(userLicenseText, 1, 4);
	    gridPane.add(userParkingLotText, 1, 5);
	    gridPane.add(userLengthText, 1,6);
	    gridPane.add(userStartDateText, 1, 7);
	    gridPane.add(userEndDateText, 1, 8);
	    gridPane.add(userCostText, 1, 9);
	    gridPane.add(confirmButton, 1, 12);
	    GridPane.setHalignment(confirmButton, HPos.RIGHT);
		
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();
	    
		
	}

	private Object confirmGuestPane(Stage stage, String email, String plate, String period, String duration, String lot,
			double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	public void guestCal(Stage stage, String period, String lot, String duration,String email, String plate) {
		  
		double cost = cal.guestCal( period, lot, duration);
		  
		guestPurchasePanel(stage, cost, period, lot, duration,email,plate);
	  
	}
	
	public void determentPane(Stage stage, String email, String password ) {
		
		Read_DB readDB = new Read_DB();
		
		@SuppressWarnings("static-access")
		String exist[] = readDB.findStatus(email, password);
		
		
		
		if(exist[6].compareTo("Student") == 0) {
			
			
			mainUserPane(stage,exist);
		}

		if(exist[6] == "") {
			
			Text errorText = new Text("Error Message!");
			errorText.setStyle("-fx-font: normal bold 20px 'serif' ");
			Text emptyText = new Text("    ");
			Text empty1Text = new Text("    ");
			
			Text titleText = new Text("You have entered either wrong password or email or the account didn't exist!");
			Button backButton = new Button("Back");
			backButton.setMaxWidth(100);
			backButton.setOnAction(e-> loginPanel(stage));
			
			GridPane gridPane = new GridPane();
			
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setMinSize(500, 500);
		    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
		 
		    gridPane.setVgap(5); 
		    gridPane.setHgap(5);
		    
		    gridPane.add(errorText,0,0,2,1);
		    GridPane.setHalignment(errorText, HPos.LEFT);
		    
		    gridPane.add(emptyText,0,1);
		    gridPane.add(titleText,0,2,2,1);
		    gridPane.add(empty1Text,0,3);
		    GridPane.setHalignment(backButton, HPos.RIGHT);
		    gridPane.add(backButton, 1, 4);
		    
		    Scene scene = new Scene(gridPane);
		    stage.setScene(scene);
		    stage.show();
		    
		}
	}
	
	public void mainUserPane(Stage stage,String[] arr) {
		
		Text titleText = new Text("Account Info:                 ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		Text emptyText = new Text("                ");
		
		
		Button viewUserInfoButton = new Button("View User Info");
		Button viewUserPermitButton = new Button("View Permit Info");
		Button purchasePermitButton = new Button("Purchase Permit");
		Button logoutButton = new Button("Log Out");
		
		viewUserInfoButton.setMaxWidth(150);
		viewUserPermitButton.setMaxWidth(150);
		purchasePermitButton.setMaxWidth(150);
		logoutButton.setMaxWidth(150);
		
		viewUserInfoButton.setOnAction(e-> ViewUserInfoPain(stage,arr));
		purchasePermitButton.setOnAction(e-> userPurchasePermit(stage, arr));
		viewUserPermitButton.setOnAction(e-> userPermitView(stage, arr));
		
		logoutButton.setOnAction(e-> {
			try {
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		VBox vbox = new VBox();
		
		vbox.setSpacing(20);
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(500, 500);
	    vbox.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    vbox.getChildren().add(titleText);
	    vbox.getChildren().add(emptyText);
	    vbox.getChildren().add(viewUserInfoButton);
	    vbox.getChildren().add(viewUserPermitButton);
	    vbox.getChildren().add(purchasePermitButton);
	    vbox.getChildren().add(logoutButton);
	    
	    Scene scene = new Scene(vbox);
	    stage.setScene(scene);
	    stage.show();	
	    	
	}
	/*
	
	s.execute("CREATE TABLE ParkingManagement" +
			  "(name varchar(50), address varchar(50), email varchar(50),phone_number varchar(50),"
			  + "status varchar(50), license_plate varchar(50), parking_lot varchar(50), period varchar(50), duration varchar(50), "
			  + "cost double, userID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 70000000, INCREMENT BY 1),UNIQUE(userID))");*/
	
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
	resultSet[10] = String.valueOf(rs.getInt("userID"));
	
	*/
	private void userPermitView(Stage stage, String[] arr) {
		
		Read_DB readDB = new Read_DB();
		
		@SuppressWarnings("static-access")
		String exist[] = readDB.findUser(arr[2]);
		
		Text titleText = new Text("Permit Info:                           ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		Text emptyText = new Text("                ");
		
		
		Button backButton = new Button("Back");
		
		backButton.setMaxWidth(150);
		backButton.setOnAction(e-> mainUserPane(stage,arr));
		
		DecimalFormat df = new DecimalFormat("#.00");
		Text emailText = new Text("Email: ");
		Text licenseText = new Text("license plate: ");
		Text parkingLotText = new Text("Parking Lot: ");
		Text lengthText = new Text("Duration: ");	
		Text costText = new Text("Total Cost: ");
		
		Text userEmailText = new Text(exist[2]);
		Text userLicenseText = new Text(exist[5]);
		Text userParkingLotText = new Text(exist[6]);
		Text userLengthText = new Text(exist[8] + " " + exist[7] + "(s)");
		//Text userStartDateText = new Text(dateCalc.getStartDate().toString());
		//Text userEndDateText = new Text(dateCalc.getEndDate().toString());
		
		Text userCostText = new Text("$ " + df.format(Double.parseDouble(exist[9]) ));
		
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    gridPane.add( titleText, 0, 0,2,1);
	    gridPane.add( emptyText, 0, 1,2,1);

	    gridPane.add(emailText, 0, 3);
	    gridPane.add(licenseText, 0, 4);
	    gridPane.add(parkingLotText, 0, 5);
	    gridPane.add(lengthText , 0, 6);
	    gridPane.add(costText, 0, 7);   
	    gridPane.add(backButton, 1, 10);
	    GridPane.setHalignment(backButton, HPos.RIGHT);
	   
	    gridPane.add(userEmailText, 1, 3);
	    gridPane.add(userLicenseText, 1, 4);
	    gridPane.add(userParkingLotText, 1, 5);
	    gridPane.add(userLengthText, 1, 6);
	    gridPane.add(userCostText, 1, 7);
	    
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();	
		
		
		
	}

	public void userPurchasePermit(Stage stage, String arr[]) {
		user = control.CreateUser(arr[1], arr[2], arr[3], arr[4], arr[6],arr[5]);
		double cost = control.Calculation(user, "Semester", "A", "1");
		
		addPermitPane(stage, cost, "Semester", "A", "1","", arr);	
		
	}


	public void ViewUserInfoPain(Stage stage, String arr[]) {
		
		Text titleText = new Text("User Info:                     ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Text nameText = new Text("Name: ");
		Text emailText = new Text("Email: ");
		Text IDText = new Text("ID:");
		Text phoneText = new Text("Phone Number: ");
		Text addressText = new Text("Adddress: ");
		Text statusText = new Text("Status: ");
		
		Text userNameText = new Text(arr[1]);
		Text userIDText = new Text(arr[0]);
		Text userAddressText = new Text(arr[4]);
		Text userEmailText = new Text(arr[2]);
		Text userPhoneText = new Text(arr[3]);
		Text userStatusText = new Text(arr[6]);
		
		Button backButton = new Button("Back");
		Button editButton = new Button("Edit");//jairun
		backButton.setMaxWidth(70);
		editButton.setMaxWidth(70);
		
		backButton.setOnAction(e-> mainUserPane(stage, arr));
		editButton.setOnAction(e-> editUserPane(stage, arr));
		
	
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(25);
	    
	    gridPane.add(titleText, 0, 0,2,1);
	    gridPane.add(nameText, 0, 4);
	    gridPane.add(IDText, 0, 5);
	    gridPane.add(addressText, 0, 6);
	    gridPane.add(emailText, 0, 7);
	    gridPane.add(phoneText, 0,8);
	    gridPane.add(statusText, 0, 9);
	    
	    gridPane.add(userNameText, 1, 4);
	    gridPane.add(userIDText, 1, 5);
	    gridPane.add(userAddressText, 1, 6);
	    gridPane.add(userEmailText, 1, 7);
	    gridPane.add(userPhoneText, 1, 8);
	    gridPane.add(userStatusText, 1, 9);
	    
	    gridPane.add(backButton, 0, 12);
	    gridPane.add(editButton, 1, 12);
	    
	    Scene scene  = new Scene(gridPane);
		stage.setScene(scene);
	}
	
	
	public void editUserPane(Stage stage, String arr[]){
		
		Text titleText = new Text("User Editing:                     ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Text nameText = new Text("Name: ");
		Text emailText = new Text("Email: ");
		Text IDText = new Text("ID:");
		Text phoneText = new Text("Phone Number: ");
		Text addressText = new Text("Adddress: ");
		Text statusText = new Text("Status: ");
		
		
		TextField userNameText = new TextField(arr[1]);
		Text userIDText = new Text(arr[0]);
		TextField userAddressText = new TextField(arr[4]);
		TextField userEmailText = new TextField(arr[2]);
		TextField userPhoneText = new TextField(arr[3]);
		Text userStatusText = new Text(arr[6]);
		
		Button backButton = new Button("Back");
		Button updateButton = new Button("Update");
		backButton.setMaxWidth(70);
		updateButton.setMaxWidth(70);
		
		backButton.setOnAction(e-> mainUserPane(stage,arr));
		
		updateButton.setOnAction(e -> updateUserRequest(arr, stage, userNameText.getText(), userEmailText.getText(), 
				userPhoneText.getText(), userAddressText.getText(), userStatusText.getText()));
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(15);
	    
	    gridPane.add(titleText, 0, 0,2,1);
	    gridPane.add(nameText, 0, 4);
	    gridPane.add(IDText, 0, 5);
	    gridPane.add(addressText, 0, 6);
	    gridPane.add(emailText, 0, 7);
	    gridPane.add(phoneText, 0,8);
	    gridPane.add(statusText, 0, 9);
	    
	    gridPane.add(userNameText, 1, 4);
	    gridPane.add(userIDText, 1, 5);
	    gridPane.add(userAddressText, 1, 6);
	    gridPane.add(userEmailText, 1, 7);
	    gridPane.add(userPhoneText, 1, 8);
	    gridPane.add(userStatusText, 1, 9);
	    
	    gridPane.add(backButton, 0, 12);
	    gridPane.add(updateButton, 1, 12);
	    GridPane.setHalignment(updateButton, HPos.RIGHT);
	    
	    Scene scene  = new Scene(gridPane);
		stage.setScene(scene);
	}
	
	
	public void enterUserInfo(Stage stage){
		
		Text titleText = new Text("Register          ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Text nameText = new Text("Name: ");
		Text emailText = new Text("Email: ");
		Text phoneText = new Text("Phone Number: ");
		Text addressText = new Text("Adddress: ");
		Text statusText = new Text("Status: ");
		Text passwordText = new Text("Password: ");
		
		TextField nameField = new TextField();
		TextField emailField = new TextField();
		TextField phoneField = new TextField();
		TextField addressField = new TextField();
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Your password");
		
		ChoiceBox<String> statusChoice = new ChoiceBox<>();
		
		statusChoice.getItems().addAll("Student", "Employee", "Veteran", "Guest");
		statusChoice.setValue("Student");
		
		Button submitButton = new Button("Submit");
		Button backButton = new Button("Back");
		
		submitButton.setMaxWidth(90);
		backButton.setMaxWidth(90);
		
		backButton.setOnAction(e-> {
			try {
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		//System.out.println(statusChoice.getSelectionModel().getSelectedItem());
		submitButton.setOnAction(e -> newUserRequest(stage, nameField.getText(), emailField.getText(), 
				phoneField.getText(), addressField.getText(),statusChoice.getSelectionModel().getSelectedItem(),passwordField.getText()));
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    gridPane.add(titleText, 0, 0,2,1);
	    gridPane.add(nameText, 0, 3);
	    gridPane.add(emailText, 0, 4);
	    gridPane.add(phoneText, 0, 5);
	    gridPane.add(addressText, 0, 6);
	    gridPane.add(statusText, 0, 7);
	    gridPane.add(passwordText, 0, 8);
	    
	    gridPane.add(backButton, 0, 11);

	    gridPane.add(nameField, 1, 3);
	    gridPane.add(emailField, 1, 4);
	    gridPane.add(phoneField, 1, 5);
	    gridPane.add(addressField, 1, 6);
	    gridPane.add(statusChoice, 1, 7);
	    gridPane.add(passwordField, 1, 8);
	    
	    gridPane.add(submitButton, 1, 11);
	    GridPane.setHalignment(submitButton, HPos.RIGHT);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();		
	}
	
	
	public void updateUserRequest(String arr[], Stage stage, String name, String email, String phoneNum, String address, String status) {
		
		arr[1] = name;
		arr[2] = email;
		arr[3] = phoneNum;
		arr[4] = address;
	
		int user_ID = Integer.parseInt(arr[0]);
		user = control.CreateUser(arr[1],arr[2],arr[3],arr[4],arr[6],arr[5]);
		
		Update_DB insertUserToDB = new Update_DB();
		insertUserToDB.updateUserInfo(user_ID, user);
		System.out.println( "info up to date" );
		
		ViewUserInfoPain(stage, arr);
		
		
		
	}
	
	public void addPermitPane(Stage stage, double cost, String period, String lot, String duration,String plate, String arr[]) {
		
		DecimalFormat df = new DecimalFormat("#.00");
		Text titleText = new Text("User Purchase: ");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Text parkingLotText = new Text("Parking Lot: ");
		Text periodText = new Text("Period: ");
		Text licensePlateText = new Text("License Plate: ");
		Text startDateText = new Text("Start Date");
		
		Text costText = new Text("$ " + df.format(cost));
		Text amountText = new Text("Amount: ");
		
		TextField licensePlateField = new TextField(plate);
		
		ChoiceBox<String> parkingLotChoice = new ChoiceBox<>();
		ChoiceBox<String> periodChoice = new ChoiceBox<>();
		ChoiceBox<String> durationChoice = new ChoiceBox<>();
		
		DatePicker datePicker = new DatePicker();
        datePicker.setEditable(false);
        datePicker.setValue(LocalDate.now());
        
		parkingLotChoice.getItems().addAll("A", "B", "C", "D");
		parkingLotChoice.setValue(lot);
		
		periodChoice.getItems().addAll("Hour", "Day", "Week", "Month", "Semester", "Year");
		periodChoice.setValue(period);
		
		durationChoice.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
		durationChoice.setValue(duration);
		
		parkingLotChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem(),licensePlateField.getText(), arr));
		periodChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem(),licensePlateField.getText(),arr));
		durationChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem(),durationChoice.getSelectionModel().getSelectedItem(),licensePlateField.getText(), arr));
		
		Button submitButton = new Button("Submit");
		Button backButton = new Button("Back");
		
		backButton.setOnAction(e-> mainUserPane(stage,arr));
		submitButton.setOnAction(e-> userInfoPane(stage, licensePlateField.getText(), periodChoice.getSelectionModel().getSelectedItem(),
				durationChoice.getSelectionModel().getSelectedItem(), parkingLotChoice.getSelectionModel().getSelectedItem(), cost,
				datePicker.getValue(), arr));
		
		submitButton.setMaxWidth(70);
		backButton.setMaxWidth(70);

		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    gridPane.setVgap(5); 
	    gridPane.setHgap(1);
	    
	    gridPane.add( titleText, 0, 0,2,1);
	    
	    gridPane.add(parkingLotText, 0, 3);
	    gridPane.add(periodText, 0, 4);
	    gridPane.add(startDateText, 0, 5);
	    gridPane.add(licensePlateText, 0, 6);
	    gridPane.add(amountText, 0, 7);
	    gridPane.add(backButton, 0, 9);

	    gridPane.add(parkingLotChoice, 1, 3);
	    gridPane.add(periodChoice, 1, 4);
	    GridPane.setHalignment(periodChoice, HPos.CENTER);
	    gridPane.add(durationChoice, 1, 4);
	    gridPane.add(datePicker, 1, 5);
	    gridPane.add(licensePlateField, 1, 6);
	    gridPane.add(costText, 1, 7);
	    gridPane.add(submitButton, 1, 9);
	    GridPane.setHalignment(submitButton, HPos.RIGHT);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();	
	}
	
		public void toCostCal(Stage stage, String period, String lot, String duration, String plate, String arr[]) {
			  
			double cost = control.Calculation(user, period, lot, duration);
			 
			addPermitPane(stage, cost, period, lot, duration, plate, arr);
		  
		}
	  
		
		
		public void newUserRequest(Stage stage, String name, String email, String phoneNum, String address,  String status,String password) {
			
			user = control.CreateUser(name, email, phoneNum, address, status, password);
		
			
			Update_DB insertUserToDB = new Update_DB();
			insertUserToDB.insertUserInfo(user);
			newUserConfirmation(stage);
		}
		
	
		public void newUserConfirmation(Stage stage) {
			
			Text titleText  = new Text("Your account was created successfully");
			
			
			
			Button finishButton  = new Button("Finish");
			
			VBox vbox = new VBox();
			
			finishButton.setOnAction(e-> {
				try {
					start(stage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			vbox.setSpacing(20);
			vbox.setAlignment(Pos.CENTER);
			vbox.setMinSize(500, 500);
			
		    vbox.setPadding(new Insets(10 ,10 , 10, 10));
		    
		    vbox.getChildren().add(titleText);
			vbox.getChildren().add(finishButton);
			Scene scene = new Scene(vbox);
			stage.setScene(scene);
		    stage.show();
			
			
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

		@SuppressWarnings("deprecation")
		public void userInfoPane(Stage stage, String plate, String period, String duration, String lot, double cost, LocalDate localDate, String arr[]) {
			
			java.util.Date date = java.sql.Date.valueOf(localDate);
			EndDate_Calculation dateCalc = new EndDate_Calculation();
			dateCalc.setStartDate(date.getYear(), date.getMonth(), date.getDate(), 0);
			dateCalc.setEndDate(period, duration, dateCalc.getStartDate());
		
			
			Text titleText = new Text("User Permit Confirmation: ");
			titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
			
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
			Text startDateText = new Text("Start Date: ");
			Text endDateText = new Text("End Date: ");
			
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
			Text userStartDateText = new Text(dateCalc.getStartDate().toString());
			Text userEndDateText = new Text(dateCalc.getEndDate().toString());
			Text userCostText = new Text("$ " + df.format(cost));
			
			Button confirmButton = new Button("Confirm");
			Button backButton = new Button("Back");
			
			confirmButton.setMaxWidth(100);
			backButton.setMaxWidth(100);
			
			backButton.setOnAction(e-> addPermitPane(stage, cost, period, lot, duration, plate, arr));
			confirmButton.setOnAction(e-> confirmPane( stage, user,plate, period,  duration,  lot,  cost,arr)); 
			
			
			GridPane gridPane = new GridPane();
			
			
			gridPane.setAlignment(Pos.CENTER);
			gridPane.setMinSize(500, 500);
		    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
		    gridPane.setVgap(5); 
		    gridPane.setHgap(10);
		  
		    gridPane.add(titleText, 0, 0,2,1);
		    gridPane.add(nameText, 0, 3);
		    //gridPane.add(IDText, 0, 4);
		    gridPane.add(addressText, 0, 5);
		    gridPane.add(emailText, 0, 6);
		    gridPane.add(phoneText, 0, 7);
		    gridPane.add(statusText, 0, 8);
		    gridPane.add(licenseText, 0, 9);
		    gridPane.add(parkingLotText, 0, 10);
		    gridPane.add(lengthText, 0, 11);
		    gridPane.add(startDateText, 0, 12);
		    gridPane.add(endDateText, 0, 13);
		    gridPane.add(costText, 0, 14);
		    gridPane.add(backButton, 0, 17);
		    
		    gridPane.add(userNameText, 1, 3);
		    //gridPane.add(userIDText, 1, 4);
		    gridPane.add(userAddressText, 1, 5);
		    gridPane.add(userEmailText, 1, 6);
		    gridPane.add(userPhoneText, 1, 7);
		    gridPane.add(userStatusText, 1, 8);
		    gridPane.add(userLicenseText, 1, 9);
		    gridPane.add(userParkingLotText, 1, 10);
		    gridPane.add(userLengthText, 1, 11);
		    gridPane.add(userStartDateText, 1, 12);
		    gridPane.add(userEndDateText, 1, 13);
		    gridPane.add(userCostText, 1, 14);
		    gridPane.add(confirmButton, 1, 17);
		    GridPane.setHalignment(confirmButton, HPos.RIGHT);
			
		    Scene scene = new Scene(gridPane);
		    stage.setScene(scene);
		    stage.show();
						
		}
	  
	public void confirmPane(Stage stage, User_Info user, String plate, String period, String duration, String lot,
			double cost,String arr[]) {

		user.setUserEmail(arr[2]);
		Update_DB insertUserToDB = new Update_DB();
		int id = insertUserToDB.addNewUserInfo(user, plate, period, duration, lot, cost);
		
		
		Text comfirmIDText =  new Text("Thank you for your purchase.");
		comfirmIDText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Text emptyText =  new Text("                  ");
		
		BarCode_Creator barCode;
		try {
			BarCode_Creator.crateBarcode(id);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Button backButton = new Button("Back");
		Button finishButton = new Button("Finish");

		finishButton.setOnAction(e -> {
			try {
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		backButton.setOnAction(e-> mainUserPane(stage,arr));
		finishButton.setMaxWidth(150);
		backButton.setMaxWidth(150);
		

		FileInputStream inputstream = null;
		try {
			inputstream = new FileInputStream("BarCodeStuff"+"/"+"images"+"/"+"out.png");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		Image img = new Image(inputstream); 
		
		VBox vbox = new VBox();
		
		GridPane gridPane = new GridPane();
		
		gridPane.add(backButton, 0, 0);
		gridPane.add(finishButton, 4, 0);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(10 ,10,0, 0));
	    gridPane.setHgap(25);
	    
		vbox.setAlignment(Pos.CENTER);
		vbox.setMinSize(500, 500);
	    vbox.setPadding(new Insets(10 ,10 , 10, 10));
	    vbox.setSpacing(20);
	    
	    
	    vbox.getChildren().add(comfirmIDText);
	    vbox.getChildren().add(emptyText);
	    vbox.getChildren().add(new ImageView(img));
	    vbox.getChildren().add(gridPane);
	    
	   
	    Scene scene = new Scene(vbox);
	    stage.setScene(scene);
	    stage.show();

	}
	
    @SuppressWarnings("unchecked")
	public void LotStatusPane(Stage stage) throws Exception {
    	
        stage.setTitle("UWF Lot Visualizations");
        stage.show();
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(0, 100, 5);
        xAxis.setLabel("Time");
        xAxis.setAnimated(true);
        yAxis.setLabel("Population");
        yAxis.setAnimated(true);

        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Real Time Lot Population");
        lineChart.setAnimated(false);
        
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Lot A");    
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Lot B");
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("Lot C");
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        series4.setName("Lot D");

        lineChart.getData().addAll(series1, series2, series3, series4); 
        Scene scene = new Scene(lineChart, 1000, 800);
        stage.setScene(scene);
        
        
        
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        
        //This is a temporary setup for presentation purposes to show how the real time updates work.
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Integer random = ThreadLocalRandom.current().nextInt(100); //assuming 100 parking spots per lot

            Platform.runLater(() -> {
                Date now = new Date();
                series1.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), random));
                Integer random2 = ThreadLocalRandom.current().nextInt(100);
                series2.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), random2));
                Integer random3 = ThreadLocalRandom.current().nextInt(100);
                series3.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), random3));
                Integer random4 = ThreadLocalRandom.current().nextInt(100);
                series4.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), random4));
                //only 5 points plotted per lot on screen at a time
                final int SIZE = 5;
                if (series1.getData().size() > SIZE)
                    series1.getData().remove(0);
                if (series2.getData().size() > SIZE)
                    series2.getData().remove(0);
                if (series3.getData().size() > SIZE)
                    series3.getData().remove(0);
                if (series4.getData().size() > SIZE)
                    series4.getData().remove(0);
            });
        }, 0, 3, TimeUnit.SECONDS);
     }    
    
	
}
