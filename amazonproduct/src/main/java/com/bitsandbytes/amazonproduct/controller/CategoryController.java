package com.bitsandbytes.amazonproduct.controller;

import com.bitsandbytes.amazonproduct.dto.CategoryDTO;
import com.bitsandbytes.amazonproduct.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    //getProduct
    //createProduct
    @PostMapping
    public ResponseEntity <CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>( categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //updateProduct
    //get product by id
    //delete product
}
