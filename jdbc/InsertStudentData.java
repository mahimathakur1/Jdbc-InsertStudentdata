package com.jdbc;

import java.sql.*;
import java.io.*;

public class InsertStudentData {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/student";
				String username="root";
				String password="root";
				Connection con=DriverManager.getConnection(url,username,password);
				
				String q="insert into student(name,rollno,age,grade) values(?,?,?,?)";
				
				//get the PreparedStatement object
				
				PreparedStatement pstm= con.prepareStatement(q);
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				
				System.out.println("Enter Name : ");
				int name=Integer.parseInt(br.readLine());
				
				System.out.println("Enter Rollno : ");
				int rollno=Integer.parseInt(br.readLine());
				
				System.out.println("Enter Age : ");
				String age=br.readLine();
				
				System.out.println("Enter Grade : ");
				String grade=br.readLine();
				
				//Set the values to query
				
				pstm.setInt(1, name);
				pstm.setInt(2, rollno);
				pstm.setString(3, age);
				pstm.setString(4, grade);
				
				int rowsAffected = pstm.executeUpdate();
	            System.out.println(rowsAffected + " row inserted...");
	            
				con.close();
				
				if(con.isClosed()) {
					System.out.println("Connection is Closed");
				}else {
					System.out.println("Connection Created");
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}

		}

	}