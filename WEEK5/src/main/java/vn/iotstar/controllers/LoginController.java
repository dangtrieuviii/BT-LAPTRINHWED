package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.utils.Contant;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IUserService Service = new UserService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mã hóa UTF-8
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		// lấy tham số từ view
		String username = req.getParameter("uname");
		String password = req.getParameter("psw");
		String remember = req.getParameter("remember");

		boolean isRememberMe = false;
		String alertMsg = "";
		
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		UserModel user = Service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);

		}
	}
	private void saveRemeberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Contant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		resp.addCookie(cookie);
		
	}

}
