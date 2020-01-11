package com.deloitte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.model.Person;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String uname=request.getParameter("txtuname");
	  String pswd=request.getParameter("txtpassword");
//	  float price=Float.parseFloat(request.getParameter("txtprice"));
	  
	  Person prod=new Person(uname,pswd);
	  ProductService ps=new ProductServiceImpl();
	  try {
		if(ps.addProduct(prod)) {
			response.sendRedirect("success.jsp");
		}
	} catch (Exception e) {
	
		e.printStackTrace();
	}
//	  try {
//		if(ps.deleteProduct(prod))
//			response.sendRedirect("success.jsp");
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	try {
//		if (ps.updateProduct(prod)) { 
//		response.sendRedirect("success.jsp");	
//		}
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	}

}
