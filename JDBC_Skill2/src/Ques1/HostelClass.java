package Ques1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class HostelClass {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/JFSD_Skill2";
		String user = "root";
		String pwd = "Raviteja@01";
		
		System.out.println("Connecting to Database... "+url);
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			System.out.println("Successfully Connected");
			String query = "insert into Hostel values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			long id,year,contact, pcontact;
			String fname,lname,gender,dept,pname,address,id_proof,receipt,dob;
			
			SimpleDateFormat f = new SimpleDateFormat("DD-MM-YYYY");
			System.out.print("Enter ID: ");
			id = sc.nextLong();
			System.out.print("Enter First Name: ");
			sc.nextLine();
			fname = sc.nextLine();
			System.out.print("Enter Last Name: ");
			lname = sc.nextLine();
			System.out.print("Enter Year of Study: ");
			year = sc.nextLong();
			System.out.print("Enter Gender: ");
			gender = sc.next();
			System.out.print("Enter Department: ");
			sc.nextLine();
			dept = sc.nextLine();
			System.out.print("Enter your Contact Number: ");
			contact = sc.nextLong();
			System.out.print("Enter your Date of Birth (use format: YYYY-MM-DD): ");
			dob = sc.next();
			System.out.print("Enter Parent Name: ");
			sc.nextLine();
			pname = sc.nextLine();
			System.out.print("Enter Parents Contact Number: ");
			pcontact = sc.nextLong();
			System.out.print("Enter Address: ");
			sc.nextLine();
			address = sc.nextLine();
			System.out.print("Enter Path of your ID proof(Photo of KL ID Card): ");
			id_proof = sc.next();
			System.out.print("Enter Path of your Payment Receipt: ");
			receipt = sc.next();
			
			FileInputStream photo = new FileInputStream(id_proof);
			FileInputStream recipt_photo = new FileInputStream(receipt);
			
			p.setLong(1, id);
			p.setString(2,fname);
			p.setString(3, lname);
			p.setLong(4,year);
			p.setString(5,gender);
			p.setString(6, dept);
			p.setLong(7, contact);
			p.setString(8,dob);
			p.setString(9,pname);
			p.setLong(10, pcontact);
			p.setString(11, address);
			p.setBlob(12,photo);
			p.setBlob(13, recipt_photo);
			
			int i = p.executeUpdate();
			System.out.print("Files uploaded Successfully");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
