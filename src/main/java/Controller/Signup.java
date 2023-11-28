package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import dto.UserDto;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name=req.getParameter("name");
//		String email=req.getParameter("email");
//		String password=req.getParameter("password");
//		long mobile=Long.parseLong(req.getParameter("mobile"));
		
		LocalDate dob=LocalDate.parse(req.getParameter("dob"));
		
//		String gender=req.getParameter("gender");
//		int age=LocalDate.now().getYear()-dob.getYear(); //Period.between(dob,LocalDate.now().getYear();
		
		
		
//		resp.getWriter().print("<h1>");
//		resp.getWriter().print("name: "+ name + "</br>");
//		resp.getWriter().print("email: "+ email + "</br>");
//		resp.getWriter().print("password: "+ password + "</br>");
//		resp.getWriter().print("mobile: "+ mobile + "</br>");
//		resp.getWriter().print("dob: "+ dob + "</br>");
//		resp.getWriter().print("gender: "+ gender + "</br>");
//		resp.getWriter().print("age: "+ age + "</br>");
//		resp.getWriter().print("</h1>");
		
		UserDto dto=new UserDto();
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setPassword(req.getParameter("password"));
		dto.setMobile(Long.parseLong(req.getParameter("mobile")));
		dto.setDob(dob);
		dto.setGender(req.getParameter("gender"));
		dto.setAge(LocalDate.now().getYear()-dob.getYear());
		
		
		UserService service=new UserService();
		if(service.saveUser(dto))
		{
			resp.getWriter().print("<h1 align='center' style='color:green'>Account created successfully </h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
		else 
		{
			resp.getWriter().print("<h1 align='center' style='color:red'> Sorry!! Account cannot be created </h1>");
			req.getRequestDispatcher("Signup.html").include(req, resp);
			
		}
		
		
		
	}

}










