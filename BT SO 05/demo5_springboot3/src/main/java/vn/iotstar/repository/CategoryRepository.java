package vn.iotstar.repository;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Tìm kiếm theo nội dung tên
    List<Category> findByNameContaining(String name);

    // Tìm kiếm và phân trang
    Page<Category> findByNameContaining(String name, Pageable pageable);
}