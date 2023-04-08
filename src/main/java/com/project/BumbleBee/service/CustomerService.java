package com.project.BumbleBee.service;

import com.project.BumbleBee.dto.request.CustomerSaveRequest;
import com.project.BumbleBee.dto.response.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    CustomerResponse save(CustomerSaveRequest saveRequest);

    List<CustomerResponse> getAll();

}
