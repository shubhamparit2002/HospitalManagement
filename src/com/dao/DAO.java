package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.pojo.Patient;

public class DAO {
	private static final String username = "root";
	private static final String password = "root";
	
	private static final String url = "jdbc:mysql://localhost:3306/hospitalmanagement";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	public static PreparedStatement pstmt=null;

	
	
	static Connection con = null;
	static Statement stmt = null;
	

	
	
	public static Connection getDbConnection() {
	
	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	
	}
	
	public static void insertPatientD(Patient p)
	{
		String SQL="Insert into patient values(?,?,?,?)";
		try {
			
			pstmt=getDbConnection().prepareStatement(SQL);
			pstmt.setInt(1,p.getPid());
			pstmt.setString(2,p.getpName());
			pstmt.setInt(3,p.getAge());
			pstmt.setString(4,p.getGender());
			pstmt.executeUpdate();
			System.out.println("Data inserted Successfully");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	public static void patientById(int id) {
	
		
		String SQL = "SELECT * FROM patient WHERE Pid=?";
		try {
			pstmt = getDbConnection().prepareStatement(SQL);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int patientId = rs.getInt("Pid");
				String  patientName = rs.getString("pName");
				int patientAge = rs.getInt("age");
				String patientGender = rs.getString("gender");
				
				
				
				 System.out.println("ID: " + patientId);
	                System.out.println("Name: " + patientName);
	                System.out.println("Age:"+patientAge);
	                System.out.println("Gender: " + patientGender);
			}else {
				// Record not found, ask user to register
	            Scanner scanner = new Scanner(System.in);
	            System.out.println("Patient ID not found. Do you want to register? (Y/N)");
	            String choice = scanner.nextLine();
	            if(choice.equals("y")) {
	            	System.out.println("Enter Patient Details:");

	                System.out.print("Enter Patient ID: ");
	                int newId = scanner.nextInt();
	                scanner.nextLine(); // Consume the newline

	                System.out.print("Enter Patient Name: ");
	                String newName = scanner.nextLine();

	                System.out.print("Enter Patient Age: ");
	                int newAge = scanner.nextInt();
	                scanner.nextLine(); // Consume the newline

	                System.out.print("Enter Patient Gender: ");
	                String newGender = scanner.nextLine();
	                
	                Patient newPatient = new Patient(newId, newName, newAge, newGender);
	                
	                insertPatientD(newPatient);
	                System.out.println("Patient registered successfully.");

	            }else {
	                System.out.println("Operation cancelled.");

	            }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void fetchData() {
		String SQL = "SELECT * FROM Patient";
		
		try {
			pstmt = getDbConnection().prepareStatement(SQL);
			ResultSet rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				
				int patientId = rs.getInt("Pid");
				String  patientName = rs.getString("pName");
				int patientAge = rs.getInt("age");
				String patientGender = rs.getString("gender");
				System.out.println();
				System.out.println("--------------------");
				System.out.println();
				 System.out.println("ID: " + patientId);
	                System.out.println("Name: " + patientName);
	                System.out.println("Age:"+patientAge);
	                System.out.println("Gender: " + patientGender);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static ArrayList<Patient> insertDataToArrayList() {
String SQL = "SELECT * FROM Patient";

ArrayList<Patient> patientList = new ArrayList<>();
		
		try {
			pstmt = getDbConnection().prepareStatement(SQL);
			ResultSet rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				
				int patientId = rs.getInt("Pid");
				String  patientName = rs.getString("pName");
				int patientAge = rs.getInt("age");
				String patientGender = rs.getString("gender");
				System.out.println();
				 
				patientList.add(new Patient(patientId,patientName,patientAge,patientGender));
				
	}
}catch(Exception e ) {
	e.printStackTrace();
} 
		return patientList;	
}
	
	public static void deleteEntry(int id) {
		String Sql = "DELETE FROM Patient WHERE Pid=?";
		
		try {
			pstmt = getDbConnection().prepareStatement(Sql);
			pstmt.setInt(1,id);
			int  rs =  pstmt.executeUpdate();
			

			if(rs > 0) {
				System.out.println("Deta Deleted Successfully");
			}else {
				System.out.println("Error Occured");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

	public static void updateDetails(Patient patient) {
		
		String Sql = "UPDATE patient SET pName=?, age =? , gender=? WHERE Pid=?";
		
		try {
			pstmt = getDbConnection().prepareStatement(Sql);
			pstmt.setString(1, patient.getpName());
			pstmt.setInt(2,patient.getAge());
			pstmt.setString(3,patient.getGender());
			pstmt.setInt(4, patient.getPid());
			
			
			
			int rs = pstmt.executeUpdate();
			
			if(rs>0) {
				System.out.println("Data Update SuccessFully");
			}else {
				System.out.println("Error Occur");
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
