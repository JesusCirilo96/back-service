package mx.com.abarrotepopeye.service.impl;

import mx.com.abarrotepopeye.repository.CategoryRepository;
import mx.com.abarrotepopeye.dto.CategoryDTO;
import mx.com.abarrotepopeye.entity.CategoryEntity;
import mx.com.abarrotepopeye.payload.MessageResponse;
import mx.com.abarrotepopeye.service.CategoryService;
import mx.com.abarrotepopeye.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    @Override
    public MessageResponse save(CategoryDTO category) {
        MessageResponse response = null;

        try{

            CategoryEntity categoryEntity = null;

            if(category.getCategoryId() == null){
                //Si el id de producto es null se genera nuevo registro
                categoryEntity = CategoryEntity.builder()
                        .categoryId(category.getCategoryId())
                        .name(category.getName())
                        .status(category.getStatus())
                        .createDate(Utils.fechaHoraActual())
                        .updateDate(Utils.fechaHoraActual())
                        .build();
            }else{
                //Si el id de producto no es null se actualiza registro
                categoryEntity = CategoryEntity.builder()
                        .categoryId(category.getCategoryId())
                        .name(category.getName())
                        .status(category.getStatus())
                        .createDate(category.getCreateDate())
                        .updateDate(category.getUpdateDate())
                        .build();
            }

            categoryRepository.save(categoryEntity);

            response = MessageResponse.builder()
                    .error("OKAY")
                    .codeError("CATE0000")
                    .description("Transaccion procesada exitosamente")
                    .moreInfo("Transaccion procesada exitosamente")
                    .response(CategoryDTO.builder()
                            .categoryId(categoryEntity.getCategoryId())
                            .name(categoryEntity.getName())
                            .status(categoryEntity.getStatus())
                            .createDate(categoryEntity.getCreateDate())
                            .updateDate(categoryEntity.getUpdateDate())
                            .build())
                    .build();
        }catch (DataAccessException de){
            System.out.println("Error al guardar la categoria");

            response = MessageResponse.builder()
                    .error("CANCEL")
                    .codeError("CATE0001")
                    .description("Error al registrar la categoria")
                    .moreInfo(de.getMessage())
                    .response(null)
                    .build();
        }

        return response;
    }

    @Transactional
    @Override
    public List<MessageResponse> saveCategories(List<CategoryDTO> categories) {

        List<MessageResponse> responseList = new ArrayList<>();

        for(CategoryDTO category: categories){

            MessageResponse response = null;

            try{

                CategoryEntity categoryEntity = CategoryEntity.builder()
                        .categoryId(category.getCategoryId())
                        .name(category.getName())
                        .status(category.getStatus())
                        .createDate(Utils.fechaHoraActual())
                        .updateDate(Utils.fechaHoraActual())
                        .build();

                categoryRepository.save(categoryEntity);

                response = MessageResponse.builder()
                        .error("OKAY")
                        .codeError("CATE0000")
                        .description("Transaccion procesada exitosamente")
                        .moreInfo("Transaccion procesada exitosamente")
                        .response(CategoryDTO.builder()
                                .categoryId(categoryEntity.getCategoryId())
                                .name(categoryEntity.getName())
                                .status(categoryEntity.getStatus())
                                .createDate(categoryEntity.getCreateDate())
                                .updateDate(categoryEntity.getUpdateDate())
                                .build()
                        ).build();

            }catch (DataAccessException de){
                System.out.println("Error al guardar categoria");

                response = MessageResponse.builder()
                        .error("CANCEL")
                        .codeError("CATE0001")
                        .description("Error al registrar categoria")
                        .moreInfo(de.getMessage())
                        .response(null)
                        .build();
            }

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    public MessageResponse findById(Integer categoryId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public MessageResponse showAllCategories() {
        List<CategoryEntity> categoriesList = (List<CategoryEntity>) categoryRepository.findAll();
        MessageResponse response = null;

        if(!categoriesList.isEmpty()){
            response = MessageResponse.builder()
                    .error("OKAY")
                    .codeError("CATE0000")
                    .description("Transaccion procesada correctamente")
                    .moreInfo("Transaccion procesada correctamente")
                    .response(categoriesList)
                    .build();
        }else{
            response = MessageResponse.builder()
                    .error("CANCEL")
                    .codeError("CATE0001")
                    .description("No se encontraron registros")
                    .moreInfo("No se encontraron registros")
                    .response(null)
                    .build();
        }

        return response;
    }
}
