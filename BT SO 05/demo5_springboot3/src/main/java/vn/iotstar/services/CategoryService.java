package vn.iotstar.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import vn.iotstar.repository.CategoryRepository;

public interface CategoryService {

	void deleteById(Long id);

	long count();

	Optional<Category> findById(Long id);

	static List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll(Sort sort);

	<S extends Category> S save(vn.iotstar.entity.Category entity);

	void setCategoryRepository(CategoryRepository categoryRepository);

	CategoryRepository getCategoryRepository();

	<S extends Category> S save(S entity);

}
