package com.project.BumbleBee.service.serviceImplementation;

import com.project.BumbleBee.dto.request.BrandSaveRequest;
import com.project.BumbleBee.dto.request.BrandUpdateRequest;
import com.project.BumbleBee.dto.response.BrandResponse;
import com.project.BumbleBee.entity.Brand;
import com.project.BumbleBee.enums.Deleted;
import com.project.BumbleBee.enums.Status;
import com.project.BumbleBee.repository.BrandRepository;
import com.project.BumbleBee.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImplementation implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public BrandResponse save(BrandSaveRequest saveRequest) {

        try {

            Brand brand = new Brand();

            brand.setName(saveRequest.getName());
            brand.setDescription(saveRequest.getDescription());
            brand.setStatus(Status.ACTIVE);
            brand.setIsDeleted(Deleted.NO);

            Brand saveResponse = brandRepository.save(brand);

            return getResponse(saveResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    @Override
    public BrandResponse getById(String id) {

        try {

            return brandRepository.findById(id).map(BrandServiceImplementation::getResponse).orElse(null);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<BrandResponse> getAllActive() {

        try {

            return brandRepository.findByStatusAndIsDeleted(Status.ACTIVE, Deleted.NO).stream().map(BrandServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public List<BrandResponse> getAll() {

        try {

            return brandRepository.findAll().stream().map(BrandServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public BrandResponse update(BrandUpdateRequest updateRequest) {

        try {

            Brand updateResponse = new Brand();

            Brand brand = brandRepository.getById(updateRequest.getId());

            if (brand != null) {

                brand.setName(updateRequest.getName());
                brand.setDescription(updateRequest.getDescription());
                brand.setStatus(updateRequest.getStatus());
                brand.setIsDeleted(Deleted.NO);

                updateResponse = brandRepository.save(brand);

            } else {

                return null;

            }

            return getResponse(updateResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @Override
    public BrandResponse delete(String id) {

        try {

            Brand deleteResponse = new Brand();

            Brand brand = brandRepository.getById(id);

            if (brand != null) {

                brand.setStatus(Status.INACTIVE);
                brand.setIsDeleted(Deleted.YES);

                deleteResponse = brandRepository.save(brand);

            } else {

                return null;

            }

            return getResponse(deleteResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }



    private static BrandResponse getResponse(Brand brand) {

        BrandResponse response = new BrandResponse();

        response.setId(brand.getId());
        response.setName(brand.getName());
        response.setDescription(brand.getDescription());
        response.setStatus(brand.getStatus());
        response.setIsDeleted(brand.getIsDeleted());

        return response;

    }

}
