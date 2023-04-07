package com.project.BumbleBee.controller;

import com.project.BumbleBee.dto.request.ProductSaveRequest;
import com.project.BumbleBee.dto.request.ProductUpdateRequest;
import com.project.BumbleBee.dto.response.ProductResponse;
import com.project.BumbleBee.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@Api(tags = "Product Controller")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("save")
    public ResponseEntity<ProductResponse> save(@RequestBody ProductSaveRequest saveRequest) {

        ProductResponse saveResponse = productService.save(saveRequest);

        return ResponseEntity.ok(saveResponse);

    }

    @GetMapping("getById/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable("id") String id) {

        ProductResponse getByIdResponse = productService.getById(id);

        if (getByIdResponse == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getByIdResponse);

    }

    @GetMapping("getByBrandId/{brandId}")
    public ResponseEntity<List<ProductResponse>> getByBrandId(@PathVariable("brandId") String brandId) {

        List<ProductResponse> getByBrandIdResponse = productService.getByBrandId(brandId);

        if (getByBrandIdResponse == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getByBrandIdResponse);

    }

    @GetMapping("getByCategoryId/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getByCategoryId(@PathVariable("categoryId") String categoryId) {

        List<ProductResponse> getByCategoryIdResponse = productService.getByCategoryId(categoryId);

        if (getByCategoryIdResponse == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getByCategoryIdResponse);

    }

    @GetMapping("getAllActive")
    public ResponseEntity<List<ProductResponse>> getAllActive() {

        List<ProductResponse> getAllActiveResponse = productService.getAllActive();

        if (getAllActiveResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllActiveResponse);

    }

    @GetMapping("getAll")
    public ResponseEntity<List<ProductResponse>> getAll() {

        List<ProductResponse> getAllResponse = productService.getAll();

        if (getAllResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllResponse);

    }

    @PutMapping("update")
    public ResponseEntity<ProductResponse> update(@RequestBody ProductUpdateRequest updateRequest) {

        ProductResponse updateResponse = productService.update(updateRequest);

        return ResponseEntity.ok(updateResponse);

    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable String id) {

        ProductResponse deleteResponse = productService.delete(id);

        return ResponseEntity.ok(deleteResponse);

    }

}
