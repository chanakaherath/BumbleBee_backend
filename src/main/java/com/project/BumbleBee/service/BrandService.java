package com.project.BumbleBee.service;

import com.project.BumbleBee.dto.request.BrandSaveRequest;
import com.project.BumbleBee.dto.request.BrandUpdateRequest;
import com.project.BumbleBee.dto.response.BrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    BrandResponse save(BrandSaveRequest saveRequest);

    BrandResponse getById(String id);

    List<BrandResponse> getAllActive();

    List<BrandResponse> getAll();

    BrandResponse update(BrandUpdateRequest updateRequest);

    BrandResponse delete(String id);

}
