package com.bitsandbytes.amazonproduct.mapper;

import com.bitsandbytes.amazonproduct.dto.ProductDTO;
import com.bitsandbytes.amazonproduct.entity.Category;
import com.bitsandbytes.amazonproduct.entity.Product;

public class ProductMapper {

    //entity to DTO
    public static ProductDTO toProductDTO(Product product){

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
    //DTO to entity

    public static Product toProductEntity(ProductDTO productDTO, Category category){

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

       
        product.setCategory(category);
        return  product;



    }
}
