package com.deloitte.estore.service;

import java.sql.Connection;
import java.util.List;


import com.deloitte.estore.repo.PersonRepo;
import com.deloitte.estore.repo.PersonRepoImpl;
import com.deloitte.model.Person;

public class ProductServiceImpl implements ProductService {
    
	PersonRepo repo=new PersonRepoImpl();
	
	@Override
	public boolean addProduct(Person product) throws Exception {
		// TODO Auto-generated method stub
		return repo.addProduct(product);
	}

	

	@Override
	public Person getPerson(String uname) throws Exception {
		// TODO Auto-generated method stub
		return repo.getPerson(uname);
		
	}



	@Override
	public Connection getDbConnection() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
