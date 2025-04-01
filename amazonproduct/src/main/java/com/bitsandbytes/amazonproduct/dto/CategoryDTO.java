package com.bitsandbytes.amazonproduct.dto;

import com.bitsandbytes.amazonproduct.entity.Product;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;

    private List<ProductDTO> products;
}
