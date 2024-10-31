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

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll(Sort sort);

	<S extends Category> S save(S entity);

	void setCategoryRepository(CategoryRepository categoryRepository);

	CategoryRepository getCategoryRepository();

}
