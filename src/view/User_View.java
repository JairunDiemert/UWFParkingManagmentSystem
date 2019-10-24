package view;

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
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage;

import models.User_Info; 

public class User_View extends Application{
	
	TestController control = new TestController();
	User_Info user;
	
	public static void main(String[] args) {
		launch(args);
	
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		
		Text titleText = new Text("Parking services");
		titleText.setStyle("-fx-font: normal bold 20px 'serif' ");
		
		Button purchasePermitButton = new Button("Purchase Parking Permit");
		Button exitButton = new Button("Exit");
		
		purchasePermitButton.setOnAction(e -> selectUserPane(stage));
		exitButton.setOnAction(e-> stage.close());
		
		GridPane gridPane = new GridPane();
		gridPane.setVgap(20); 
	    gridPane.setHgap(20);
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(400, 400);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.add(titleText, 0, 0);
	    gridPane.add(purchasePermitButton, 0, 1);
	    gridPane.add(exitButton, 0, 2);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.setTitle("User View Window");
	    stage.show();
	}
	
	public void selectUserPane(Stage stage) {
		
		Button newUserButton = new Button("New User");
		Button existingUserButton = new Button("Existing User");
		
		newUserButton.setOnAction(e -> enterUserInfo(stage));
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(400, 400);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(20); 
	    gridPane.setHgap(20);
	    
	    gridPane.add(newUserButton, 0, 1);
	    gridPane.add(existingUserButton, 0, 2);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();	
		
	}
	
	public void enterUserInfo(Stage stage){
		
		
		Text nameText = new Text("Name: ");;
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
		submitButton.setOnAction(e -> toUserController(stage, nameField.getText(), emailField.getText(), 
				phoneField.getText(), addressField.getText(),statusChoice.getSelectionModel().getSelectedItem()));
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(400, 400);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    gridPane.add(nameText, 0, 0);
	    gridPane.add(emailText, 0, 1);
	    gridPane.add(phoneText, 0, 2);
	    gridPane.add(addressText, 0, 3);
	    gridPane.add(statusText, 0, 4);

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

	
	public void toUserController(Stage stage, String name, String email, String phoneNum, String address, String status) {
		
		user = control.CreateUser(name, email, phoneNum, address, status);
		double cost = control.Calculation(user, "Hello", "A");
		
		addPermitPane(stage, cost, "Semester", "A");
		
			
	}
	
	public void addPermitPane(Stage stage, double cost, String period, String lot) {
		
		Text parkingLotText = new Text("Parking Lot: ");;
		Text periodText = new Text("Period: ");
		Text licensePlateText = new Text("License Plate: ");
		
		Text costText = new Text(Double.toString(cost));
		Text amountText = new Text("Amount: ");
		
		TextField licensePlateField = new TextField();
		
		ChoiceBox<String> parkingLotChoice = new ChoiceBox<>();
		ChoiceBox<String> periodChoice = new ChoiceBox<>();

		
		parkingLotChoice.getItems().addAll("A", "B", "C", "D");
		parkingLotChoice.setValue(lot);
		
		periodChoice.getItems().addAll("Hour", "Day", "Week", "Month", "Semester", "Year");
		periodChoice.setValue(period);
		
		parkingLotChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem()));
		periodChoice.setOnAction(e-> toCostCal(stage, periodChoice.getSelectionModel().getSelectedItem(),
				parkingLotChoice.getSelectionModel().getSelectedItem()));
	
		
		Button submitButton = new Button("Submit");
		//submitButton.setOnAction(e-> createPermitRequest(periodChoice.getSelectionModel().getSelectedItem(),
			//	parkingLotChoice.getSelectionModel().getSelectedItem(), licensePlateField.getText()));
		
		submitButton.setOnAction(e->{
			try {
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		GridPane gridPane = new GridPane();
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinSize(400, 400);
	    gridPane.setPadding(new Insets(10 ,10 , 10, 10));
	    
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    
	    gridPane.add(parkingLotText, 0, 0);
	    gridPane.add(periodText, 0, 1);
	    gridPane.add(licensePlateText, 0, 2);
	    gridPane.add(amountText, 0, 3);


	    gridPane.add(parkingLotChoice, 1, 0);
	    gridPane.add(periodChoice, 1, 1);
	    gridPane.add(licensePlateField, 1, 2);
	    gridPane.add(costText, 1, 3);

	    gridPane.add(submitButton, 1, 4);
	    
	    Scene scene = new Scene(gridPane);
	    stage.setScene(scene);
	    stage.show();
		
	}
	
	  public void toCostCal(Stage stage, String period, String lot) {
		  
		  double cost = control.Calculation(user, period, lot);
		  
		  addPermitPane(stage, cost, period, lot);
	  
	  }
	  
	  public void createPermitRequest(String period, String lot, String plate){
		  
		  
	  }
	 
	
	
}
