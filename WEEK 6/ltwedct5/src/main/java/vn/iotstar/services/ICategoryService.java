package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.CategoryModel;

public interface ICategoryService {
	List<CategoryModel>findALL();
	CategoryModel findById(int id);
	void insert (CategoryModel category);
	void update(CategoryModel categry);
	void delete(int id);
	List<CategoryModel> findName(String keyword);
	List<CategoryModel> findAll();

}
