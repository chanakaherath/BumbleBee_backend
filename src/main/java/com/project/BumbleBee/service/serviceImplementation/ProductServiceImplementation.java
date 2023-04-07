package com.project.BumbleBee.service.serviceImplementation;

import com.project.BumbleBee.dto.request.ProductSaveRequest;
import com.project.BumbleBee.dto.request.ProductUpdateRequest;
import com.project.BumbleBee.dto.response.BrandResponse;
import com.project.BumbleBee.dto.response.CategoryResponse;
import com.project.BumbleBee.dto.response.ProductResponse;
import com.project.BumbleBee.entity.Brand;
import com.project.BumbleBee.entity.Category;
import com.project.BumbleBee.entity.Product;
import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;
import com.project.BumbleBee.repository.BrandRepository;
import com.project.BumbleBee.repository.CategoryRepository;
import com.project.BumbleBee.repository.ProductRepository;
import com.project.BumbleBee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductResponse save(ProductSaveRequest saveRequest) {

        try {

            Product product = new Product();

            product.setName(saveRequest.getName());
            product.setCode(saveRequest.getCode());
            product.setDescription(saveRequest.getDescription());
            product.setPrice(Double.parseDouble(saveRequest.getPrice()));
            product.setStatus(Status.ACTIVE);
            product.setIsDeleted(Deleted.NO);
            product.setBrand(brandRepository.getById(saveRequest.getBrandId()));
            product.setCategory(categoryRepository.getById(saveRequest.getCategoryId()));

            Product saveResponse = productRepository.save(product);

            return getResponse(saveResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public ProductResponse getById(String id) {

        try {

            return productRepository.findById(id).map(ProductServiceImplementation::getResponse).orElse(null);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<ProductResponse> getByBrandId(String brandId) {

        try {

            return productRepository.findByBrandId(brandId).stream().map(ProductServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<ProductResponse> getByCategoryId(String categoryId) {

        try {

            return productRepository.findByCategoryId(categoryId).stream().map(ProductServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<ProductResponse> getAllActive() {

        try {

            return productRepository.findByStatusAndIsDeleted(Status.ACTIVE, Deleted.NO).stream().map(ProductServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<ProductResponse> getAll() {

        try {

            return productRepository.findAll().stream().map(ProductServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public ProductResponse update(ProductUpdateRequest updateRequest) {

        try {

            Product updateResponse = new Product();

            Product product = productRepository.getById(updateRequest.getId());

            if (product != null) {

                product.setName(updateRequest.getName());
                product.setCode(updateRequest.getCode());
                product.setDescription(updateRequest.getDescription());
                product.setPrice(Double.parseDouble(updateRequest.getPrice()));
                product.setStatus(Status.ACTIVE);
                product.setIsDeleted(Deleted.NO);
                product.setBrand(brandRepository.getById(updateRequest.getBrandId()));
                product.setCategory(categoryRepository.getById(updateRequest.getCategoryId()));

                updateResponse = productRepository.save(product);

            } else {

                return null;

            }

            return getResponse(updateResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public ProductResponse delete(String id) {

        try {

            Product deleteResponse = new Product();

            Product product = productRepository.getById(id);

            if (product != null) {

                product.setStatus(Status.INACTIVE);
                product.setIsDeleted(Deleted.YES);

                deleteResponse = productRepository.save(product);

            } else {

                return null;

            }

            return getResponse(deleteResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }



    private static ProductResponse getResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setCode(product.getCode());
        response.setDescription(product.getDescription());
        response.setPrice(String.valueOf(product.getPrice()));
        response.setStatus(product.getStatus());
        response.setIsDeleted(product.getIsDeleted());
        response.setBrand(convertToBrandResponse(product.getBrand()));
        response.setCategory(convertToCategoryResponse(product.getCategory()));

        return response;

    }

    private static BrandResponse convertToBrandResponse(Brand brand) {

        BrandResponse brandResponse = new BrandResponse();

        brandResponse.setId(brand.getId());
        brandResponse.setName(brand.getName());
        brandResponse.setDescription(brand.getDescription());
        brandResponse.setStatus(brand.getStatus());
        brandResponse.setIsDeleted(brand.getIsDeleted());

        return brandResponse;

    }

    private static CategoryResponse convertToCategoryResponse(Category category) {

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setCode(category.getCode());
        categoryResponse.setStatus(category.getStatus());
        categoryResponse.setIsDeleted(category.getIsDeleted());

        return categoryResponse;

    }

}
