package mx.com.abarrotepopeye.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;
import mx.com.abarrotepopeye.dao.ProductDAO;
import mx.com.abarrotepopeye.entity.CategoryEntity;
import mx.com.abarrotepopeye.entity.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDAOImpl implements ProductDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");
    private EntityManager em;
    @Override
    public void getAllProducts() {

        List<Product> productList = new ArrayList<>();

        em = emf.createEntityManager();

        try{
            CriteriaBuilder cb = emf.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);

            Root<Product> product = query.from(Product.class);

            Join<Product, CategoryEntity> joinCategoria = product.join("categoryId", JoinType.INNER);

            Predicate statusActive = cb.equal(product.get("status"), "1");

            query.select(product).where(statusActive);
            query.orderBy(cb.asc(product.get("name")), cb.asc(joinCategoria.get("name")));

            productList = em.createQuery(query).getResultList();

            productList.forEach((productGet)->{
                System.out.println(productGet.getName() + ", " + productGet.getCategory().getName());
            });



        }catch (DataAccessException e){
            System.out.println("Error al consultar productos");
        }
    }
}
