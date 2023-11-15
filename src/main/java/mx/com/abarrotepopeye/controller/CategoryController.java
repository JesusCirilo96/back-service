package mx.com.abarrotepopeye.controller;

import mx.com.abarrotepopeye.constant.ConstantsUrl;
import mx.com.abarrotepopeye.dto.CategoryDTO;
import mx.com.abarrotepopeye.payload.MessageResponse;
import mx.com.abarrotepopeye.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ConstantsUrl.URL)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(ConstantsUrl.SAVE_CATEGORY)
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO category){

        MessageResponse response = categoryService.save(category);

        if(response.getResponse() == null){
            return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(ConstantsUrl.SAVE_CATEGORIES)
    public ResponseEntity<?> createCategories(@RequestBody List<CategoryDTO> category){

        List<MessageResponse> response = categoryService.saveCategories(category);

        if(response.isEmpty()){
            return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(ConstantsUrl.UPDATE_CATEGORY)
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO category){

        MessageResponse response = categoryService.save(category);

        if(response.getResponse() == null){
            return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(ConstantsUrl.GET_CATEGORIES)
    public ResponseEntity<?> getAllCategories() {
        MessageResponse response = categoryService.showAllCategories();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
