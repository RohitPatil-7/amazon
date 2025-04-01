package com.bitsandbytes.amazonproduct.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne//here it check class name then Products become more so @ManyToOne is here
    //By this In product table category_id column created
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
