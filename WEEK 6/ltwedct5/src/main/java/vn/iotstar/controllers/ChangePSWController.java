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

@WebServlet(urlPatterns = { "/changepassword" })
public class ChangePSWController extends HttpServlet {


	private static final long serialVersionUID = 1L;
    IUserService service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/changepsw.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mã hóa UTF-8
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        // lấy tham số từ view
        String username = req.getParameter("uname");
        String newPassword = req.getParameter("newpsw");

        String alertMsg = "";

        if (username.isEmpty() || newPassword.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu mới không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/changepsw.jsp").forward(req, resp);
            return;
        }

        // Xử lý thay đổi mật khẩu
        UserModel user = service.findByUsername(username);

        if (user != null) {
            service.ChangePassword(username, newPassword);
            alertMsg = "Mật khẩu đã được thay đổi thành công";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else {
            alertMsg = "Tài khoản không tồn tại";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/changepsw.jsp").forward(req, resp);
        }
    }
	

}