package automation.web.dao;

import java.util.List;

import Automation.Web.entity.Category;
import Automation.Web.entity.Video;

public interface InterFaceCategoryDao {

	int count();

	List<Category> findAll(int page, int pagesize);

	Category findByCategoryname(String name) throws Exception;

	List<Category> findAll();

	Category findById(int categoryid);

	void delete(int categoryid) throws Exception;

	void update(Category category);

	void insert(Category category);

}
