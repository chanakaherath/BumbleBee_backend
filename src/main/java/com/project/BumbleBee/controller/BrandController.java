package com.project.BumbleBee.controller;

import com.project.BumbleBee.dto.request.BrandSaveRequest;
import com.project.BumbleBee.dto.request.BrandUpdateRequest;
import com.project.BumbleBee.dto.response.BrandResponse;
import com.project.BumbleBee.service.BrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
@Api(tags = "Brand Controller")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("save")
    public ResponseEntity<BrandResponse> save(@RequestBody BrandSaveRequest saveRequest) {

        BrandResponse saveResponse = brandService.save(saveRequest);

        return ResponseEntity.ok(saveResponse);

    }

    @GetMapping("getById/{id}")
    public ResponseEntity<BrandResponse> getById(@PathVariable("id") String id) {

        BrandResponse getByIdResponse = brandService.getById(id);

        if (getByIdResponse == null) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getByIdResponse);

    }

    @GetMapping("getAllActive")
    public ResponseEntity<List<BrandResponse>> getAllActive() {

        List<BrandResponse> getAllActiveResponse = brandService.getAllActive();

        if (getAllActiveResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllActiveResponse);

    }

    @GetMapping("getAll")
    public ResponseEntity<List<BrandResponse>> getAll() {

        List<BrandResponse> getAllResponse = brandService.getAll();

        if (getAllResponse.isEmpty()) {

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(getAllResponse);

    }

    @PutMapping("update")
    public ResponseEntity<BrandResponse> update(@RequestBody BrandUpdateRequest updateRequest) {

        BrandResponse updateResponse = brandService.update(updateRequest);

        return ResponseEntity.ok(updateResponse);

    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<BrandResponse> delete(@PathVariable String id) {

        BrandResponse deleteResponse = brandService.delete(id);

        return ResponseEntity.ok(deleteResponse);

    }

}
