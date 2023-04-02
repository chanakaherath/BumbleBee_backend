package com.project.BumbleBee.controller;

import com.project.BumbleBee.dto.request.CategorySaveRequest;
import com.project.BumbleBee.dto.request.CategoryUpdateRequest;
import com.project.BumbleBee.dto.response.CategoryResponse;
import com.project.BumbleBee.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("save")
    public ResponseEntity<CategoryResponse> save(@RequestBody CategorySaveRequest saveRequest) {

        CategoryResponse saveResponse = categoryService.save(saveRequest);

        return ResponseEntity.ok(saveResponse);

    }

    @GetMapping("getById/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable("id") String id) {

        CategoryResponse getByIdResponse = categoryService.getById(id);

        if (getByIdResponse == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getByIdResponse);

    }

    @GetMapping("getAllActive")
    public ResponseEntity<List<CategoryResponse>> getAllActive() {

        List<CategoryResponse> getAllActiveResponse = categoryService.getAllActive();

        if (getAllActiveResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllActiveResponse);

    }

    @GetMapping("getAll")
    public ResponseEntity<List<CategoryResponse>> getAll() {

        List<CategoryResponse> getAllResponse = categoryService.getAll();

        if (getAllResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllResponse);

    }

    @PutMapping("update")
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryUpdateRequest updateRequest) {

        CategoryResponse updateResponse = categoryService.update(updateRequest);

        return ResponseEntity.ok(updateResponse);

    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable String id) {

        CategoryResponse deleteResponse = categoryService.delete(id);

        return ResponseEntity.ok(deleteResponse);

    }
}
