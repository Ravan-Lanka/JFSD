package Ques1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentSpec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/JFSD_Skill1";
		String user = "root";
		String pwd = "Raviteja@01";
		
		try {
			System.out.println("Connecting to Database... "+url);
			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Successfully Connected");
			System.out.println();
			con.setAutoCommit(false);
			Statement s = con.createStatement();
			
			
			
			System.out.println("What are you looking for?");
			System.out.println("1. Choose Specialization");
			System.out.println("2. View Student data");
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			if(n==1) {
				
				
				System.out.print("Please enter your ID: ");
				long ID = sc.nextLong();
				String query1  = "select count(*) from Student where ID ="+ID;
				ResultSet r2 = s.executeQuery(query1);
				
				//System.out.println(r2.absolute(0));
				
				r2.absolute(1);
				if(r2.getInt(1)!=0) {
					System.out.println("Oops!! You have already Selected your Specialization");
				}
				else {
					System.out.print("Please enter your name: ");
					sc.nextLine(); 
					String name = sc.nextLine(); 
					
					System.out.println("Specializations that are available are ");
					System.out.println();
					String q1 = "select * from Specialization where Avail_Slots>0";
					ResultSet r = s.executeQuery(q1);
					System.out.println("Course Code | Course Name | Slots Available");
					while(r.next()) {
						System.out.println(r.getString(1)+" | "+r.getString(2)+" | "+r.getInt(3));
						
					}
					
					
					System.out.print("\nEnter the Course Code from above to choose the Specialization: ");
					
					String cc = sc.next();
					//System.out.println(cc);
					
					String query  = "select Spec_Name from Specialization where Spec_ID="+"\""+cc+"\"";
					ResultSet r1 = s.executeQuery(query);
					r1.absolute(1);
					//System.out.println(r1.getString(1));
					
					String cn = r1.getString(1);
					
					String ins = "insert into Student(ID,name,Spec_ID,Spec_Name)values (?,?,?,?)"; 
					PreparedStatement p = con.prepareStatement(ins);
					p.setLong(1, ID);
					p.setString(2, name);
					p.setString(3, cc);
					p.setString(4, cn);
					p.executeUpdate();
					
					String UpQuery = "Update Specialization set Avail_Slots = Avail_Slots - ? where Spec_ID="+"\""+cc+"\"";
					PreparedStatement p1 = con.prepareStatement(UpQuery);
					p1.setInt(1, 1);
					p1.executeUpdate();
					con.commit();
					System.out.println("You have Successfully Selected your Specialization");
				
				}
			}
			else if(n==2) {
				String Q = "Select * from Student";
				Statement s1 = con.createStatement();
				ResultSet r1 = s1.executeQuery(Q);
				
				System.out.println("Student ID | Student Name | Selected Specialization Code | Selected Specialization Name");
				while(r1.next()) {
					System.out.println(r1.getInt(1)+"        | "+r1.getString(2)+"  | "+r1.getString(3)+"                | "+r1.getString(4));
					
				}
				
			}
			else {
				System.out.println("Please choose right option");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
