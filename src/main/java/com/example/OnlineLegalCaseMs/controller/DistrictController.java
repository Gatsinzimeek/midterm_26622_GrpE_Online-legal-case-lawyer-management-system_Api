package com.example.OnlineLegalCaseMs.controller;

import com.example.OnlineLegalCaseMs.entity.District;
import com.example.OnlineLegalCaseMs.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    public List<District> getAllDistricts() {
        return districtService.getAllDistricts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {
        District district = districtService.getDistrictById(id);
        return district != null ? ResponseEntity.ok(district) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtService.createDistrict(district);
    }

    @PutMapping("/{id}")
    public District updateDistrict(@PathVariable Long id, @RequestBody District district) {
        return districtService.updateDistrict(id, district);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/province/{provinceId}")
    public List<District> getDistrictsByProvince(@PathVariable Long provinceId) {
        return districtService.getDistrictsByProvince(provinceId);
    }
}
