package com.bitsandbytes.amazonproduct.mapper;

import com.bitsandbytes.amazonproduct.dto.CategoryDTO;
import com.bitsandbytes.amazonproduct.entity.Category;

//✅ CategoryMapper हा DTO आणि Entity यांच्यातील डेटा कन्व्हर्जन करतो.
//✅ DTO वापरल्यामुळे डेटाचा स्ट्रक्चर वेगळा राहतो आणि API ला योग्य प्रकारे डेटा मिळतो.
//✅ Java Streams आणि Mapping चा योग्य वापर करून कोड Clean आणि Maintainable ठेवला आहे.
public class CategoryMapper {

// ✅ हे एक static method आहे जे Category entity घेतो आणि त्याला CategoryDTO मध्ये बदलतो.
    public static CategoryDTO toCategoryDTO(Category category){

//        ✅ category null असल्यास, method लगेच null परत करते. याचा अर्थ, जर आपल्याकडे डेटा नसेल,
//        तर खालील कोणतेही प्रक्रिया केली जाणार नाही.
        if(category == null){
            return null;
        }

//        ✅ CategoryDTO चे नवीन ऑब्जेक्ट तयार करतो. यामध्ये आपल्याला Category entity चा डेटा ठेवायचा आहे.
        CategoryDTO categoryDTO = new CategoryDTO();

//        ✅ Category entity मधून id आणि name चे मूल्य CategoryDTO मध्ये सेट करतो.
//        यामुळे CategoryDTO मध्ये id आणि name मिळतात.
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

//  ✅ category.getProducts() हा List<Product> परत करतो. त्याला Stream मध्ये बदलतो आणि
//  ProductMapper::toProductDTO च्या मदतीने प्रत्येक Product ला ProductDTO मध्ये कन्व्हर्ट करतो.
//✅ toList() वापरून सर्व ProductDTO चा एक List तयार करतो आणि categoryDTO.setProducts() मध्ये सेट करतो.
        categoryDTO.setProducts(category.getProducts().stream()
                .map(ProductMapper::toProductDTO).toList());

//        ✅ कन्व्हर्ट केलेले CategoryDTO परत करतो. यामध्ये सर्व Category entity चा डेटा असेल.
        return categoryDTO;
    }


//    ✅ toCategoryEntity हा static method आहे. यामध्ये CategoryDTO पासून Category entity तयार केली जाते.
    public static Category toCategoryEntity(CategoryDTO categoryDTO){

//        ✅ Category entity चे नवीन ऑब्जेक्ट तयार करतो. यामध्ये आपल्याला CategoryDTO डेटा सेट करायचा आहे.
        Category category = new Category();

//         ✅ CategoryDTO मधून name घेतो आणि Category entity मध्ये सेट करतो. (मात्र, इथे id सेट होत नाही,
//         कारण Category entity मध्ये id स्वतःच auto-generated असतो.)
        category.setName(categoryDTO.getName());

//        ✅ Category entity परत करतो, ज्यामध्ये name सेट केलेले असते.
        return category;
    }
}
