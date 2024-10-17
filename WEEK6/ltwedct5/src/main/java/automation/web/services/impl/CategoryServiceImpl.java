package automation.web.services.impl;

import java.util.List;

import Automation.Web.dao.InterFaceCategoryDao;
import Automation.Web.dao.impl.CategoryDaoImpl;
import Automation.Web.entity.Category;
import Automation.Web.services.InterFaceCategoryService;

public class CategoryServiceImpl implements InterFaceCategoryService {

	InterFaceCategoryDao catedao = new CategoryDaoImpl();
	
	@Override
	public int count() {
		
		return catedao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {

		return catedao.findAll(page, pagesize);
	}

	@Override
	public Category findByCategoryname(String name) throws Exception {

		return catedao.findByCategoryname(name);
	}

	@Override
	public List<Category> findAll() {

		return catedao.findAll();
	}

	@Override
	public Category findById(int categoryid) {

		return catedao.findById(categoryid);
	}

	@Override
	public void delete(int categoryid) throws Exception {
		catedao.delete(categoryid);
	}

	@Override
	public void update(Category category) {
		catedao.update(category);
	}

	@Override
	public void insert(Category category) {
		catedao.insert(category);
		
	}
	public static void main(String[] args) {
        // Gọi hàm findAll để kiểm tra
        CategoryServiceImpl categoryService = new CategoryServiceImpl(); // Khởi tạo service
        List<Category> categories = categoryService.findAll(); // Gọi hàm findAll()
        if (categories != null && !categories.isEmpty()) {
            for (Category category : categories) {
                System.out.println("Category ID: " + category.getCategoryId());
                System.out.println("Category Name: " + category.getCategoryname());
                System.out.println("Category Image: " + category.getImage());
                System.out.println("Category Status: " + category.getStatus());
                System.out.println("--------------");
            }
        } else {
            System.out.println("Không có danh mục nào được tìm thấy.");
        }
        }
}
