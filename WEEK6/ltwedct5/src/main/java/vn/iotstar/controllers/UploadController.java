package vn.iotstar.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.utils.ConstantUpload;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import static vn.iotstar.utils.ConstantUpload.UPLOAD_DIRECTORY;

/*@WebServlet(urlPatterns = { "/uploads" }, name = "MultiPartServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)*/
@WebServlet(urlPatterns = { "/uploads" } )
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadController extends HttpServlet  {


	private static final long serialVersionUID = 1L;
	UserServiceImpl service = new UserServiceImpl();

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return ConstantUpload.DEFAULT_FILENAME;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/uploads.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String uploadPath = File.separator + UPLOAD_DIRECTORY; //upload vào thư mục bất kỳ
		 //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY; //upload vào thư mục project
		 File uploadDir = new File(uploadPath);
		 if (!uploadDir.exists())
		 uploadDir.mkdir();
		 try {
		 String fileName = "";
		 for (Part part : req.getParts()) {
		 fileName = getFileName(part);
		 part.write(uploadPath + File.separator + fileName);
		 }
		 req.setAttribute("message", "File " + fileName + " has uploaded successfully!");
		 } catch (FileNotFoundException fne) {
		 req.setAttribute("message", "There was an error: " + fne.getMessage());
		 }
		 getServletContext().getRequestDispatcher("/views/result.jsp").forward(req, resp);
	}

}
