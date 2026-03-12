package com.example.OnlineLegalCaseMs.controller;

import com.example.OnlineLegalCaseMs.entity.Province;
import com.example.OnlineLegalCaseMs.service.ProvinceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    public List<Province> getAllProvinces() {
        return provinceService.getAllProvinces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> getProvinceById(@PathVariable Long id) {
        Province province = provinceService.getProvinceById(id);
        return province != null ? ResponseEntity.ok(province) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Province createProvince(@RequestBody Province province) {
        return provinceService.createProvince(province);
    }

    @PutMapping("/{id}")
    public Province updateProvince(@PathVariable Long id, @RequestBody Province province) {
        return provinceService.updateProvince(id, province);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvince(@PathVariable Long id) {
        provinceService.deleteProvince(id);
        return ResponseEntity.noContent().build();
    }
}
