package com.project.BumbleBee.repository;

import com.project.BumbleBee.entity.Category;
import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findByStatusAndIsDeleted(Status status, Deleted isDeleted);

}
