package com.bitsandbytes.amazonproduct.repository;

import com.bitsandbytes.amazonproduct.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
