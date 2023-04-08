package com.project.BumbleBee.controller;

import com.project.BumbleBee.dto.request.CustomerSaveRequest;
import com.project.BumbleBee.dto.response.CustomerResponse;
import com.project.BumbleBee.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@Api(tags = "Customer Controller")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public ResponseEntity<CustomerResponse> save(@RequestBody CustomerSaveRequest saveRequest) {

        CustomerResponse saveResponse = customerService.save(saveRequest);

        return ResponseEntity.ok(saveResponse);

    }

    @GetMapping("getAll")
    public ResponseEntity<List<CustomerResponse>> getAll() {

        List<CustomerResponse> getAllResponse = customerService.getAll();

        if (getAllResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllResponse);

    }
}
