package EmployeeDataManager;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Employee_Add {
	
	public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        EmployeeDetail emp=new EmployeeDetail();
        emp.getInfo();
        
        String url = "jdbc:mysql://localhost:3306/employeedatamanager";
		String user = "root";
		String pass = "S@ty@2002";
		Connection conn = null;
		Statement stmt = null;
		
        try{
        	conn = DriverManager.getConnection(url,user,pass);
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
        	String queryCheck = "SELECT * from employee WHERE Id = " + emp.employ_id;
        	ResultSet rs = stmt.executeQuery(queryCheck); // execute the query, and get a java resultset

        	// if this ID already exists, we quit
        	if(rs.absolute(1)) {
        	     System.out.println("Employee already exists in the database...");
        	     System.out.print("\nPress Enter to Continue...");
                 sc.nextLine();
        	}else {
        		String exp = "insert into employee values('"+emp.employ_id+"','"+emp.employ_id+"','"+emp.father_name+"','"+emp.email+"','"+emp.position+"','"+emp.employ_contact+"','"+emp.employ_salary+"');";
        		System.out.println("\nEmployee has been Added :)\n");
        		stmt.execute(exp);
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
        	}
        	
        }
        catch(Exception e){System.out.println(e);}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
