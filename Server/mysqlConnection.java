package Server;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Reservation;


public class mysqlConnection {
	
	String msg;
	String msg1;
	Reservation [] r;
	public void getDetails() 
	{
		
		try 
		{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("Driver definition succeed");
        } catch (Exception ex) {
        	/* handle the error*/
        	 System.out.println("Driver definition failed");
        	 }
        
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test?serverTimezone=IST","root","1631994");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
            System.out.println("SQL connection succeed");
            //createTableCourses(conn);
            UpdateTableResv(conn);
            r=printCourses(conn);
       	} catch (SQLException ex) 
     	    {/* handle any errors*/
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
   	}


	
	public static Reservation [] printCourses(Connection con)
	{
		int i=0;
		Reservation [] r = new Reservation[4];
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM reservation;");
	 		while(rs.next())
	 		{
	 			r[i]=new Reservation(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
	 			i++;
	 		}
			rs.close();
			
		} catch (SQLException e) {e.printStackTrace();}
		return r;
	}

	public Reservation [] getres() {
		return this.r;
	}
	public static void createTableCourses(Connection con1){
		Statement stmt;
		try {
			stmt = con1.createStatement();
			stmt.executeUpdate("create table courses(num int, name VARCHAR(40), semestr VARCHAR(10));");
			stmt.executeUpdate("load data local infile \"courses.txt\" into table courses");
	 		
		} catch (SQLException e) {	e.printStackTrace();}
		 		
	}
	public void UpdateTableResv(Connection con1) {
		Statement stmt;
		try {
			stmt = con1.createStatement();
			stmt.executeUpdate("update reservation set visitors_num = '"+msg1+"' where reservation_num = '"+msg+"'");
	 		
		} catch (SQLException e) {	e.printStackTrace();}
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getMsg1() {
		return msg1;
	}



	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}


	
	
}


