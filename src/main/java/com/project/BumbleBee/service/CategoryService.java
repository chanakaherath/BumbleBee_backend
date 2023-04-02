package com.project.BumbleBee.service;

import com.project.BumbleBee.dto.request.CategorySaveRequest;
import com.project.BumbleBee.dto.request.CategoryUpdateRequest;
import com.project.BumbleBee.dto.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryResponse save(CategorySaveRequest saveRequest);

    CategoryResponse getById(String id);

    List<CategoryResponse> getAllActive();

    List<CategoryResponse> getAll();

    CategoryResponse update(CategoryUpdateRequest updateRequest);

    CategoryResponse delete(String id);

}
