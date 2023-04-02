package com.project.BumbleBee.repository;

import com.project.BumbleBee.entity.Brand;
import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {

    List<Brand> findByStatusAndIsDeleted(Status status, Deleted isDeleted);

}