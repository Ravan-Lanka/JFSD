package Ques2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/JFSD_Skill1";
		String user = "root";
		String pwd = "Raviteja@01";
		
		try {
			System.out.println("Connecting to database: "+url);
			Connection con  =  DriverManager.getConnection(url,user,pwd);
			System.out.println("Successfully Connected...");
			System.out.println();
			while(true){
				System.out.println("Are you willing to change the Student Details:");
				System.out.println("1. Yes");
				System.out.println("2. No");
				Scanner sc = new Scanner(System.in);
				int n = sc.nextInt();
				if(n==1) {
					System.out.print("Enter the Student ID that you want to update: ");
					long id = sc.nextLong();
					String query = "select * from StudentBacklog where ID ="+id;
					Statement s = con.createStatement();
					ResultSet r = s.executeQuery(query);
					if(r.next() == false) {
						System.out.println("Opps!! The ID that you have entered is not present in the Database try adding it first and then visit again...\n");
					}
					else {
						float cgpa = r.getFloat("CGPA");
						int backlogs = r.getInt("NoOfBacklogs");
						System.out.println("Current CGPA: "+cgpa);
						System.out.print("Enter the CGPA that you wanna update: ");
						float new_cgpa = sc.nextFloat();
						System.out.println("Current no.of backlogs having:"+backlogs);
						System.out.print("Enter the count of number of backlogs: ");
						int new_backlog  = sc.nextInt();
						String query1 = "Update StudentBacklog set CGPA=?, NoOfBacklogs=? where Id=?";
						PreparedStatement p = con.prepareStatement(query1);
						p.setFloat(1, new_cgpa);
						p.setInt(2, new_backlog);
						p.setLong(3, id);
						p.executeUpdate();
					}
				}
				else
					break;
			}
			Statement s = con.createStatement();
			String query = "select * from Studentbacklog where CGPA<7.5";
			ResultSet r = s.executeQuery(query) ;
			System.out.println("The Students who are not eligible for CRT are:");
			while(r.next()) {
				//r.absolute(1);
				System.out.println(r.getLong("ID")+" - "+r.getString("StudentName"));
				String query1 = "delete from Studentbacklog where ID=?";
				PreparedStatement p = con.prepareStatement(query1);
				p.setLong(1, r.getLong("ID"));
				p.executeUpdate();
				//r.deleteRow();
			}
			query = "select * from Studentbacklog where NoOfBacklogs>0";
			r = s.executeQuery(query) ;
			while(r.next()) {
				System.out.println(r.getLong("ID")+" - "+r.getString("StudentName"));
				String query1 = "delete from Studentbacklog where ID=?";
				PreparedStatement p = con.prepareStatement(query1);
				p.setLong(1, r.getLong("ID"));
				p.executeUpdate();
				//r.deleteRow();
			}
			System.out.println();
			query = "select * from Studentbacklog";
			r = s.executeQuery(query);
			System.out.println("The Students who are eligible for CRT are:");
			System.out.println("Student ID"+" | "+"Student Name"+" | "+"CGPA"+" | "+"Department");
			while(r.next()) {
				System.out.println(r.getLong("ID")+" | "+r.getString("StudentName")+" | "+r.getFloat("CGPA")+" | "+r.getString("Department"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
