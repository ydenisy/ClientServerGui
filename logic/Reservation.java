package logic;

import java.sql.Date;

public class Reservation {

	private String branch;
	private String arrive_time;
	private String reservation_time;
	private String num_of_visitors;
	private String reservation_num;
	private String phone; 
	


	
	public Reservation() {
		
	}



	public Reservation(String reservation_num,String phone,String branch,String num_of_visitors,
			String reservation_time,String arrive_time) {
		super();
		this.branch = branch;
		this.arrive_time = arrive_time;
		this.reservation_time = reservation_time;
		this.num_of_visitors = num_of_visitors;
		this.reservation_num = reservation_num;
		this.phone = phone;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getArrive_time() {
		return arrive_time;
	}



	public void setArrive_time(String arrive_time) {
		this.arrive_time = arrive_time;
	}



	public String getReservation_time() {
		return reservation_time;
	}



	public void setReservation_time(String reservation_time) {
		this.reservation_time = reservation_time;
	}



	public String getNum_of_visitors() {
		return num_of_visitors;
	}



	public void setNum_of_visitors(String num_of_visitors) {
		this.num_of_visitors = num_of_visitors;
	}



	public String getReservation_num() {
		return reservation_num;
	}



	public void setReservation_num(String reservation_num) {
		this.reservation_num = reservation_num;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String toString(){
		return String.format("%s %s %s %s %s %s \n",getReservation_num(),getPhone(),getBranch(),getNum_of_visitors(),getReservation_time(),getArrive_time());
	}
	
}

