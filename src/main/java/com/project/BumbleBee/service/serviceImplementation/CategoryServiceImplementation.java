package com.project.BumbleBee.service.serviceImplementation;

import com.project.BumbleBee.dto.request.CategorySaveRequest;
import com.project.BumbleBee.dto.request.CategoryUpdateRequest;
import com.project.BumbleBee.dto.response.CategoryResponse;
import com.project.BumbleBee.entity.Category;
import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;
import com.project.BumbleBee.repository.CategoryRepository;
import com.project.BumbleBee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponse save(CategorySaveRequest saveRequest) {

        try {

            Category category = new Category();

            category.setName(saveRequest.getName());
            category.setCode(saveRequest.getCode());
            category.setStatus(Status.ACTIVE);
            category.setIsDeleted(Deleted.NO);

            Category saveResponse = categoryRepository.save(category);

            return getResponse(saveResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public CategoryResponse getById(String id) {

        try {

            return categoryRepository.findById(id).map(CategoryServiceImplementation::getResponse).orElse(null);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<CategoryResponse> getAllActive() {

        try {

            return categoryRepository.findByStatusAndIsDeleted(Status.ACTIVE, Deleted.NO).stream().map(CategoryServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<CategoryResponse> getAll() {

        try {

            return categoryRepository.findAll().stream().map(CategoryServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public CategoryResponse update(CategoryUpdateRequest updateRequest) {

        try {

            Category updateResponse = new Category();

            Category category = categoryRepository.getById(updateRequest.getId());

            if (category != null) {

                category.setName(updateRequest.getName());
                category.setCode(updateRequest.getCode());
                category.setStatus(updateRequest.getStatus());
                category.setIsDeleted(Deleted.NO);

                updateResponse = categoryRepository.save(category);

            } else {

                return null;

            }

            return getResponse(updateResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public CategoryResponse delete(String id) {

        try {

            Category deleteResponse = new Category();

            Category category = categoryRepository.getById(id);

            if (category != null) {

                category.setStatus(Status.INACTIVE);
                category.setIsDeleted(Deleted.YES);

                deleteResponse = categoryRepository.save(category);

            } else {

                return null;

            }

            return getResponse(deleteResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }



    private static CategoryResponse getResponse(Category category) {

        CategoryResponse response = new CategoryResponse();

        response.setId(category.getId());
        response.setName(category.getName());
        response.setCode(category.getCode());
        response.setStatus(category.getStatus());
        response.setIsDeleted(category.getIsDeleted());

        return response;

    }
}
