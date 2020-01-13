package springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import springmvc.product.Product;

@Controller
public class ShowController {
	
/*	@GetMapping("/show")
    public String show(Model m,@ModelAttribute Product prod) {
		
		
		m.addAttribute("prod", prod);
		return "show";
	}
	*/

	@GetMapping("/show")
	public String show(Model m,HttpServletRequest req) {
		
		int prodId=Integer.parseInt(req.getParameter("txtpid"));
		String prodName=req.getParameter("txtpname");
		float price=Float.parseFloat(req.getParameter("price"));
		m.addAttribute("ProdId",prodId);
		m.addAttribute("ProdName",prodName);
		m.addAttribute("price", price);
		return "show";
	}
	
	@GetMapping("/hello")
	public void hello(HttpServletResponse res) throws IOException {
		res.getWriter().println("Hello World");
		
	}
}
