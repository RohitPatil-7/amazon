package com.bitsandbytes.amazonproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long CategoryID; //CategoryID मध्ये प्रत्येक प्रॉडक्टसाठी त्याच्या संबंधित कॅटेगिरीची ID राहील.
}
