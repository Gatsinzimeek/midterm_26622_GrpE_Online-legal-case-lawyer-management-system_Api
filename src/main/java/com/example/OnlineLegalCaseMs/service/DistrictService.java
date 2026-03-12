package com.example.OnlineLegalCaseMs.service;

import com.example.OnlineLegalCaseMs.entity.District;
import com.example.OnlineLegalCaseMs.repository.DistrictRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    public District getDistrictById(Long id) {
        return districtRepository.findById(id).orElse(null);
    }

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    public District updateDistrict(Long id, District district) {
        district.setId(id);
        return districtRepository.save(district);
    }

    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }

    public List<District> getDistrictsByProvince(Long provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }
}
