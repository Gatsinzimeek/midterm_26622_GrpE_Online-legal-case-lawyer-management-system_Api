package com.example.OnlineLegalCaseMs.service;

import com.example.OnlineLegalCaseMs.entity.Province;
import com.example.OnlineLegalCaseMs.repository.ProvinceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    public Province getProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    public Province createProvince(Province province) {
        return provinceRepository.save(province);
    }

    public Province updateProvince(Long id, Province province) {
        province.setId(id);
        return provinceRepository.save(province);
    }

    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }
}
