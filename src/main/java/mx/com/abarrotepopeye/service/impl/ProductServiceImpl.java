package mx.com.abarrotepopeye.service.impl;

import mx.com.abarrotepopeye.dao.ProductDAO;
import mx.com.abarrotepopeye.repository.ProductRepository;
import mx.com.abarrotepopeye.dto.ProductDTO;
import mx.com.abarrotepopeye.entity.ProductEntity;
import mx.com.abarrotepopeye.payload.MessageResponse;
import mx.com.abarrotepopeye.service.ProductService;
import mx.com.abarrotepopeye.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Override
    public MessageResponse save(ProductDTO product) {

        MessageResponse response = null;

        try{

            if(product.getPrice() != null){
                BigDecimal price = product.getPrice().divide(new BigDecimal("100"));
                product.setPrice(price);
            }

            ProductEntity productEntity = null;

            if(product.getProductId() == null){
                //Si el id de producto es null se genera nuevo registro
                productEntity = ProductEntity.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .price(product.getPrice().toString())
                        .barCode(product.getBarCode())
                        .status(product.getStatus())
                        .category(product.getCategory())
                        .createDate(Utils.fechaHoraActual())
                        .updateDate(Utils.fechaHoraActual())
                        .build();
            }else{
                //Si el id de producto no es null se actualiza registro
                productEntity = ProductEntity.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .price(product.getPrice().toString())
                        .barCode(product.getBarCode())
                        .status(product.getStatus())
                        .category(product.getCategory())
                        .createDate(product.getCreateDate())
                        .updateDate(product.getUpdateDate())
                        .build();
            }



            productRepository.save(productEntity);

            response = MessageResponse.builder()
                    .error("OKAY")
                    .codeError("PROD0000")
                    .description("Transaccion procesada exitosamente")
                    .moreInfo("Transaccion procesada exitosamente")
                    .response(ProductDTO.builder()
                            .productId(productEntity.getProductId())
                            .name(productEntity.getName())
                            .price(new BigDecimal(productEntity.getPrice()).multiply(new BigDecimal(100)))
                            .barCode(productEntity.getBarCode())
                            .status(productEntity.getStatus())
                            .category(productEntity.getCategory())
                            .createDate(productEntity.getCreateDate())
                            .updateDate(productEntity.getUpdateDate())
                            .build())
                    .build();
        }catch (DataAccessException de){
            System.out.println("Error al guardar producto");

            response = MessageResponse.builder()
                    .error("CANCEL")
                    .codeError("PROD0001")
                    .description("Error al registrar producto")
                    .moreInfo(de.getMessage())
                    .response(null)
                    .build();
        }

        return response;
    }

    @Transactional
    @Override
    public List<MessageResponse> saveProducts(List<ProductDTO> products) {

        List<MessageResponse> responseList = new ArrayList<>();

        for(ProductDTO product: products){

            MessageResponse response = null;

            try{

                if(product.getPrice() != null){
                    BigDecimal price = product.getPrice().divide(new BigDecimal("100"));
                    product.setPrice(price);
                }

                ProductEntity productEntity = ProductEntity.builder()
                        .productId(product.getProductId())
                        .name(product.getName())
                        .price(product.getPrice().toString())
                        .barCode(product.getBarCode())
                        .status(product.getStatus())
                        .category(product.getCategory())
                        .createDate(Utils.fechaHoraActual())
                        .updateDate(Utils.fechaHoraActual())
                        .build();

                productRepository.save(productEntity);

                response = MessageResponse.builder()
                        .error("OKAY")
                        .codeError("PROD0000")
                        .description("Transaccion procesada exitosamente")
                        .moreInfo("Transaccion procesada exitosamente")
                        .response(ProductDTO.builder()
                                .productId(productEntity.getProductId())
                                .name(productEntity.getName())
                                .price(new BigDecimal(productEntity.getPrice()).multiply(new BigDecimal(100)))
                                .barCode(productEntity.getBarCode())
                                .status(productEntity.getStatus())
                                .category(productEntity.getCategory())
                                .createDate(productEntity.getCreateDate())
                                .updateDate(productEntity.getUpdateDate())
                                .build())
                        .build();
            }catch (DataAccessException de){
                System.out.println("Error al guardar producto");

                response = MessageResponse.builder()
                        .error("CANCEL")
                        .codeError("PROD0001")
                        .description("Error al registar producto")
                        .moreInfo(de.getMessage())
                        .response(null)
                        .build();
            }

            responseList.add(response);
        }

        return responseList;
    }

    @Transactional(readOnly = true)
    @Override
    public ProductEntity findById(UUID productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public MessageResponse showAllProduct() {
        List<ProductEntity> listProducts = (List<ProductEntity>) productRepository.findAll();
        MessageResponse response = null;

        if(!listProducts.isEmpty()){
            response = MessageResponse.builder()
                    .error("OKAY")
                    .codeError("PROD0000")
                    .description("Transaccion procesada correctamente")
                    .moreInfo("Transaccion procesada correctamente")
                    .response(listProducts)
                    .build();
        }else{
            response = MessageResponse.builder()
                    .error("CANCEL")
                    .codeError("PROD0001")
                    .description("No se encontraron registros")
                    .moreInfo("No se encontraron registros")
                    .response(null)
                    .build();
        }

        productDAO.getAllProducts();

        return response;
    }


}
