package mx.com.abarrotepopeye.repository;

import mx.com.abarrotepopeye.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}
