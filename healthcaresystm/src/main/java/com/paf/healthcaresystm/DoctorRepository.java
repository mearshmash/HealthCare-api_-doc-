package com.paf.healthcaresystm;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class DoctorRepository {

	List<Doctor> doctors;
	
	Connection con = null;
	
	public DoctorRepository() {
		
		String url = "jdbc:mysql://localhost:3306/docdb";
		String username = "root";
		String password = "root";
		try {
			
			  Class.forName("com.mysql.jdbc.Driver");
		      con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Doctor> getDoctors(){
		
		List<Doctor> doctors = new ArrayList<>();
		String sql = "select * from doctor";
		try
		{
		    Statement  st = con.createStatement();
		    ResultSet  rs = st.executeQuery(sql);
		    while(rs.next())
		    {
		    	Doctor d = new Doctor();
		    	d.setName(rs.getString(1));
		    	d.setId(rs.getInt(2));
		    	
		    	doctors.add(d);
		    }
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return doctors;
	}
	
	public Doctor getDoctor(int id)
	{
		String sql = "select * from doctor where id="+id;
		Doctor d = new Doctor();
		try
		{
		    Statement  st = con.createStatement();
		    ResultSet  rs = st.executeQuery(sql);
		    if(rs.next())
		    {
		    	
		    	d.setName(rs.getString(1));
		    	d.setId(rs.getInt(2));
		    	
		    	
		    }
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return d;
	}

	public void create(Doctor d1) {
		String sql = "insert into alien values (?,?,?)";
		try 
		{
		    PreparedStatement  st = con.prepareStatement(sql);
		    st.setString(1,d1.getName());
		    st.setInt(2,d1.getId());
		    st.executeUpdate();
         
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void update(Doctor d1) {
		String sql = "update doctor set name = ?, where id=?";
		try 
		{
		    PreparedStatement  st = con.prepareStatement(sql);
		    st.setString(1,d1.getName());
		    st.setInt(2,d1.getId());
		    st.executeUpdate();
         
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String sql = "delete from doctor where id=?";
		try 
		{
		    PreparedStatement  st = con.prepareStatement(sql);
		  
		    st.setInt(1, id);
		    st.executeUpdate();
         
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
