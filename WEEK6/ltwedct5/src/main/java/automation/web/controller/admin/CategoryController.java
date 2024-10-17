package automation.web.controller.admin;

import static automation.web.utils.ConstantUpload.UPLOAD_DIRECTORY;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Automation.Web.entity.Category;
import automation.web.services.InterFaceCategoryService;
import automation.web.services.impl.CategoryServiceImpl;
import automation.web.utils.ConstantUpload;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet(name = "MultiPartServlet", urlPatterns = { "/admin/categories", "/admin/category/create",
		"/admin/category/update", "/admin/category/delete", "/admin/category/videos" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InterFaceCategoryService cateService = (InterFaceCategoryService) new CategoryServiceImpl();

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return ConstantUpload.DEFAULT_FILENAME;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();

		if (url.contains("categories")) {
			List<Category> list = cateService.findAll();
			req.setAttribute("Listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);

		} else if (url.contains("create")) {
			req.getRequestDispatcher("/views/admin/category-create.jsp").forward(req, resp);
		}

		else if (url.contains("update")) {

			int categoryid = Integer.parseInt(req.getParameter("id"));
			Category category = cateService.findById(categoryid);
			req.setAttribute("cate", category);

			req.getRequestDispatcher("/views/admin/category-update.jsp").forward(req, resp);
		}

		else if (url.contains("delete")) {
			int categoryid = Integer.parseInt(req.getParameter("id"));
			try {
				cateService.delete(categoryid);
				List<Category> list = cateService.findAll();
				req.setAttribute("Listcate", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}

		else if (url.contains("videos")) {
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();

		if (url.contains("create")) {

			String linkimage = req.getParameter("linkimage");
			if (linkimage == null) {
				String uploadPath = File.separator + UPLOAD_DIRECTORY;
				try {
					Part filePart = req.getPart("multiPartServlet");
					String fileName = getFileName(filePart);
					if (fileName != null && !fileName.isEmpty()) {
						filePart.write(uploadPath + File.separator + fileName); // Write the file to the upload
																				// directory

						// Put values to database

						// Get parameter from view
						String categoryname = req.getParameter("categoryname");
						String status = req.getParameter("status");
						int statusint = Integer.parseInt(status);

						Category category = new Category();
						category.setCategoryname(categoryname);
						category.setImage(fileName);
						category.setStatus(statusint);

						// Call Function
						cateService.insert(category);

					}

				} catch (FileNotFoundException fne) {
					req.setAttribute("message", "There was an error: " + fne.getMessage());
				}
				resp.sendRedirect(req.getContextPath() + "/admin/categories");

			}

			else if (linkimage != null) {
				// Get parameter from view
				String categoryname = req.getParameter("categoryname");
				String status = req.getParameter("status");
				int statusint = Integer.parseInt(status);

				Category category = new Category();
				category.setCategoryname(categoryname);
				category.setImage(linkimage);
				category.setStatus(statusint);

				// Call Function
				cateService.insert(category);
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			}
		}

		else if (url.contains("update")) {

			String linkimage = req.getParameter("linkimage");
			if (linkimage == null) {
				String uploadPath = File.separator + UPLOAD_DIRECTORY;
				try {
					Part filePart = req.getPart("multiPartServlet");
					String fileName = getFileName(filePart);
					if (fileName != null && !fileName.isEmpty()) {
						filePart.write(uploadPath + File.separator + fileName); // Write the file to the upload
																				// directory

						// Put values to database

						// Get parameter from view
						String categoryname = req.getParameter("categoryname");
						String status = req.getParameter("status");
						int statusint = Integer.parseInt(status);

						Category category = new Category();
						category.setCategoryname(categoryname);
						category.setImage(fileName);
						category.setStatus(statusint);

						// Call Function
						cateService.update(category);

					}

				} catch (FileNotFoundException fne) {
					req.setAttribute("message", "There was an error: " + fne.getMessage());
				}
				resp.sendRedirect(req.getContextPath() + "/admin/categories");

			}

			else if (linkimage != null) {
				// Get parameter from view
				int categoryidint = Integer.parseInt(req.getParameter("categoryid"));
				String categoryname = req.getParameter("categoryname");
				String status = req.getParameter("status");
				int statusint = Integer.parseInt(status);

				Category category = new Category();
				category.setCategoryname(categoryname);
				category.setImage(linkimage);
				category.setStatus(statusint);
				category.setCategoryId(categoryidint);

				// Call Function
				cateService.update(category);
				resp.sendRedirect(req.getContextPath() + "/admin/categories");
			}

		}

	}
}
