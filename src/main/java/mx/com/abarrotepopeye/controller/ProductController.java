package mx.com.abarrotepopeye.controller;

import mx.com.abarrotepopeye.constant.ConstantsUrl;
import mx.com.abarrotepopeye.dto.ProductDTO;
import mx.com.abarrotepopeye.entity.ProductEntity;
import mx.com.abarrotepopeye.payload.MessageResponse;
import mx.com.abarrotepopeye.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ConstantsUrl.URL)
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(ConstantsUrl.SAVE_PRODUCT)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO product){

        MessageResponse response = productService.save(product);

        if(response.getResponse() == null){
            return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(ConstantsUrl.SAVE_PRODUCTS)
    public ResponseEntity<?> createProducts(@RequestBody List<ProductDTO> product){

        List<MessageResponse> response = productService.saveProducts(product);

        if(response.isEmpty()){
            return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(ConstantsUrl.UPDATE_PRODUCT)
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO product){

        MessageResponse response = productService.save(product);

        if(response.getResponse() == null){
            return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(ConstantsUrl.GET_PRODUCT)
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity findById(UUID productID){
        return productService.findById(productID);
    }

    @GetMapping(ConstantsUrl.GET_PRODUCTS)
    public ResponseEntity<?> getAllProducts() {
        MessageResponse response = productService.showAllProduct();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
