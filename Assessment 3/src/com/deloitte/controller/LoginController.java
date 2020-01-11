package com.deloitte.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;
import com.deloitte.model.Person;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache no-store must-revalidate");
		
		String inUName=request.getParameter("txtuname");
		String inPassword=request.getParameter("txtpassword");
		ProductService ps=new ProductServiceImpl();
		
		
		try {
			Person p=ps.getPerson(inUName);
			String pwd=p.getPassword();
			
			if(pwd.equals(inPassword)) {
				HttpSession ssn=request.getSession();
				ssn.setAttribute("user", inUName);
				response.sendRedirect("welcome.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 
}
