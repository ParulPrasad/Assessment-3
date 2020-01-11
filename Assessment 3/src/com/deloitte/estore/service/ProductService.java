package com.deloitte.estore.service;

import java.sql.Connection;
import java.util.List;


import com.deloitte.model.Person;


public interface ProductService {
	boolean addProduct(Person product) throws Exception;
	
	Person getPerson(String uname) throws Exception;
	
	Connection getDbConnection() throws Exception;
}
