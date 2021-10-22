package gui;

import java.io.IOException;


import client.ChatClient;
import client.ClientController;
import client.ClientUI;
import common.ChatIF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Reservation;


public  class AcademicFrameController   {
	private StudentFormController sfc;	
	private static int itemIndex = 3;
	
	@FXML
	private Button btnExit = null;
	
	@FXML
	private Button btnSend = null;
	
	@FXML
	private TextField idtxt;
	
	@FXML
	private TextField txtNV;
	
	@FXML
	private Label lblNV;
	
	@FXML
	private Label idlbl;
	
	
	private String getID() {
		return idtxt.getText();
	}
	private String getNV() {
		return txtNV.getText();
	}
	
	public void Send(ActionEvent event) throws Exception {
		String id;
		String id1;
		String Sen;
		FXMLLoader loader = new FXMLLoader();
		
		id=getID();
		id1=getNV();
		Sen = id+" "+id1;
		if(id.trim().isEmpty() || id1.trim().isEmpty())
		{

			System.out.println("You must enter an res number and visitor num");	
		}
		else
		{
			ClientUI.chat.accept(Sen);
			
			if(ChatClient.s1.getReservation_num().equals("Error"))
			{
				System.out.println("Reservation Not Found");
				
			}
			else {
				System.out.println("Reservation ID Found");
				((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
				Stage primaryStage = new Stage();
				Pane root = loader.load(getClass().getResource("/gui/StudentForm.fxml").openStream());
				StudentFormController studentFormController = loader.getController();		
				studentFormController.loadStudent(ChatClient.s1);
			
				Scene scene = new Scene(root);			
				scene.getStylesheets().add(getClass().getResource("/gui/StudentForm.css").toExternalForm());
				primaryStage.setTitle("Reservation Managment Tool");
	
				primaryStage.setScene(scene);		
				primaryStage.show();
			}
		}
	}

	public void start(Stage primaryStage) throws Exception {	
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AcademicFrame.fxml"));
				
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/gui/AcademicFrame.css").toExternalForm());
		primaryStage.setTitle("Reservation Managment Tool");
		primaryStage.setScene(scene);
		
		primaryStage.show();	 	   
	}
	
	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("exit Reservation Tool");		
	}
	
	public void loadStudent(Reservation s1) {
		this.sfc.loadStudent(s1);
	}	
	
	public  void display(String message) {
		System.out.println("message");
		
	}
	
}
