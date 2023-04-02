package com.project.BumbleBee.service;

import com.project.BumbleBee.dto.request.ProductSaveRequest;
import com.project.BumbleBee.dto.request.ProductUpdateRequest;
import com.project.BumbleBee.dto.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    ProductResponse save(ProductSaveRequest saveRequest);

    ProductResponse getById(String id);

    List<ProductResponse> getByBrandId(String brandId);

    List<ProductResponse> getByCategoryId(String categoryId);

    List<ProductResponse> getAllActive();

    List<ProductResponse> getAll();

    ProductResponse update(ProductUpdateRequest updateRequest);

    ProductResponse delete(String id);

}
