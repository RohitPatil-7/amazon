package com.bitsandbytes.amazonproduct.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//     – एका कॅटेगिरीला अनेक प्रॉडक्ट्स असतात. जर कॅटेगिरी डिलीट केली, तर संबंधित प्रॉडक्ट्सही डिलीट होतील.
//   cascade=CascadeType.All :-Means if from category any item delete then from Product it also delete
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List <Product> products = new ArrayList<>();


}
