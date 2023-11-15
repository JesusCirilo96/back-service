package mx.com.abarrotepopeye.repository;

import mx.com.abarrotepopeye.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID> {

}
