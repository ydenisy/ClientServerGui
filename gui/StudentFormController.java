package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Reservation;

public class StudentFormController implements Initializable {
	private Reservation s;
		
	@FXML
	private Label lblNumber;
	@FXML
	private Label lblPhone;
	@FXML
	private Label lblBranch;
	@FXML
	private Label lblVisitors;
	@FXML
	private Label lblTime;
	@FXML
	private Label lblArrive;
	@FXML
	private Label lblRes;
	
	
	@FXML
	private TextField txtNumber;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtBranch;
	@FXML
	private TextField txtVisitors;
	@FXML
	private TextField txtTime;
	@FXML
	private TextField txtArrive;
	
	@FXML
	private Button BClose=null;
	
	

		
	
	ObservableList<String> list;
		
	public void loadStudent(Reservation s1) {
		this.s=s1;
		this.txtNumber.setText(s.getReservation_num());
		this.txtPhone.setText(s.getPhone());	
		this.txtBranch.setText(s.getBranch());
		this.txtVisitors.setText(s.getNum_of_visitors());
		this.txtTime.setText(s.getReservation_time());
		this.txtArrive.setText(s.getArrive_time());
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
