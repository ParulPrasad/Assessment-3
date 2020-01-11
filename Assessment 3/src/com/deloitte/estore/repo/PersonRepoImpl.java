package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.deloitte.model.Person;

public class PersonRepoImpl implements PersonRepo{

	Connection con=null;
	@Override
	public boolean addProduct(Person person) throws Exception {
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("insert into Person values(?,?)");
		ps.setString(1, person.getUsername());
		ps.setString(2, person.getPassword());
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}

	@Override
	public Connection getDbConnection() throws Exception {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		return con;
	}



	@Override
	public Person getPerson(String uname) throws Exception {
	    
	    Connection con=getDbConnection();
	    Statement st=con.createStatement();
	    ResultSet rs=st.executeQuery("select username,password from Person where username='"+uname+"'");
	    Person p=new Person();
	    if(rs.next()) {
	    	p.setUsername(rs.getString(1));
	    	p.setPassword(rs.getString(2));
	    	return p;
	    }
	    
	    
	    return null;
	}

	
	

}
