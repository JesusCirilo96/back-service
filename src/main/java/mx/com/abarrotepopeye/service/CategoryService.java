package mx.com.abarrotepopeye.service;

import mx.com.abarrotepopeye.dto.CategoryDTO;
import mx.com.abarrotepopeye.entity.ProductEntity;
import mx.com.abarrotepopeye.payload.MessageResponse;

import java.util.List;

public interface CategoryService {
    /**
     * Save the category
     * @param category DTO product
     * @return The product
     */
    MessageResponse save(CategoryDTO category);

    /**
     * Save multiple categories
     * @param categories List of categories
     * @return
     */
    List<MessageResponse> saveCategories(List<CategoryDTO> categories);

    /**
     * Find category by ID
     * @param categoryId categoryId
     * @return The category
     */
    MessageResponse findById(Integer categoryId);

    /**
     * Get all categories
     * @return List with all categories
     */
    MessageResponse showAllCategories();
}
