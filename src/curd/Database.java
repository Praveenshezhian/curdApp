package curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Database {
	Connection con;
	Scanner input=new Scanner(System.in);
	Database(){
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","Tiger@963.");
		}catch(Exception e) {
			System.out.println();
		}
	}
	public void display() {System.out.println("hi");}
	public int update() {return -1;}
	public int delete() {return -1;}
	public void cleanResource() {input.close();
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}}
	public int insert(){
		System.out.print("Enter your name :");
		
		String name=input.nextLine();
		System.out.print("Enter your Dob YYYY-MM-DD :");
		String Dob=input.nextLine();
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {date =formater.parse(Dob);}
		catch(ParseException e) {System.out.println("invalide date formate");}
		System.out.print("Enter your Gender Y/N:");
		String gender=input.nextLine();
		System.out.print("Enter Course Name :");
		String Course=input.nextLine();
		System.out.print("Enter Course Fees :");
		int fee=input.nextInt();
		try {
			String q="insert into curd(Name,Dob,Gender,course,fees)values(?,?,?,?,?)"; 
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, name);pst.setString(2,Dob );
			pst.setString(3,gender);pst.setString(4, Course);
			pst.setInt(5,fee);
			return pst.executeUpdate();
		}catch(SQLException e) {System.out.println("Error in sql query");}
		return -1;

}
}
