package com.project.BumbleBee.repository;

import com.project.BumbleBee.entity.Product;
import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByStatusAndIsDeleted(Status status, Deleted isDeleted);

    List<Product> findByBrandId(String brandId);

    List<Product> findByCategoryId(String categoryId);

}
