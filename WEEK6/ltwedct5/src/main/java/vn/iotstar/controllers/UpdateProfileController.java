package vn.iotstar.controllers;


import java.io.IOException;

import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name = "MultiPartServlet", urlPatterns = { "/update" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class UpdateProfileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/updateprofile.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 
			// mã hóa UTF-8
	        resp.setCharacterEncoding("UTF-8");
	        req.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/html");

	        // lấy tham số từ view
			String username = (String) req.getSession().getAttribute("username"); 
	        String fullname = req.getParameter("fullname");
	        String email = req.getParameter("email");
	        String phone = req.getParameter("phone");
	        

	        String alertMsg = "";

	        if (fullname.isEmpty() || email.isEmpty() || phone.isEmpty()) {
	            alertMsg = "Thông tin không được rỗng";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("/views/updateprofile.jsp").forward(req, resp);
	            return;
	        }

	        if (username != null) {
	            service.UpdateProfile(username, fullname, email, phone);
	            alertMsg = "Thông tin cập nhật thành công !";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("/views/result.jsp").forward(req, resp);
	        } else {
	            alertMsg = "Tài khoản không tồn tại";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("/views/updateprofile.jsp").forward(req, resp);
	        }
		
	}
}

