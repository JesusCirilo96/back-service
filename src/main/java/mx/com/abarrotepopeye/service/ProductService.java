package mx.com.abarrotepopeye.service;


import mx.com.abarrotepopeye.dto.ProductDTO;
import mx.com.abarrotepopeye.entity.ProductEntity;
import mx.com.abarrotepopeye.payload.MessageResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    /**
     * Save the product
     * @param product DTO product
     * @return The product
     */
    MessageResponse save(ProductDTO product);

    /**
     * Save multiple products
     * @param products List of products
     * @return
     */
    List<MessageResponse> saveProducts(List<ProductDTO> products);

    ProductEntity findById(UUID productId);

    /**
     * Get all products
     * @return List with all products
     */
    MessageResponse showAllProduct();
}
