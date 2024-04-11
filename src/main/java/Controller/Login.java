package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import dao.UserDao;
import dto.UserDto;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String email=req.getParameter("email");
	  String password=req.getParameter("password");
	  
	  UserService service=new UserService();
	  if(service.login(email,password)) {
		  UserDao dao=new UserDao();
		  req.getSession().setAttribute("user", dao.findByEmail(email));
		  resp.getWriter().print("<h1 align='center' style='color:green' > Login success!</h1>");
		  UserDto dto=dao.findByEmail(email);
			//Adding user to session
			req.getSession().setAttribute("user",dto);
		  req.getRequestDispatcher("Home.jsp").include(req,resp);
		  
	  }
	  else {
		  resp.getWriter().print("<h1 align='center' style='color:red' > Invalid credentials!</h1>");
		  req.getRequestDispatcher("Login.html").include(req,resp);
	  }
	}

}
