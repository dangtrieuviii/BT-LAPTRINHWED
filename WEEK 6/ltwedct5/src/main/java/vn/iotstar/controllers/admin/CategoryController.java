package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = {"/admin/categories"})
public class CategoryController extends HttpServlet {


	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<CategoryModel> list=cateService.findALL();
		request.setAttribute("listcate", list);
		request.getRequestDispatcher("/views/admin/category-list.jsp").forward(request, response);
		
		
	}
	

}
