package com.bitsandbytes.amazonproduct.service;

import com.bitsandbytes.amazonproduct.dto.CategoryDTO;
import com.bitsandbytes.amazonproduct.entity.Category;
import com.bitsandbytes.amazonproduct.mapper.CategoryMapper;
import com.bitsandbytes.amazonproduct.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {


    private CategoryRepository categoryRepository;


    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
       Category category= CategoryMapper.toCategoryEntity(categoryDTO);
      category=  categoryRepository.save(category);
      return CategoryMapper.toCategoryDTO(category);
    }
    //get all category
    //get category by id
    //delete category
}
