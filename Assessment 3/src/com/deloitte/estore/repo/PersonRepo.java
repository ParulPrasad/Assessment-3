package com.deloitte.estore.repo;
import com.deloitte.model.Person;

import java.sql.Connection;
import java.util.*;

public interface PersonRepo {
	
	boolean addProduct(Person product) throws Exception;
	
   Person getPerson(String uname) throws Exception;
	
	Connection getDbConnection() throws Exception;
	

}
