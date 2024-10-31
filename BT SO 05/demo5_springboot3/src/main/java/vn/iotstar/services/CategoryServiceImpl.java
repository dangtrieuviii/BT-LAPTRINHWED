package vn.iotstar.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	static
	CategoryRepository categoryRepository;

	@Override
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return categoryRepository.findOne(example);
	}

	public List<Category> findAllById(Iterable<Long> ids) {
		return categoryRepository.findAllById(ids);
	}

	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categoryRepository.findAll(example, pageable);
	}

	public <S extends Category> long count(Example<S> example) {
		return categoryRepository.count(example);
	}

	public Category getById(Long id) {
		return categoryRepository.getById(id);
	}

	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	public void deleteAllById(Iterable<? extends Long> ids) {
		categoryRepository.deleteAllById(ids);
	}

	public <S extends Category> List<S> findAll(Example<S> example) {
		return categoryRepository.findAll(example);
	}

	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return categoryRepository.findAll(example, sort);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public <S extends Category> S save(vn.iotstar.entity.Category entity) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
