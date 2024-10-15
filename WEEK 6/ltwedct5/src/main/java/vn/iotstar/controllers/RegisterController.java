package vn.iotstar.controllers;

import java.io.IOException;

import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mã hóa UTF-8
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		// lấy tham số từ view
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");	
		String phone = req.getParameter("phone");
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");

		// Kiểm tra thông số
		String alertMsg = "";
		if (username.isEmpty() || password.isEmpty() || fullname.isEmpty() || email.isEmpty() || phone.isEmpty()) {
		    alertMsg = "Có thông tin còn trống !";
		    req.setAttribute("alert", alertMsg);
		    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		    return;
		}


		UserModel existingUser = service.findByUsername(username);
		if (existingUser != null) {

		    alertMsg = "Tài khoản đã tồn tại";
		    req.setAttribute("alert", alertMsg);
		    req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		} else {

		    UserModel newUser = new UserModel();
		    newUser.setFullname(fullname);
		    newUser.setEmail(email);
		    newUser.setPhone(phone);
		    newUser.setUsername(username);
		    newUser.setPassword(password);
		    
		    service.Register(newUser); 

		    HttpSession session = req.getSession(true);
		    session.setAttribute("account", newUser);
		    resp.sendRedirect(req.getContextPath() + "/waiting");
		}

	}
}
